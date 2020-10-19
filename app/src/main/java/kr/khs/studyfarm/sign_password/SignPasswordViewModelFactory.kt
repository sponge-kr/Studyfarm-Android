package kr.khs.studyfarm.sign_password

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class SignPasswordViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(SignPasswordViewModel::class.java))
            return SignPasswordViewModel() as T
        throw IllegalArgumentException("Unknown Class Name")
    }

}