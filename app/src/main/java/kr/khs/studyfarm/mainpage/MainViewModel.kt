package kr.khs.studyfarm.mainpage

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainViewModel() : ViewModel() {

}

class MainViewModelFactory() : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(MainViewModel::class.java))
            return MainViewModel() as T
        throw IllegalArgumentException("Unknown Class Name")
    }

}