package kr.khs.studyfarm.login_process.sign_up_info

import android.annotation.SuppressLint
import android.view.View
import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*
import kr.khs.studyfarm.Gender
import kr.khs.studyfarm.network.*
import java.text.SimpleDateFormat
import java.util.*

class SignupInfoViewModel(_email : String, _password : String, _nickname : String) : ViewModel() {

    private val MAX_SIGN_UP = 2

    private val email = MutableLiveData<String>()

    private val password = MutableLiveData<String>()

    private val nickname = MutableLiveData<String>()

    val introduce = ObservableField<String>()

    private val step = MutableLiveData<Int>()

    val stepVisibility = ObservableField<IntArray>()

    var gender = Gender.Not

    val studyPurpose = ObservableField<String>()

    val serviceWay = ObservableField<String>()

    val mainTitle = Transformations.map(step) {
        when(it) {
            1 -> "기본 정보"
            2 -> "추가 정보"
            else -> ""
        }
    }

    val subTitle = Transformations.map(step) {
        when(it) {
            1 -> "스터디원과 공유할 회원님의 정보를 입력해주세요."
            2 -> "나와 딱 맞는 스터디를 가입할 수 있어요!"
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

    private val _toast = MutableLiveData<String>()
    val toast : LiveData<String>
        get() = _toast

    init {
        email.value = _email
        password.value = _password
        nickname.value = _nickname
        stepVisibility.set(IntArray(2) { if(it == 0) View.VISIBLE else View.GONE })
        step.value = 1
    }

    fun selectGender(g : Gender) {
        gender = g
    }

    fun onNextBtnClicked() {
        if(step.value != MAX_SIGN_UP) {
            step.value = step.value!!.plus(1)
            stepVisibility.set(IntArray(3) { if(it == step.value!! - 1) View.VISIBLE else View.GONE })
        }
        else {
//            val user = User(
//                email = email.value!!,
//                password = password.value!!,
//                nickname = nickname.get()!!,
//                name = nickname.get()!!,
//                age = 1.0,
//                simpleIntroduce = introduce.get() ?: "",
//                profile = null,
//                cityInfo = listOf(),
//                serviceAgree = true,
//                bornDate = "${year.get()}-${month.get()}-${day.get()}",
//                gender = gender.MW.toDouble(),
//                serviceWay = serviceWay.get() ?: "",
//                studyPurpose = studyPurpose.get() ?: "",
//                interesting = listOf(),
//            )
//
//            addUser(user)
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

    fun doneToast() {
        _toast.value = ""
    }

    override fun onCleared() {
        super.onCleared()
        coroutineScope.cancel()
        _toast.value = ""
    }
}