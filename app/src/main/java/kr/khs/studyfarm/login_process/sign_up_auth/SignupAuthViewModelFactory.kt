package kr.khs.studyfarm.login_process.sign_up_auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class SignupAuthViewModelFactory(private val email : String) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(SignupAuthViewModel::class.java))
            return SignupAuthViewModel(email) as T
        throw IllegalArgumentException("Unknown Class Name")
    }

}