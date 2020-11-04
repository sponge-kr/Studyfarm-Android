package kr.khs.studyfarm.login_process.agreement_bottomsheet

import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class AgreementViewModel : ViewModel() {

    val CHECK_BOX_SIZE = 4 // 체크 갯수
    val NECESSARY = 2 // 필수인 갯수

    val checked = ObservableField<BooleanArray>()

    private val _toast = MutableLiveData<String>()
    val toast : LiveData<String>
        get() = _toast

    private val _nextBtnClicked = MutableLiveData<Boolean>()
    val nextBtnClicked : LiveData<Boolean>
        get() = _nextBtnClicked

    fun allCheck() {
        var flag = true
        for(b in checked.get()!!)
            if(!b) {
                flag = false
                break
            }

        checked.set(BooleanArray(CHECK_BOX_SIZE) { !flag })
    }

    fun doNextBtnClicked() {
        for(i in 0 until NECESSARY)
            if(!checked.get()!![i]) {
                _toast.value = "필수 약관에 모두 동의해주셔야합니다."
                return
            }

        _nextBtnClicked.value = true
    }

    fun doneNextBtnClicked() {
        _nextBtnClicked.value = false
    }

    fun doneToast() {
        _toast.value = ""
    }

    init {
        checked.set(BooleanArray(CHECK_BOX_SIZE))
        _toast.value = ""
        _nextBtnClicked.value = false
    }
}

class AgreementViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(AgreementViewModel::class.java))
            return AgreementViewModel() as T
        throw IllegalArgumentException("Unknown Class Name")
    }

}