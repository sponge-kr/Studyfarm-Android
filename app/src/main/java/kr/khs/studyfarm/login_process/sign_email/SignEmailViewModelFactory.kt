package kr.khs.studyfarm.login_process.sign_email

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class SignEmailViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(SignEmailViewModel::class.java))
            return SignEmailViewModel() as T
        throw IllegalArgumentException("Unknown Class Name")
    }

}