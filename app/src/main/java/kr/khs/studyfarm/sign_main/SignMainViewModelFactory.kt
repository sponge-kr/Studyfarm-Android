package kr.khs.studyfarm.sign_main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class SignMainViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(SignMainViewModel::class.java))
            return SignMainViewModel() as T
        throw IllegalArgumentException("Unknown Class Name")
    }

}