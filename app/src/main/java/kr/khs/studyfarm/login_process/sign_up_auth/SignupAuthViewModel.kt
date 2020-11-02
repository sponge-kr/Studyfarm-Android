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

    fun doNextBtnClicked() {
        if(check.get()!!)
            _nextBtnClicked.value = true
    }

    fun doneNextBtnClicked() {
        _nextBtnClicked.value = false
    }

    init {
        _nextBtnClicked.value = false
        email.value = _email
        check.set(false)
    }
}