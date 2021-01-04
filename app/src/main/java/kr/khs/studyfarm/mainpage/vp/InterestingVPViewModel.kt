package kr.khs.studyfarm.mainpage.vp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class InterestingVPViewModel : ViewModel() {
}

class InterestingVPViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(InterestingVPViewModel::class.java))
            return InterestingVPViewModel() as T
        throw IllegalArgumentException("Unknown Class Name")
    }

}