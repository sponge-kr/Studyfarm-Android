package kr.khs.studyfarm.login_process.sign_up_auth

import android.content.Context
import androidx.lifecycle.*
import kotlinx.coroutines.*
import kr.khs.studyfarm.R
import kr.khs.studyfarm.network.ApiStatus
import kr.khs.studyfarm.network.StudyFarmApi
import kr.khs.studyfarm.network.response.Response
import kr.khs.studyfarm.network.response.ResponseError
import kr.khs.studyfarm.network.response.errorHandling
import java.util.AbstractMap

class SignupAuthViewModel(val context : Context, _email : String) : ViewModel() {

    val email = MutableLiveData<String>()

    val subTitle = Transformations.map(email) {
        it + "으로 인증 메일을 발송했습니다."
    }

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

    private val _toast = MutableLiveData<String>()
    val toast : LiveData<String>
        get() = _toast

    fun doNextBtnClicked() {
        checkEmailActive(email.value!!)
    }

    private fun checkEmailActive(email : String) {
        coroutineScope.launch {
            try {
                _apiStatus.value = ApiStatus.LOADING
                _response.value = StudyFarmApi.retrofitService.checkEmailActive(email)
                _apiStatus.value = ApiStatus.DONE
                val temp = _response.value!!.result as AbstractMap<*, *>
                if(temp["check_result"] as Boolean)
                    _nextBtnClicked.value = true
                else
                    _toast.value = context.getString(R.string.signup_emailActiveCheck)
            }
            catch(t : Throwable) {
                _apiStatus.value = ApiStatus.ERROR
                _error.value = errorHandling(t)
            }
        }
    }

    fun doneNextBtnClicked() {
        _nextBtnClicked.value = false
    }

    fun doneToast() {
        _toast.value = ""
    }

    init {
        _nextBtnClicked.value = false
        _toast.value = ""
        email.value = _email
    }

    override fun onCleared() {
        super.onCleared()
        coroutineScope.cancel()
    }
}

class SignupAuthViewModelFactory(private val context : Context,
                                 private val email : String) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(SignupAuthViewModel::class.java))
            return SignupAuthViewModel(context, email) as T
        throw IllegalArgumentException("Unknown Class Name")
    }

}