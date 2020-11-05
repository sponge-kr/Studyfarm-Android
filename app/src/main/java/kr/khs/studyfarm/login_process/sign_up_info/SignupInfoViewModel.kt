package kr.khs.studyfarm.login_process.sign_up_info

import android.view.View
import android.widget.AdapterView
import androidx.databinding.ObservableField
import androidx.lifecycle.*
import kotlinx.coroutines.*
import kr.khs.studyfarm.Gender
import kr.khs.studyfarm.network.*
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

    val states = ObservableField<List<String>>()
    val statesInt = ObservableField<List<Int>>()

    val cities = ObservableField<List<String>>()
    val citiesInt = ObservableField<List<Int>>()

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

    private val _isSignupSuccess = MutableLiveData<Boolean>()
    val isSignupSuccess : LiveData<Boolean>
        get() = _isSignupSuccess

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
        _isSignupSuccess.value = false
        getStates()
        cities.set(listOf("시/도 부터 선택하세요."))
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
                _isSignupSuccess.value = true
            }
            catch (t : Throwable) {
                _apiStatus.value = ApiStatus.ERROR
                _error.value = errorHandling(t)
            }
        }
    }

    private fun getStates() {
        coroutineScope.launch {
            try {
                _apiStatus.value = ApiStatus.LOADING
                _response.value = StudyFarmApi.retrofitService.getStates()
                val abMap = _response.value!!.result as AbstractMap<*, *>
                val jsonState = abMap["content"] as ArrayList<*>
                states.set(List(jsonState.size + 1) { if(it == 0) "시/도 선택" else (jsonState[it - 1] as AbstractMap<*, *>)["name"] as String })
                statesInt.set(List(jsonState.size + 1) { if(it == 0) 0 else ((jsonState[it - 1] as AbstractMap<*, *>)["code"] as Double).toInt() })
                _apiStatus.value = ApiStatus.DONE
            }
            catch (t : Throwable) {
                _apiStatus.value = ApiStatus.ERROR
                _error.value = errorHandling(t)
            }
        }
    }

    private fun getCities(n : Int) {
        coroutineScope.launch {
            try {
                _apiStatus.value = ApiStatus.LOADING
                _response.value = StudyFarmApi.retrofitService.getCities(n)
                val abMap = _response.value!!.result as AbstractMap<*, *>
                val jsonCity = abMap["content"] as ArrayList<*>
                cities.set(List(jsonCity.size + 1) { if(it == 0) "세부 지역 선택" else (jsonCity[it - 1] as AbstractMap<*, *>)["name"] as String })
                citiesInt.set(List(jsonCity.size + 1) { if(it == 0) 0 else ((jsonCity[it - 1] as AbstractMap<*, *>)["code"] as Double).toInt() })
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

    val stateSelectedListener = object : AdapterView.OnItemSelectedListener {
        override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
            if(p2 != 0) {
                getCities(statesInt.get()!![p2])
            }
        }

        override fun onNothingSelected(p0: AdapterView<*>?) {

        }

    }
}

class SignupInfoViewModelFactory(private val email : String, private val password : String, private val nickname : String) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(SignupInfoViewModel::class.java))
            return SignupInfoViewModel(email, password, nickname) as T
        throw IllegalArgumentException("Unknown Class Name")
    }
}