package kr.khs.studyfarm.sign_up

import android.util.Log
import android.view.View
import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*
import kr.khs.studyfarm.network.*

class SignupViewModel(_email : String, _password : String) : ViewModel() {

    private val MAX_SIGN_UP = 3

    val email = MutableLiveData<String>()

    val password = MutableLiveData<String>()

    val nickname = ObservableField<String>()

    val introduce = ObservableField<String>()

    val age = ObservableField<String>()

    val necessaryCheck = ObservableField<BooleanArray>()

    val optionalCheck = ObservableField<BooleanArray>()

    private val step = MutableLiveData<Int>()

    val stepVisibility = ObservableField<IntArray>()

    val mainTitle = Transformations.map(step) {
        when(it) {
            1 -> "약관 동의"
            2 -> "기본 정보"
            3 -> "추가 정보"
            else -> ""
        }
    }

    val subTitle = Transformations.map(step) {
        when(it) {
            1 -> "앱 사용을 위 아래 항목에 동의해주세요."
            2 -> "스터디원과 공유할 회원님의 정보를 입력해주세요."
            3 -> "나와 딱 맞는 스터디를 가입할 수 있어요!"
            else -> ""
        }
    }

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

    init {
        email.value = _email
        password.value = _password
        necessaryCheck.set(BooleanArray(3) { false })
        optionalCheck.set(BooleanArray(2) { false })
        stepVisibility.set(IntArray(3) { if(it == 0) View.VISIBLE else View.GONE })
        step.value = 1
    }

    fun onNextBtnClicked() {
        if(step.value != MAX_SIGN_UP) {
            Log.d("SIGN_UP", step.value.toString())
            step.value = step.value!!.plus(1)
            stepVisibility.set(IntArray(3) { if(it == step.value!! - 1) View.VISIBLE else View.GONE })
        }
        else {
            val user = User(
                email = email.value!!,
                password = password.value!!,
                nickname = nickname.get()!!,
                name = nickname.get()!!,
                age = if(age.get() == null) 1.0 else age.get()!!.toDouble(),
                simpleIntroduce = if(introduce.get() == null) "" else introduce.get()!!,
                profile = null
            )

            addUser(user)
        }
    }

    private fun addUser(user: User) {
        coroutineScope.launch {
            try {
                _apiStatus.value = ApiStatus.LOADING
                _response.value = StudyFarmApi.retrofitService.addUser(user)
                _apiStatus.value = ApiStatus.DONE
            }
            catch (t : Throwable) {
                _apiStatus.value = ApiStatus.ERROR
                _error.value = errorHandling(t)
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        coroutineScope.cancel()
    }
}