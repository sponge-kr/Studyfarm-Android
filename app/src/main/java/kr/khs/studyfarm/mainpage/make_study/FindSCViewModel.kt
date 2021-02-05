package kr.khs.studyfarm.mainpage.make_study

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class FindSCViewModel : ViewModel() {

}

class FindSSCViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(FindSCViewModel::class.java))
            return FindSCViewModel() as T
        throw IllegalArgumentException("Unknown Class Name")
    }

}