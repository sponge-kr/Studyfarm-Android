package kr.khs.studyfarm.sign_up_sample

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class SignupSampleViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(SignupSampleViewModel::class.java))
            return SignupSampleViewModel() as T
        throw IllegalArgumentException("Unknown Class Name")
    }
}