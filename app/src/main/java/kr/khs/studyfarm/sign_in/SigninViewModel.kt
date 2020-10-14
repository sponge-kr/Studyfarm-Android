package kr.khs.studyfarm.sign_in

import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*
import kr.khs.studyfarm.network.*

class SigninViewModel : ViewModel() {

    val email = ObservableField<String>()

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

    private val _loginSuccess = MutableLiveData<Boolean>()
    val loginSuccess : LiveData<Boolean>
        get() = _loginSuccess

    private val _signUpBtnClicked = MutableLiveData<Boolean>()
    val signUpBtnClicked : LiveData<Boolean>
        get() = _signUpBtnClicked

    init {
        email.set("ks96ks@naver.com")
        password.set("rlagmltmd1!")
    }

    fun onSignUpBtnClicked() {
        _signUpBtnClicked.value = true
    }

    fun doneSignupBtnClicked() {
        _signUpBtnClicked.value = false
    }

    fun onLoginBtnClicked() {
        if(email.get() != null && password.get() != null
            && email.get()!!.isNotEmpty() && password.get()!!.isNotEmpty()) {
//            val hashMap = HashMap<String, String>()
//            hashMap["email"] = email.get()!!
//            hashMap["password"] = password.get()!!
            loginUser(LoginData(email.get()!!, password.get()!!))
        }
    }

    private fun loginUser(params : LoginData) {
        coroutineScope.launch {
            try {
                _apiStatus.value = ApiStatus.LOADING
                _response.value = StudyFarmApi.retrofitService.loginUser(params)
                _apiStatus.value = ApiStatus.DONE
            }
            catch (t : Throwable) {
                _apiStatus.value = ApiStatus.ERROR
                _error.value = errorHandling(t)
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        coroutineScope.cancel()
    }
}