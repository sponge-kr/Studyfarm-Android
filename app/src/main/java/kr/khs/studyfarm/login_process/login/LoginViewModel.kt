package kr.khs.studyfarm.login_process.login

import android.content.Context
import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.*
import kr.khs.studyfarm.R
import kr.khs.studyfarm.Rule
import kr.khs.studyfarm.network.*
import kr.khs.studyfarm.network.request.LoginData
import kr.khs.studyfarm.network.response.Response
import kr.khs.studyfarm.network.response.ResponseError

class LoginViewModel(val context : Context) : ViewModel() {

    val email = ObservableField<String>()

    val password = ObservableField<String>()

    val rule = Rule

    private val _gotoSignUp = MutableLiveData<Boolean>()
    val gotoSignUp : LiveData<Boolean>
        get() = _gotoSignUp

    private val _response = MutableLiveData<Response>()
    val response : LiveData<Response>
        get() = _response

    private val _error = MutableLiveData<ResponseError>()
    val error : LiveData<ResponseError>
        get() = _error

    private val _toast = MutableLiveData<String>()
    val toast : LiveData<String>
        get() = _toast

    //api status 변경에 따라 회원가입 로딩, 성공, 실패 -> observer을 통해서 처리하기 위함
    private val _apiStatus = MutableLiveData<ApiStatus>()
    val apiStatus : LiveData<ApiStatus>
        get() = _apiStatus

    private val job = Job()
    private val coroutineScope = CoroutineScope(job + Dispatchers.Main)

    fun onLoginBtnClick() {
        login()
    }

    private fun login() {
        coroutineScope.launch {
            try {
                _apiStatus.value = ApiStatus.LOADING
                _response.value = StudyFarmApi.retrofitService.loginUser(LoginData(email.get()!!, password.get()!!))
                _apiStatus.value = ApiStatus.DONE
            }
            catch (t : Throwable) {
                _apiStatus.value = ApiStatus.ERROR
                _toast.value = context.getString(R.string.login_error)
            }
        }
    }

    fun doGoToSignUp() {
        _gotoSignUp.value = true
    }

    fun doneGoToSignUp() {
        _gotoSignUp.value = false
    }

    fun doneToast() {
        _toast.value = ""
    }

    init {
        email.set("ks96ks@naver.com")
        password.set("gmltmd!23")
        _gotoSignUp.value = false
    }


    override fun onCleared() {
        super.onCleared()
        coroutineScope.cancel()
    }
}

class LoginViewModelFactory(private val context : Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(LoginViewModel::class.java))
            return LoginViewModel(context) as T
        throw IllegalArgumentException("Unknown Class Name")
    }
}