package kr.khs.studyfarm.login_process.sign_email

import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*
import kr.khs.studyfarm.Rule
import kr.khs.studyfarm.isEmailValidate
import kr.khs.studyfarm.network.*

class SignEmailViewModel : ViewModel() {

    val emailRule = Rule

    val email = ObservableField<String>()

    //0 default 1 회원가입 2 로그인
    private val _status = MutableLiveData<Int>()
    val status : LiveData<Int>
        get() = _status

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

    fun onNextBtnClicked() {
        if(!isEmailValidate(email.get()!!))
            _toast.value = "올바른 이메일 형식을 입력해주세요."
        else if(email.get() != null) {
            checkEmail(email.get()!!)
        }
    }

    private fun checkEmail(email : String) {
        coroutineScope.launch {
            try {
                _apiStatus.value = ApiStatus.LOADING
                _response.value = StudyFarmApi.retrofitService.checkEmail(email)
                _apiStatus.value = ApiStatus.DONE
                _status.value = 1
            }
            catch(t : Throwable) {
                _apiStatus.value = ApiStatus.ERROR
                _status.value = 2
                _error.value = errorHandling(t)
            }
        }
    }

    fun defaultStatus() {
        _status.value = 0
    }

    fun doneToast() {
        _toast.value = ""
    }

    init {
        email.set("simpson5304@naver.com")
        _toast.value = ""
    }

    override fun onCleared() {
        super.onCleared()
        coroutineScope.cancel()
    }
}