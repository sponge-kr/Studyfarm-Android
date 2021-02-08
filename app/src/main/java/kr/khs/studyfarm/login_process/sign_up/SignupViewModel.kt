package kr.khs.studyfarm.login_process.sign_up

import android.content.Context
import android.view.View
import androidx.databinding.Observable
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import androidx.lifecycle.*
import kotlinx.coroutines.*
import kr.khs.studyfarm.R
import kr.khs.studyfarm.Rule
import kr.khs.studyfarm.isEmailValidate
import kr.khs.studyfarm.isPasswordValidate
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

    private val _nextBtnActivated = MutableLiveData<Boolean>()
    val nextBtnActivated : LiveData<Boolean>
        get() = _nextBtnActivated

    //0 default 1 회원가입 2 로그인
    private val _status = MutableLiveData<Int>()
    val status : LiveData<Int>
        get() = _status

    private var isEmailValid = false
    private var isPasswordValid = false
    private var isNicknameValid = false

    private val callback = object : Observable.OnPropertyChangedCallback() {
        override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
            when (sender) {
                email -> {
                    isEmailValid = !email.get().isNullOrBlank() && isEmailValidate(email.get()!!)
                }
                password -> {
                    isPasswordValid = !password.get().isNullOrBlank() && isPasswordValidate(password.get()!!)
                }
                nickname -> {
                    isNicknameValid = !nickname.get().isNullOrBlank()
                }
            }

            nextBtnActivateCheck()
        }

    }

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

    private fun nextBtnActivateCheck() {
        _nextBtnActivated.value = isEmailValid && isPasswordValid && isNicknameValid && !duplicateNickname.get()
    }

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
                nextBtnActivateCheck()
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
                val temp = _response.value!!.result as AbstractMap<*, *>
                _status.value = if(!(temp["check_result"] as Boolean))
                    1
                else
                    2
            }
            catch(t : Throwable) {
                _apiStatus.value = ApiStatus.ERROR
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
        _nextBtnActivated.value = false
        nickname.addOnPropertyChangedCallback(callback)
        email.addOnPropertyChangedCallback(callback)
        password.addOnPropertyChangedCallback(callback)
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