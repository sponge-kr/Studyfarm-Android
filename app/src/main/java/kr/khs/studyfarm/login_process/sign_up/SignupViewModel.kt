package kr.khs.studyfarm.login_process.sign_up

import android.content.Context
import android.view.View
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.*
import kr.khs.studyfarm.R
import kr.khs.studyfarm.Rule
import kr.khs.studyfarm.isEmailValidate
import kr.khs.studyfarm.network.*
import kr.khs.studyfarm.network.response.Response
import kr.khs.studyfarm.network.response.ResponseError
import kr.khs.studyfarm.network.response.errorHandling
import java.util.AbstractMap

class SignupViewModel(val context : Context) : ViewModel() {

    val rule = Rule

    val email = ObservableField<String>()

    val password = ObservableField<String>()

    val nickname = ObservableField<String>()

    val duplicateNickname = ObservableBoolean()

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
            _toast.value = context.getString(R.string.signup_checkEmailForm)
        else if(email.get() != null) {
            checkEmail(email.get()!!)
        }
    }

    val nicknameFocusChangeListener = View.OnFocusChangeListener { view, b ->
        if(!b)
            checkNickName()
    }

    private fun checkNickName() {
        coroutineScope.launch {
            try {
                _apiStatus.value = ApiStatus.LOADING
                _response.value = StudyFarmApi.retrofitService.checkNickName(nickname.get().toString())
                val temp = _response.value!!.result as AbstractMap<*, *>
                duplicateNickname.set(temp["exist"] as Boolean)
                _apiStatus.value = ApiStatus.DONE
            }
            catch(t : Throwable) {
                _apiStatus.value = ApiStatus.ERROR
                println(t.localizedMessage)
                _error.value = errorHandling(t)
            }
        }
    }

    private fun checkEmail(email : String) {
        if(duplicateNickname.get()) {
            _toast.value = context.getString(R.string.signup_duplicateNickname)
            return
        }

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
        nickname.set("kimheeseung1")
        email.set("simpson5304@naver.com")
        password.set("gmltmd!23")
        _toast.value = ""
        duplicateNickname.set(false)
    }

    override fun onCleared() {
        super.onCleared()
        coroutineScope.cancel()
    }
}

class SignupViewModelFactory(private val context : Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(SignupViewModel::class.java))
            return SignupViewModel(context) as T
        throw IllegalArgumentException("Unknown Class Name")
    }

}