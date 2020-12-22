package kr.khs.studyfarm.login_process.sign_up_auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class SignupAuthViewModel(_email : String) : ViewModel() {

    val email = MutableLiveData<String>()

    private val _nextBtnClicked = MutableLiveData<Boolean>()
    val nextBtnClicked : LiveData<Boolean>
        get() = _nextBtnClicked

    private val _toast = MutableLiveData<String>()
    val toast : LiveData<String>
        get() = _toast

    fun doNextBtnClicked() {
        _nextBtnClicked.value = true
    }

    fun doneNextBtnClicked() {
        _nextBtnClicked.value = false
    }

    fun doneToast() {
        _toast.value = ""
    }

    init {
        _nextBtnClicked.value = false
        _toast.value = ""
        email.value = _email
    }
}

class SignupAuthViewModelFactory(private val email : String) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(SignupAuthViewModel::class.java))
            return SignupAuthViewModel(email) as T
        throw IllegalArgumentException("Unknown Class Name")
    }

}