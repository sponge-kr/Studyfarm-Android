package kr.khs.studyfarm.login_process.findpassword

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class FindPWViewModel : ViewModel() {
}

class FindPWViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(FindPWViewModel::class.java))
            return FindPWViewModel() as T
        throw IllegalArgumentException("Unknown Class Name")
    }

}