package kr.khs.studyfarm.mainpage.make_study

import android.content.Context
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel
import kr.khs.studyfarm.network.ApiStatus
import kr.khs.studyfarm.network.response.GetUserResponse
import kr.khs.studyfarm.network.response.ResponseError

class MakeStudyViewModel(context : Context) : ViewModel() {

    var numberOfPeople = 0

    val numberArray = Array(20) { "${it + 1}명" }

    val numberAdapter = ArrayAdapter(context, android.R.layout.simple_spinner_dropdown_item, numberArray)

    val numberSpinnerOnItemSelectedListener = object : AdapterView.OnItemSelectedListener {
        override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            numberOfPeople = numberArray[position].substring(IntRange(0, numberArray[position].length - 1)).toInt()
        }

        override fun onNothingSelected(parent: AdapterView<*>?) {

        }
    }

    private val _typeOfRecruit = MutableLiveData<Int>()
    val typeOfRecruit : LiveData<Int>
        get() = _typeOfRecruit

    private val _typeOfProgress = MutableLiveData<Int>()
    val typeOfProgress : LiveData<Int>
        get() = _typeOfProgress

    val step = ObservableField<Int>()

    val startDate = ObservableField<String>()

    val endDate = ObservableField<String>()

    private val _state = MutableLiveData<Int>()
    val state : LiveData<Int>
        get() = _state

    private val _city = MutableLiveData<Int>()
    val city : LiveData<Int>
        get() = _city

    private val _topic = MutableLiveData<Int>()
    val topic : LiveData<Int>
        get() = _topic

    private val _studyCafeSeq = MutableLiveData<Int>()
    val studyCafeSeq : LiveData<Int>
        get() = _studyCafeSeq

    private val _response = MutableLiveData<GetUserResponse>()
    val response : LiveData<GetUserResponse>
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

    init {
        _typeOfRecruit.value = -1
        _typeOfProgress.value = -1
    }

    override fun onCleared() {
        super.onCleared()
        coroutineScope.cancel()
    }
}

class MakeStudyViewModelFactory(private val context : Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(MakeStudyViewModel::class.java))
            return MakeStudyViewModel(context) as T
        throw IllegalArgumentException("Unknwon Class Name")
    }

}