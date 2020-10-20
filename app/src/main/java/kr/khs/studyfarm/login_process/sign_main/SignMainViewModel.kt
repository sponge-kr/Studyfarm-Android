package kr.khs.studyfarm.login_process.sign_main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SignMainViewModel : ViewModel() {
    private val _goToSignUp = MutableLiveData<Boolean>()
    val goToSignUp : LiveData<Boolean>
        get() = _goToSignUp

    private val _goToLogin = MutableLiveData<Boolean>()
    val goToLogin : LiveData<Boolean>
        get() = _goToLogin

    init {
        _goToLogin.value = false
        _goToSignUp.value = false
    }

    fun onSignUp() {
        _goToSignUp.value = true
    }

    fun onLogin() {
        _goToLogin.value = true
    }

    fun doneSignUp() {
        _goToSignUp.value = false
    }

    fun doneLogin() {
        _goToLogin.value = false
    }

    init {
        _goToSignUp.value = false
        _goToLogin.value = false
    }
}