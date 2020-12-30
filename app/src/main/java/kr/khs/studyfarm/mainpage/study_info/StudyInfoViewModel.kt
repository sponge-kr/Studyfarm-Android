package kr.khs.studyfarm.mainpage.study_info

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class StudyInfoViewModel : ViewModel() {
}

class StudyInfoViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(StudyInfoViewModel::class.java))
            return StudyInfoViewModel() as T
        throw IllegalArgumentException("Unknown Class Name")
    }

}