package kr.khs.studyfarm.mainpage.make_study

import android.content.Context
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.databinding.ObservableField
import androidx.lifecycle.*
import kotlinx.coroutines.*
import kr.khs.studyfarm.getAccessToken
import kr.khs.studyfarm.network.ApiStatus
import kr.khs.studyfarm.network.StudyFarmApi
import kr.khs.studyfarm.network.request.MakeStudyData
import kr.khs.studyfarm.network.response.*
import java.util.*

class MakeStudyViewModel(val context : Context, topics : Array<UserInterestingInfo>, areas : Array<UserCityInfo>) : ViewModel() {

    var numberOfPeople = 0

    private val numberArray = Array(10) { "${it + 1}명" }

    val numberAdapter = ArrayAdapter(context, android.R.layout.simple_spinner_dropdown_item, numberArray)

    val numberSpinnerOnItemSelectedListener = object : AdapterView.OnItemSelectedListener {
        override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            numberOfPeople = numberArray[position].substring(IntRange(0, numberArray[position].length - 2)).toInt()
        }

        override fun onNothingSelected(parent: AdapterView<*>?) { }
    }

    private val _typeOfRecruit = MutableLiveData<Int>()
    val typeOfRecruit : LiveData<Int>
        get() = _typeOfRecruit

    val deatilVisibility = Transformations.map(typeOfRecruit) {
        it != -1
    }

    private val _typeOfProgress = MutableLiveData<Int>()
    val typeOfProgress : LiveData<Int>
        get() = _typeOfProgress

    val offlineVisibility = Transformations.map(typeOfProgress) {
        it == 1
    }

    val step = ObservableField<String>()

    private val calendar = Calendar.getInstance()

    val startDate = MutableLiveData<String>()

    val endDate = MutableLiveData<String>()

    private var state : Array<Int> = Array(areas.size) { areas[it].stateCode.toInt() }
    private var _state = 0

    private  var city : Array<Int> = Array(areas.size) { areas[it].cityCode.toInt() }
    private var _city = 0

    private  var cityArray : Array<String> = Array(areas.size) { areas[it].toString() }

    val cityAdapter = ArrayAdapter(context, android.R.layout.simple_spinner_dropdown_item, cityArray)

    val citySpinnerOnItemSelectedListener = object : AdapterView.OnItemSelectedListener {
        override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            _state = state[position]
            _city = city[position]
        }

        override fun onNothingSelected(parent: AdapterView<*>?) { }
    }

    private var topic = 0
    private  var topicStr : Array<String> = Array(topics.size) { topics[it].name }
    private  var topicNum : Array<Int> = Array(topics.size) { topics[it].code.toInt() }

    val topicAdapter = ArrayAdapter(context, android.R.layout.simple_spinner_dropdown_item, topicStr)

    val topicSpinnerOnItemSelectedListener = object : AdapterView.OnItemSelectedListener {
        override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            topic = topicNum[position]
        }

        override fun onNothingSelected(parent: AdapterView<*>?) { }
    }

    private val _studyCafeSeq = MutableLiveData<Int>()
    val studyCafeSeq : LiveData<Int>
        get() = _studyCafeSeq

    val title = ObservableField<String>()

    val content = ObservableField<String>()

    private val _isMakeStudySuccess = MutableLiveData<Boolean>()
    val isMakeStudySuccess : LiveData<Boolean>
        get() = _isMakeStudySuccess

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

    fun selectTypeOfRecruit(checkIdx : Int) {
        _typeOfRecruit.value = checkIdx
    }

    fun selectTypeOfProgress(checkIdx : Int) {
        _typeOfProgress.value = checkIdx
    }

    fun onSubmitBtnClicked() {
        if(title.get().isNullOrBlank()
            || content.get().isNullOrBlank()
            || typeOfRecruit.value == null
            || step.get().isNullOrBlank()
            || startDate.value.isNullOrBlank()
            || endDate.value.isNullOrBlank()
            || _state == -1
            || _city == -1
            || topic == -1) {
            _toast.value = "정보를 모두 입력해 주세요."
            return
        }
        makeStudy()
    }

    private fun makeStudy() {
        coroutineScope.launch {
            try {
                _apiStatus.value = ApiStatus.LOADING
                var steps = arrayOf<Int>()
                if(step.get()!!.toInt() / 10 == 0)
                    steps += step.get()!!.toInt() - 1
                else {
                    val start = step.get()!!.toInt() / 10 - 1
                    val end = step.get()!!.toInt() % 10 - 1
                    for(i in start..end)
                        steps += i
                }
                val makeStudyDTO = MakeStudyData(
                    title = title.get()!!,
                    content = content.get()!!,
                    numberOfMemeber = numberOfPeople,
                    typeOfRecruit = typeOfRecruit.value!!,
                    typeOfProgress = typeOfProgress.value!!,
                    steps = steps,
                    startDate = startDate.value!!,
                    endDate = endDate.value!!,
                    state = _state,
                    city = _city,
                    topic = topic,
                    studyCafeSeq = studyCafeSeq.value ?: 0,
                )

                _response.value = StudyFarmApi.retrofitService.makeStudy("Bearer " + getAccessToken(context), makeStudyDTO)
                _apiStatus.value = ApiStatus.DONE
                _isMakeStudySuccess.value = true
            }
            catch(t : Throwable) {
                _apiStatus.value = ApiStatus.ERROR
                val error = errorHandling(t)
                _toast.value = error.message
            }
        }
    }

    fun doneToast() {
        _toast.value = ""
    }

    fun doneMakeStudy() {
        _isMakeStudySuccess.value = false
    }

    init {
        _typeOfRecruit.value = -1
        _typeOfProgress.value = -1
        step.set("0")
        startDate.value = "${calendar.get(Calendar.YEAR)}-${calendar.get(Calendar.MONTH) + 1}-${calendar.get(Calendar.DAY_OF_MONTH)}"
        endDate.value = "${calendar.get(Calendar.YEAR)}-${calendar.get(Calendar.MONTH) + 1}-${calendar.get(Calendar.DAY_OF_MONTH)}"
        _isMakeStudySuccess.value = false

//        state = Array(areas.size) { areas[it].stateCode.toInt() }
//        city = Array(areas.size) { areas[it].cityCode.toInt() }
//        cityArray = Array(areas.size) { areas[it].toString() }

//        topicNum = Array(topics.size) { topics[it].code.toInt() }
//        topicStr = Array(topics.size) { topics[it].name }
    }

    override fun onCleared() {
        super.onCleared()
        coroutineScope.cancel()
    }
}

class MakeStudyViewModelFactory(private val context : Context,
                                private val topics : Array<UserInterestingInfo>,
                                private val areas : Array<UserCityInfo>) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(MakeStudyViewModel::class.java))
            return MakeStudyViewModel(context, topics, areas) as T
        throw IllegalArgumentException("Unknown Class Name")
    }

}