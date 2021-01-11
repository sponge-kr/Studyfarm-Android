package kr.khs.studyfarm.login_process.findpassword

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class SetPWViewModel : ViewModel() {
}

class SetPWViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(SetPWViewModel::class.java))
            return SetPWViewModel() as T
        throw IllegalArgumentException("Unknown Class Name")
    }

}