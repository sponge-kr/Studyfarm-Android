package kr.khs.studyfarm.sign_main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SignMainViewModel : ViewModel() {

    private val _goToEmail = MutableLiveData<Boolean>()
    val goToEmail : LiveData<Boolean>
        get() = _goToEmail

    fun onGoToEmail() {
        _goToEmail.value = true
    }

    fun doneGoToEmail() {
        _goToEmail.value = false
    }

    init {
        _goToEmail.value = false
    }
}