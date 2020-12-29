package kr.khs.studyfarm.noti_page

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class NotificationViewModel : ViewModel() {

}

class NotificationViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(NotificationViewModel::class.java))
            return NotificationViewModel() as T
        throw IllegalArgumentException("Unknown Class Name")
    }

}