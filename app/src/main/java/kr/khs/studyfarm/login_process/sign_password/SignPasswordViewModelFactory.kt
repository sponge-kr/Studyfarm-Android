package kr.khs.studyfarm.login_process.sign_password

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class SignPasswordViewModelFactory(private val email : String) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(SignPasswordViewModel::class.java))
            return SignPasswordViewModel(email) as T
        throw IllegalArgumentException("Unknown Class Name")
    }

}