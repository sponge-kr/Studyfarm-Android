package kr.khs.studyfarm.login_process.sign_up_info

import android.content.Context
import android.os.Parcelable
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.databinding.ObservableField
import androidx.lifecycle.*
import kotlinx.android.parcel.Parcelize
import kotlinx.coroutines.*
import kr.khs.studyfarm.Gender
import kr.khs.studyfarm.login_process.select.SelectInfo
import kr.khs.studyfarm.network.*
import kr.khs.studyfarm.network.request.UserInfo
import kr.khs.studyfarm.network.response.Response
import kr.khs.studyfarm.network.response.ResponseError
import kr.khs.studyfarm.network.response.errorHandling
import java.util.*

class SignupInfoViewModel(val context : Context, val seq : Int, __cities : Array<SelectInfo>?, __interesting : Array<SelectInfo>?) : ViewModel() {

    private val MAX_CITY_CHOICE = 2
    private val MAX_STUDY_CHOICE = 3

    private val _cities = MutableLiveData<Array<SelectInfo>>()
    val citiesConverting : List<Int>
        get() {
            return List(_cities.value!!.size * 2) {
                if(it % 2 == 0)
                    _cities.value!![it / 2].parent.num
                else
                    _cities.value!![it / 2].children!!.num
            }
        }

    private val _interesting = MutableLiveData<Array<SelectInfo>>()
    val interesting : Array<Int>
        get() = Array(_interesting.value!!.size) { _interesting.value!![it].children!!.num }

    val interestingRating = ObservableField<Array<String>>()

    val cityTexts = Transformations.map(_cities) {
        Array(it.size) { idx -> it[idx].toString() }
    }
    val cityVisiblities = Transformations.map(_cities) {
        Array(MAX_CITY_CHOICE) { idx -> if(idx < it.size) View.VISIBLE else View.GONE }
    }
    val cityCountText = Transformations.map(_cities) {
        "${it.size} / $MAX_CITY_CHOICE"
    }

    val studyTexts = Transformations.map(_interesting) {
        Array(it.size) { idx -> it[idx].toString() }
    }
    val studyVisiblities = Transformations.map(_interesting) {
        Array(MAX_STUDY_CHOICE) { idx -> if(idx < it.size) View.VISIBLE else View.GONE }
    }
    val studyCountText = Transformations.map(_interesting) {
        "${it.size} / $MAX_STUDY_CHOICE"
    }

    // default : 0
    // 1 - city, 2 - interested -> 1은 false로 전달, 2은 true로 전달
    private val _cityOrInterested = MutableLiveData<Int>()
    val cityOrInterested : LiveData<Int>
        get() = _cityOrInterested

    val birthYear = ObservableField<Int>()

    var gender = Gender.Not

    val curYear = Calendar.getInstance()

    val years = Array(curYear.get(Calendar.YEAR) - 1900) { 1900 + it }.reversedArray()

    val yearSpinnerAdapter = ArrayAdapter(context, android.R.layout.simple_spinner_dropdown_item, years)

    val yearSpinnerOnItemSelectedListener = object : AdapterView.OnItemSelectedListener {
        override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            birthYear.set(years[position])
        }

        override fun onNothingSelected(parent: AdapterView<*>?) {

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
        val temp = List(interesting.size * 2) { i ->
            if(i % 2 == 0)
                interesting[i / 2]
            else
//                    interestingRating.value!![i / 2]
                interestingRating.get()!![i / 2].toInt()
        }
        val userInfo = UserInfo(
            birthYear = birthYear.get() ?: 0,
            cityInfo = citiesConverting,
            gender = gender.MW,
            interesting = temp,
        )

        addUserInfo(userInfo)

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
                _toast.value = errorHandling(t).message
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
        _isSignupSuccess.value = false
        _cityOrInterested.value = 0
        birthYear.set(2000)
        interestingRating.set(Array(MAX_STUDY_CHOICE) { "0" })
//        interestingRating.value = Array(MAX_CHOICE) { 0 }
    }

    override fun onCleared() {
        super.onCleared()
        coroutineScope.cancel()
        _toast.value = ""
    }
}

class SignupInfoViewModelFactory(private val context : Context,
                                 private val seq : Int,
                                 private val cities : Array<SelectInfo>?,
                                 private val interesting : Array<SelectInfo>?) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(SignupInfoViewModel::class.java))
            return SignupInfoViewModel(context, seq, cities, interesting) as T
        throw IllegalArgumentException("Unknown Class Name")
    }
}

@Parcelize
data class InfoData(val num : Int, val str : String, var children : List<InfoData> = listOf()) : Parcelable