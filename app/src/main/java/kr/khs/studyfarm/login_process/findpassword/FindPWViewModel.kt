package kr.khs.studyfarm.login_process.findpassword

import androidx.databinding.ObservableField
import androidx.lifecycle.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kr.khs.studyfarm.Rule
import kr.khs.studyfarm.network.ApiStatus
import kr.khs.studyfarm.network.StudyFarmApi
import kr.khs.studyfarm.network.StudyFarmApiService
import kr.khs.studyfarm.network.request.EmailData
import kr.khs.studyfarm.network.response.GetCodeResponse
import kr.khs.studyfarm.network.response.Response
import kr.khs.studyfarm.network.response.ResponseError
import kr.khs.studyfarm.network.response.errorHandling
import retrofit2.HttpException

class FindPWViewModel : ViewModel() {
    private val PROCESS_SIZE = 2

    private val _step = MutableLiveData<Int>()
    val step : LiveData<Int>
        get() = _step

    val processVisiblity = Transformations.map(step) {
        BooleanArray(PROCESS_SIZE) { step.value == it + 1 }
    }

    val title = Transformations.map(step) {
        when(it) {
            1 -> "비밀번호 인증코드를 받을\n계정 이메일 주소를 입력하세요."
            2 -> "비밀번호 재설정을 위한\n인증코드 메일을 보냈습니다."
            else -> "error"
        }
    }

    val subTitle = Transformations.map(step) {
        when(it) {
            2 -> "${email}로 메일을 전송했습니다."
            else -> ""
        }
    }

    val btnMsg = Transformations.map(step) {
        when(it) {
            1 -> "받기"
            2 -> "확인"
            else -> "error"
        }
    }

    val textField = ObservableField<String>()

    var email = ""

    val rule = Rule

    private val _setPW = MutableLiveData<Boolean>()
    val setPW : LiveData<Boolean>
        get() = _setPW

    private val _response = MutableLiveData<Response>()
    val response : LiveData<Response>
        get() = _response

    private val _response2 = MutableLiveData<GetCodeResponse>()
    val response2 : LiveData<GetCodeResponse>
        get() = _response2

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

    fun doneToast() {
        _toast.value = ""
    }

    fun onSendBtnClick() {
        if(step.value == 1) {
            sendCode()
        }
        else {
            checkCode()
        }
    }

    fun clear() {
        email = textField.get()!!
        textField.set("")

    }

    fun sendCode() {
        if(textField.get().isNullOrBlank()) {
            _toast.value = "이메일을 입력해주세요."
            return
        }

        coroutineScope.launch {
            try {
                _apiStatus.value = ApiStatus.LOADING
                val emailData = EmailData(textField.get()!!)
                _response.value = StudyFarmApi.retrofitService.sendCode(emailData)
                _apiStatus.value = ApiStatus.DONE
                clear()
                _step.value = _step.value?.plus(1)
            }
            catch (t : Throwable) {
                _apiStatus.value = ApiStatus.ERROR
                _toast.value = errorHandling(t).message
            }
        }
    }

    fun checkCode() {
        if(textField.get().isNullOrBlank()) {
            _toast.value = "인증 코드를 입력해주세요."
            return
        }
        coroutineScope.launch {
            try {
                _apiStatus.value = ApiStatus.LOADING
                _response2.value = StudyFarmApi.retrofitService.checkCode(email, textField.get()!!)
                _apiStatus.value = ApiStatus.DONE

                if(response2.value!!.result.checkResult)
                    doSetPW()
                else
                    _toast.value = "올바르지 않은 인증코드입니다."
            }
            catch (t : Throwable) {
                _apiStatus.value = ApiStatus.ERROR
                t.printStackTrace()
            }
        }
    }

    fun doSetPW() {
        _setPW.value = true
    }

    fun doneSetPW() {
        _setPW.value = false
    }

    init {
        _step.value = 1
        _setPW.value = false
    }
}

class FindPWViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(FindPWViewModel::class.java))
            return FindPWViewModel() as T
        throw IllegalArgumentException("Unknown Class Name")
    }

}