package kr.khs.studyfarm.mainpage.study_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class StudyListViewModel : ViewModel() {

}

class StudyListViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(StudyListViewModel::class.java))
            return StudyListViewModel() as T
        throw IllegalArgumentException("Unknown Class Name")
    }

}