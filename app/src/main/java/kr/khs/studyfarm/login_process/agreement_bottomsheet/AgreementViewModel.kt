package kr.khs.studyfarm.login_process.agreement_bottomsheet

import android.content.Context
import android.view.View
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import androidx.lifecycle.*
import kotlinx.coroutines.*
import kr.khs.studyfarm.R
import kr.khs.studyfarm.network.*
import kr.khs.studyfarm.network.request.User
import kr.khs.studyfarm.network.response.Response
import kr.khs.studyfarm.network.response.ResponseError
import java.util.AbstractMap

/*
참고 : https://medium.com/@dev.ksw/android-%EB%8F%99%EC%A0%81-%EC%9D%B4%EC%9A%A9%EC%95%BD%EA%B4%80-%EB%A7%8C%EB%93%A4%EA%B8%B0-8913eb66a63a
 */
class AgreementViewModel(val context: Context,
                         val email : String, val password : String, val nickname : String) : ViewModel() {

    val checked = ObservableField<BooleanArray>()

    val termsList = arrayListOf(
        TermsData(1, "이용약관1", true, "이용약관1"),
        TermsData(2, "이용약관2", true, "이용약관2"),
        TermsData(3, "이용약관3", false, "이용약관3"),
        TermsData(4, "이용약관4", false, "이용약관4"),
    )

    private val requiredTermsCount = termsList.filter { it.required }.size

    val allAgreeChecked = ObservableBoolean(false)
    val btnEnable = ObservableBoolean(false)

    fun onTermsItemCheckBoxClickListener(view: View) {
        termsList.let { list ->
            allAgreeChecked.set(list.filter { it.checked.get() }.size == list.size)
            btnEnable.set(list.filter { it.checked.get() && it.required }.size == requiredTermsCount)
        }
    }

    fun onAllAgreeCheckBoxListener(view: View) {
        termsList.let {
            it.forEach { termsData ->
                termsData.checked.set(allAgreeChecked.get())
            }
            btnEnable.set(allAgreeChecked.get())
        }
    }

    private val _toast = MutableLiveData<String>()
    val toast : LiveData<String>
        get() = _toast

    private val _nextBtnClicked = MutableLiveData<Boolean>()
    val nextBtnClicked : LiveData<Boolean>
        get() = _nextBtnClicked

    private val _response = MutableLiveData<Response>()
    val response : LiveData<Response>
        get() = _response

    private val _error = MutableLiveData<ResponseError>()
    val error : LiveData<ResponseError>
        get() = _error

    //api status 변경에 따라 회원가입 로딩, 성공, 실패 -> observer을 통해서 처리하기 위함
    private val _apiStatus = MutableLiveData<ApiStatus>()
    val apiStatus : LiveData<ApiStatus>
        get() = _apiStatus

    private val job = Job()
    private val coroutineScope = CoroutineScope(job + Dispatchers.Main)

    var seq = -1

    fun doNextBtnClicked() {
//        for(i in 0 until NECESSARY)
//            if(!checked.get()!![i]) {
//                _toast.value = context.getString(R.string.agreement_necessary)
//                return
//            }

        addUser(User(
            email,
            password,
            nickname,
            true
        ))
    }

    fun doneNextBtnClicked() {
        _nextBtnClicked.value = false
    }

    fun doneToast() {
        _toast.value = ""
    }

    private fun addUser(user: User) {
        coroutineScope.launch {
            try {
                _apiStatus.value = ApiStatus.LOADING
                _response.value = StudyFarmApi.retrofitService.addUser(user)
                val abMap = _response.value!!.result as AbstractMap<*, *>
                seq = (abMap["users_seq"] as Double).toInt()
                println(seq)
                _apiStatus.value = ApiStatus.DONE
                _nextBtnClicked.value = true
            }
            catch (t : Throwable) {
                _apiStatus.value = ApiStatus.ERROR
            }
        }
    }

    init {
        _toast.value = ""
        _nextBtnClicked.value = false
    }

    override fun onCleared() {
        super.onCleared()
        coroutineScope.cancel()
        _toast.value = ""
    }
}

class AgreementViewModelFactory(
    private val context : Context,
    private val email : String,
    private val password : String,
    private val nickname : String
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(AgreementViewModel::class.java))
            return AgreementViewModel(context, email, password, nickname) as T
        throw IllegalArgumentException("Unknown Class Name")
    }

}

data class TermsData(
    val termsSequence : Int,
    val termsTitle : String,
    val required : Boolean,
    val content : String,
    val checked : ObservableBoolean = ObservableBoolean(false)
)