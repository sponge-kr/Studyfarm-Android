package kr.khs.studyfarm.sign_password

import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*
import kr.khs.studyfarm.network.*

class SignPasswordViewModel : ViewModel() {
    val email = MutableLiveData<String>()

    val password = ObservableField<String>()

    //true면 로그인, false면 회원가입
    val loginOrSignup = MutableLiveData<Boolean>()

    val subtitle = Transformations.map(loginOrSignup) {
        if(it)
            "입력하신 이메일의 비밀번호를 입력해주세요."
        else
            "스터디팜에서 사용할 비밀번호입니다.\n1번만 입력하니 정확히 입력해주세요."
    }

    private val job = Job()
    private val coroutineScope = CoroutineScope(Dispatchers.Main + job)

    private val _apiStatus = MutableLiveData<ApiStatus>()
    val apiStatus : LiveData<ApiStatus>
        get() = _apiStatus

    private val _response = MutableLiveData<Response>()
    val response : LiveData<Response>
        get() = _response

    private val _error = MutableLiveData<ResponseError>()
    val error : LiveData<ResponseError>
        get() = _error

    private val _loginProcess = MutableLiveData<Boolean>()
    val loginProcess : LiveData<Boolean>
        get() = _loginProcess

    private val _signupProcess = MutableLiveData<Boolean>()
    val signupProcess : LiveData<Boolean>
        get() = _signupProcess

    fun onNextBtnClicked() {
        if(loginOrSignup.value!!) {
            onLogin()
        }
        else {
            _signupProcess.value = true
        }
    }

    private fun onLogin() {
        coroutineScope.launch {
            try {
                _apiStatus.value = ApiStatus.LOADING
                _response.value = StudyFarmApi.retrofitService.loginUser(LoginData(email.value!!, password.get()!!))
                _apiStatus.value = ApiStatus.DONE
                _loginProcess.value = true
            }
            catch(t : Throwable) {
                _apiStatus.value = ApiStatus.ERROR
            }
        }
    }

    init {
        password.set("rlagmltmd1!")
    }

    override fun onCleared() {
        super.onCleared()
        coroutineScope.cancel()
        _loginProcess.value = false
    }
}