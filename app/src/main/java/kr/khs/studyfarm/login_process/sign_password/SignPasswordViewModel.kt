package kr.khs.studyfarm.login_process.sign_password

import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*
import kr.khs.studyfarm.Rule
import kr.khs.studyfarm.isPasswordValidate
import kr.khs.studyfarm.network.*

class SignPasswordViewModel(_email : String) : ViewModel() {

    val passwordRule = Rule

    val email = MutableLiveData<String>()

    val password = ObservableField<String>()

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

    private val _signupProcess = MutableLiveData<Boolean>()
    val signupProcess : LiveData<Boolean>
        get() = _signupProcess

    private val _toast = MutableLiveData<String>()
    val toast : LiveData<String>
        get() = _toast

    fun onNextBtnClicked() {
        if(password.get() == null || !isPasswordValidate(password.get()!!)) {
            _toast.value = "올바른 비밀번호 형식이 아닙니다."
        }
        else
            _signupProcess.value = true
    }

    fun doneSignupProcess() {
        _signupProcess.value = false
    }

    fun doneToast() {
        _toast.value = ""
    }

    init {
        email.value = _email
        _toast.value = ""
        password.set("rlagmltmd1!")
    }

    override fun onCleared() {
        super.onCleared()
        coroutineScope.cancel()
        _signupProcess.value = false
    }
}