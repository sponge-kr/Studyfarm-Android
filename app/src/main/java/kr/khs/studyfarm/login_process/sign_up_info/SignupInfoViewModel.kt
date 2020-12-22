package kr.khs.studyfarm.login_process.sign_up_info

import android.os.Parcelable
import android.view.View
import androidx.databinding.ObservableField
import androidx.lifecycle.*
import kotlinx.android.parcel.Parcelize
import kotlinx.coroutines.*
import kr.khs.studyfarm.Gender
import kr.khs.studyfarm.login_process.select.CityInfo
import kr.khs.studyfarm.network.*
import kr.khs.studyfarm.network.request.UserInfo
import kr.khs.studyfarm.network.response.Response
import kr.khs.studyfarm.network.response.ResponseError
import kr.khs.studyfarm.network.response.errorHandling

class SignupInfoViewModel(val seq : Int,__cities : Array<CityInfo>?, __interesting : Array<String>?) : ViewModel() {

    private val MAX_SIGN_UP = 2

    private val MAX_CITY_CHOICE = 3

    private val _cities = MutableLiveData<Array<CityInfo>>()
    val citiesConverting : List<Int>
        get() {
            return List(_cities.value!!.size * 2) {
                if(it % 2 == 0)
                    _cities.value!![it / 2].state.num
                else
                    _cities.value!![it / 2].city!!.num
            }
        }
    val cityTexts = Transformations.map(_cities) {
        Array(it.size) { idx -> it[idx].toString() }
    }
    val cityVisiblities = Transformations.map(_cities) {
        Array(3) { idx -> if(idx < it.size) View.VISIBLE else View.GONE }
    }

    private val _interesting = MutableLiveData<Array<String>>()
    val interesting : LiveData<Array<String>>
        get() = _interesting

    // default : 0
    // 1 - city, 2 - interested -> 1은 false로 전달, 2은 true로 전달
    private val _cityOrInterested = MutableLiveData<Int>()
    val cityOrInterested : LiveData<Int>
        get() = _cityOrInterested

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

    fun selectGender(g : Gender) {
        gender = g
    }

    fun onNextBtnClicked() {
        if(step.value != MAX_SIGN_UP) {
            step.value = step.value!!.plus(1)
            stepVisibility.set(IntArray(3) { if(it == step.value!! - 1) View.VISIBLE else View.GONE })
        }
        else {
            val userInfo = UserInfo(
                age = 1,
//                simpleIntroduce = introduce.get() ?: "",
//                profile = null,
                cityInfo = citiesConverting,
                gender = gender.MW,
//                serviceWay = serviceWay.get() ?: "",
//                studyPurpose = studyPurpose.get() ?: "",
                interesting = listOf(47,2,52,3),
            )

            addUserInfo(userInfo)
        }
    }

    private fun addUserInfo(userInfo: UserInfo) {
        coroutineScope.launch {
            try {
                _apiStatus.value = ApiStatus.LOADING
                _response.value = StudyFarmApi.retrofitService.addUserInfo(seq, userInfo)
                _apiStatus.value = ApiStatus.DONE
                _isSignupSuccess.value = true
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

    fun doSelectCity() {
        _cityOrInterested.value = 1
    }

    fun doSelectInteresting() {
        _cityOrInterested.value = 2
    }

    fun doneSelect() {
        _cityOrInterested.value = 0
    }

    init {
        _cities.value = __cities ?: arrayOf()
        _interesting.value = __interesting ?: arrayOf()
        stepVisibility.set(IntArray(2) { if(it == 0) View.VISIBLE else View.INVISIBLE })
        step.value = 1
        _isSignupSuccess.value = false
        _cityOrInterested.value = 0
    }

    override fun onCleared() {
        super.onCleared()
        coroutineScope.cancel()
        _toast.value = ""
    }
}

class SignupInfoViewModelFactory(private val seq : Int,
                                 private val cities : Array<CityInfo>?,
                                 private val interesting : Array<String>?) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(SignupInfoViewModel::class.java))
            return SignupInfoViewModel(seq, cities, interesting) as T
        throw IllegalArgumentException("Unknown Class Name")
    }
}

@Parcelize
data class StateData(val num : Int, val str : String, var children : List<StateData> = listOf()) : Parcelable