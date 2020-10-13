package kr.khs.studyfarm.sign_in

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class SigninViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(SigninViewModel::class.java))
            return SigninViewModel() as T
        throw IllegalArgumentException("Unknown Class Name")
    }

}