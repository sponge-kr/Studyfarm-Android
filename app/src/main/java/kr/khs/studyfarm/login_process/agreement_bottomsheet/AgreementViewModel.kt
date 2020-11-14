package kr.khs.studyfarm.login_process.agreement_bottomsheet

import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.*
import kr.khs.studyfarm.network.*
import java.util.AbstractMap

class AgreementViewModel(val email : String, val password : String, val nickname : String) : ViewModel() {

    val CHECK_BOX_SIZE = 4 // 체크 갯수
    val NECESSARY = 2 // 필수인 갯수

    val checked = ObservableField<BooleanArray>()

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

    fun allCheck() {
        var flag = true
        for(b in checked.get()!!)
            if(!b) {
                flag = false
                break
            }

        checked.set(BooleanArray(CHECK_BOX_SIZE) { !flag })
    }

    fun doNextBtnClicked() {
        for(i in 0 until NECESSARY)
            if(!checked.get()!![i]) {
                _toast.value = "필수 약관에 모두 동의해주셔야합니다."
                return
            }

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
                _error.value = errorHandling(t)
            }
        }
    }

    init {
        checked.set(BooleanArray(CHECK_BOX_SIZE))
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
    private val email : String,
    private val password : String,
    private val nickname : String
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(AgreementViewModel::class.java))
            return AgreementViewModel(email, password, nickname) as T
        throw IllegalArgumentException("Unknown Class Name")
    }

}