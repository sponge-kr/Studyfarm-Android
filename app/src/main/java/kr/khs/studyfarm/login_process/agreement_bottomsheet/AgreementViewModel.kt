package kr.khs.studyfarm.login_process.agreement_bottomsheet

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class AgreementViewModel : ViewModel() {

}

class AgreementViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(AgreementViewModel::class.java))
            return AgreementViewModel() as T
        throw IllegalArgumentException("Unknown Class Name")
    }

}