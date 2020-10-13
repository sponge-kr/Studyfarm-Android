package kr.khs.studyfarm.sign_in

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SigninViewModel : ViewModel() {

    private val _signUpBtnClicked = MutableLiveData<Boolean>()
    val signUpBtnClicked : LiveData<Boolean>
        get() = _signUpBtnClicked

    fun onSignUpBtnClicked() {
        _signUpBtnClicked.value = true
    }

    fun doneSignupBtnClicked() {
        _signUpBtnClicked.value = false
    }
}