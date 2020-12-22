package kr.khs.studyfarm.login_process.select

import android.content.Context
import android.os.Parcelable
import androidx.lifecycle.*
import kotlinx.android.parcel.Parcelize
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kr.khs.studyfarm.R
import kr.khs.studyfarm.login_process.sign_up_info.StateData
import kr.khs.studyfarm.network.*
import kr.khs.studyfarm.network.response.Response
import kr.khs.studyfarm.network.response.ResponseError
import kr.khs.studyfarm.network.response.errorHandling
import java.util.AbstractMap
import java.util.ArrayList

class SelectViewModel(val context : Context, private val cityOrInterested : Boolean, _cityInit : Array<CityInfo>?) : ViewModel() {
    private val _returnSignup = MutableLiveData<Boolean>()
    val returnSignup : LiveData<Boolean>
        get() = _returnSignup

    val stateList = MutableLiveData<List<StateData>>()

    val cityList = MutableLiveData<List<StateData>>()

    val _selectCity = MutableLiveData<ArrayList<CityInfo>>()
    val selectCity : Array<CityInfo>
        get() = Array(_selectCity.value!!.size) { _selectCity.value!![it] }
    var cur : CityInfo? = null

    val chipVisible = MutableLiveData<List<Boolean>>()

    private val _response = MutableLiveData<Response>()
    val response : LiveData<Response>
        get() = _response

    private val _error = MutableLiveData<ResponseError>()
    val error : LiveData<ResponseError>
        get() = _error

    private val _apiStatus = MutableLiveData<ApiStatus>()
    val apiStatus : LiveData<ApiStatus>
        get() = _apiStatus

    private val job = Job()
    private val coroutineScope = CoroutineScope(job + Dispatchers.Main)

    private val _toast = MutableLiveData<String>()
    val toast : LiveData<String>
        get() = _toast

    fun gotoSignup() {
        _returnSignup.value = true
    }

    fun doneSignup() {
        _returnSignup.value = false
    }

    private fun getStates() {
        coroutineScope.launch {
            try {
                _apiStatus.value = ApiStatus.LOADING
                _response.value = StudyFarmApi.retrofitService.getStates()
                val abMap = _response.value!!.result as AbstractMap<*, *>
                val jsonState = abMap["content"] as ArrayList<*>
                stateList.value = (List(jsonState.size) { StateData(
                    ((jsonState[it] as AbstractMap<*, *>)["code"] as Double).toInt(),
                    (jsonState[it] as AbstractMap<*, *>)["name"] as String,
                )})

                for(i in 0 until jsonState.size) {
                    val list = ArrayList<StateData>()
                    val temp = (jsonState[i] as AbstractMap<*, *>)["children"] as ArrayList<*>
                    for(j in 0 until temp.size) {
                        val split = temp[j].toString().split("{", "=", ",", "}")
                        list.add(StateData(
                            split[2].toDouble().toInt(),
                            split[4]
                        ))
                    }
                    stateList.value!![i].children = list
                }
                _apiStatus.value = ApiStatus.DONE
            }
            catch (t : Throwable) {
                _apiStatus.value = ApiStatus.ERROR
                _error.value = errorHandling(t)
            }
        }
    }

    fun onStateSelect(data : StateData) {
        cur = CityInfo(data)
        if(data.children.isEmpty()) {
            onCitySelect(StateData(0, ""))
        }
        else {
            cityList.value = data.children
        }
    }

    fun onCitySelect(data : StateData) {
        cur!!.city = data
        if(_selectCity.value?.size == 3) {
            _toast.value = context.getString(R.string.select_maxsize)
            return
        }
        for (city in _selectCity.value!!) {
            if (cur!!.state.num == city.state.num && cur!!.city!!.num == city.city!!.num) {
                _toast.value = context.getString(R.string.select_duplicateCity)
                return
            }
        }
        _selectCity.value!!.add(cur!!.copy())
        chipUpdate()
    }

    fun doneToast() {
        _toast.value = ""
    }

    val chipUpdateListener : () -> Unit = {
        chipUpdate()
    }

    fun chipUpdate() {
        chipVisible.value = List(3) { idx -> idx < _selectCity.value!!.size }
    }

    init {
        _returnSignup.value = false
        if(!cityOrInterested) {
            getStates()
            _selectCity.value = ArrayList()
            if (_cityInit != null)
                for (element in _cityInit)
                    _selectCity.value!!.add(element)
        }
        chipUpdate()
    }
}

class SelectViewModelFactory(private val context : Context,
                             private val cityOrInterested : Boolean,
                             private val cityInit: Array<CityInfo>?) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(SelectViewModel::class.java))
            return SelectViewModel(context, cityOrInterested, cityInit) as T
        throw IllegalArgumentException("Unknown Class Name")
    }
}

@Parcelize
data class CityInfo(var state : StateData, var city : StateData? = null) : Parcelable {
    override fun toString(): String {
        return "${state.str} ${city?.str ?: ""}"
    }
}