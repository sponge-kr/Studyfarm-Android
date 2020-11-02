package kr.khs.studyfarm.login_process.sign_up_auth

import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SignupAuthViewModel(_email : String) : ViewModel() {

    val email = MutableLiveData<String>()

    val check = ObservableField<Boolean>()

    private val _nextBtnClicked = MutableLiveData<Boolean>()
    val nextBtnClicked : LiveData<Boolean>
        get() = _nextBtnClicked

    private val _toast = MutableLiveData<String>()
    val toast : LiveData<String>
        get() = _toast

    fun doNextBtnClicked() {
        if(check.get()!!)
            _nextBtnClicked.value = true
        else
            _toast.value = "필수 약관을 체크해주세요."
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
        check.set(false)
    }
}