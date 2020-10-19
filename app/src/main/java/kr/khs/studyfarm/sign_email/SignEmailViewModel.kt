package kr.khs.studyfarm.sign_email

import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*
import kr.khs.studyfarm.network.*

class SignEmailViewModel : ViewModel() {

    val email = ObservableField<String>()

    //true면 로그인, false면 회원가입
    private val _status = MutableLiveData<Boolean>()
    val status : LiveData<Boolean>
        get() = _status

    private val _response = MutableLiveData<Response>()
    val response : LiveData<Response>
        get() = _response

    private val _error = MutableLiveData<ResponseError>()
    val error : LiveData<ResponseError>
        get() = _error

    //api status 변경에 따라 회원가입 로딩, 성공, 실패 -> observer을 통해서 처리하기 위함
    private val _apiStatus = MutableLiveData<ApiStatus>()
    val apiStatus : LiveData<ApiStatus>
        get() = _apiStatus

    private val job = Job()
    private val coroutineScope = CoroutineScope(job + Dispatchers.Main)

    fun onNextBtnClicked() {
        if(email.get() != null) {
            checkEmail(email.get()!!)
        }
    }

    private fun checkEmail(email : String) {
        coroutineScope.launch {
            try {
                _apiStatus.value = ApiStatus.LOADING
                _response.value = StudyFarmApi.retrofitService.checkEmail(email)
                _apiStatus.value = ApiStatus.DONE
                _status.value = false
            }
            catch(t : Throwable) {
                _apiStatus.value = ApiStatus.ERROR
                _status.value = true
                _error.value = errorHandling(t)
            }
        }
    }

    init {
        email.set("ks96ks@naver.com")
    }

    override fun onCleared() {
        super.onCleared()
        coroutineScope.cancel()
    }
}