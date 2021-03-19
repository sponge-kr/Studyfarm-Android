package kr.khs.studyfarm.login_process.findpassword

import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kr.khs.studyfarm.Rule
import kr.khs.studyfarm.network.ApiStatus
import kr.khs.studyfarm.network.StudyFarmApi
import kr.khs.studyfarm.network.request.PasswordData
import kr.khs.studyfarm.network.response.Response
import kr.khs.studyfarm.network.response.ResponseError
import kr.khs.studyfarm.network.response.errorHandling

class SetPWViewModel(private val email : String) : ViewModel() {

    val rule = Rule

    val password = ObservableField<String>()

    private val _successSetPW = MutableLiveData<Boolean>()
    val successSetPW : LiveData<Boolean>
        get() = _successSetPW

    private val _response = MutableLiveData<Response>()
    val response : LiveData<Response>
        get() = _response

    private val _error = MutableLiveData<ResponseError>()
    val error : LiveData<ResponseError>
        get() = _error

    private val _toast = MutableLiveData<String>()
    val toast : LiveData<String>
        get() = _toast

    //api status 변경에 따라 회원가입 로딩, 성공, 실패 -> observer을 통해서 처리하기 위함
    private val _apiStatus = MutableLiveData<ApiStatus>()
    val apiStatus : LiveData<ApiStatus>
        get() = _apiStatus

    private val job = Job()
    private val coroutineScope = CoroutineScope(job + Dispatchers.Main)

    fun onBtnClick() {
        if(password.get().isNullOrBlank()) {
            _toast.value = "변경할 비밀번호를 입력해주세요."
            return
        }

        coroutineScope.launch {
            try {
                _apiStatus.value = ApiStatus.LOADING
                _response.value = StudyFarmApi.retrofitService.setNewPW(email, PasswordData(password.get()!!))
                _apiStatus.value = ApiStatus.DONE
                successSetPW()
            }
            catch(t : Throwable) {
                _apiStatus.value = ApiStatus.ERROR
                errorHandling(t).apply {
                    _toast.value = this.message
                }
                t.printStackTrace()
            }
        }
    }

    private fun successSetPW() {
        _toast.value = "비밀번호 변경이 완료되었습니다."
        _successSetPW.value = true
    }

    fun doneSuccessSetPW() {
        _successSetPW.value = false
    }

    fun doneToast() {
        _toast.value = ""
    }

    init {
        _successSetPW.value = false
    }
}

class SetPWViewModelFactory(private val email : String) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(SetPWViewModel::class.java))
            return SetPWViewModel(email) as T
        throw IllegalArgumentException("Unknown Class Name")
    }

}