package kr.khs.studyfarm.login_process.sign_up

import android.annotation.SuppressLint
import android.util.Log
import android.view.View
import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import kotlinx.android.synthetic.main.fragment_signup.view.*
import kotlinx.coroutines.*
import kr.khs.studyfarm.Gender
import kr.khs.studyfarm.R
import kr.khs.studyfarm.network.*
import java.text.SimpleDateFormat
import java.util.*

@SuppressLint("SimpleDateFormat")
class SignupViewModel(_email : String, _password : String) : ViewModel() {

    private val MAX_SIGN_UP = 3

    val email = MutableLiveData<String>()

    val password = MutableLiveData<String>()

    val nickname = ObservableField<String>()

    val introduce = ObservableField<String>()

    val necessaryCheck = ObservableField<BooleanArray>()

    val optionalCheck = ObservableField<BooleanArray>()

    private val step = MutableLiveData<Int>()

    val stepVisibility = ObservableField<IntArray>()

    val year = ObservableField<Int>()
    val month = ObservableField<Int>()
    val day = ObservableField<Int>()

    var gender = Gender.Not

    val studyPurpose = ObservableField<String>()

    val serviceWay = ObservableField<String>()

    val interestedStudy = ObservableField<Array<String>>()

    val chipGroupId = ObservableField<Int>()
    val chips = MutableLiveData<ArrayList<String>>()

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

    private val _toast = MutableLiveData<String>()
    val toast : LiveData<String>
        get() = _toast

    init {
        email.value = _email
        password.value = _password
        necessaryCheck.set(BooleanArray(3) { true })
        optionalCheck.set(BooleanArray(2) { false })
        stepVisibility.set(IntArray(3) { if(it == 0) View.VISIBLE else View.GONE })
        step.value = 1
        val time = SimpleDateFormat("yyyy-MM-dd").format(Date())
        year.set(time.split("-")[0].toInt())
        month.set(time.split("-")[1].toInt())
        day.set(time.split("-")[2].toInt())

        //나중에 db연결
        interestedStudy.set(arrayOf("- 스터디 선택 -", "웹 개발", "안드로이드 개발", "ios 개발", "디자인"))
        chips.value = arrayListOf()
        chipGroupId.set(R.id.signup_chipgroup_interested)
    }

    fun selectGender(g : Gender) {
        gender = g
    }

    fun onNextBtnClicked() {
        if(step.value != MAX_SIGN_UP) {
            for(check in necessaryCheck.get()!!)
                if(!check) {
                    _toast.value = "필수 약관에 모두 동의하셔야 합니다."
                    return
                }
            step.value = step.value!!.plus(1)
            stepVisibility.set(IntArray(3) { if(it == step.value!! - 1) View.VISIBLE else View.GONE })
        }
        else {
            val interestingList = List(chips.value!!.size) { Interesting(chips.value!![it], "") }
            val user = User(
                email = email.value!!,
                password = password.value!!,
                nickname = nickname.get()!!,
                name = nickname.get()!!,
                age = 1.0,
                simpleIntroduce = introduce.get() ?: "",
                profile = null,
                cityInfo = listOf(),
                serviceAgree = true,
                bornDate = "${year.get()}-${month.get()}-${day.get()}",
                gender = gender.MW.toDouble(),
                serviceWay = serviceWay.get() ?: "",
                studyPurpose = studyPurpose.get() ?: "",
                interesting = interestingList,
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

    fun doneToast() {
        _toast.value = ""
    }

    override fun onCleared() {
        super.onCleared()
        coroutineScope.cancel()
        _toast.value = ""
    }
}