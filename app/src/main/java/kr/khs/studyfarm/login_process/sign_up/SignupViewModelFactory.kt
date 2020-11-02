package kr.khs.studyfarm.login_process.sign_up

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class SignupViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(SignupViewModel::class.java))
            return SignupViewModel() as T
        throw IllegalArgumentException("Unknown Class Name")
    }

}