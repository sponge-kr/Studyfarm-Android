package kr.khs.studyfarm.mainpage.make_study

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MakeStudyViewModel : ViewModel() {

}

class MakeStudyViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(MakeStudyViewModel::class.java))
            return MakeStudyViewModel() as T
        throw IllegalArgumentException("Unknwon Class Name")
    }

}