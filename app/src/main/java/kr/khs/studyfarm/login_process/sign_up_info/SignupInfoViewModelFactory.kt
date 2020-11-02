package kr.khs.studyfarm.login_process.sign_up_info

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class SignupInfoViewModelFactory(private val email : String, private val password : String, private val nickname : String) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(SignupInfoViewModel::class.java))
            return SignupInfoViewModel(email, password, nickname) as T
        throw IllegalArgumentException("Unknown Class Name")
    }
}