package kr.khs.studyfarm.sign_up

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class SignupViewModelFactory(private val email : String, private val password : String) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(SignupViewModel::class.java))
            return SignupViewModel(email, password) as T
        throw IllegalArgumentException("Unknown Class Name")
    }
}