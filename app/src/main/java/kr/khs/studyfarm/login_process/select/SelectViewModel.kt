package kr.khs.studyfarm.login_process.select

import android.os.Parcelable
import android.view.View
import androidx.lifecycle.*
import kotlinx.android.parcel.Parcelize
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kr.khs.studyfarm.login_process.sign_up_info.StateData
import kr.khs.studyfarm.network.*
import java.util.AbstractMap
import java.util.ArrayList

class SelectViewModel : ViewModel() {
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
    val chipObjects = MutableLiveData<MutableList<CityInfo?>>()

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
                    (jsonState[it] as AbstractMap<*, *>)["name"] as String
                )})
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
                cityList.value = (List(jsonCity.size) { StateData(
                    ((jsonCity[it] as AbstractMap<*, *>)["code"] as Double).toInt(),
                    (jsonCity[it] as AbstractMap<*, *>)["name"] as String
                )})
                _apiStatus.value = ApiStatus.DONE
            }
            catch (t : Throwable) {
                _apiStatus.value = ApiStatus.ERROR
                _error.value = errorHandling(t)
            }
        }
    }

    fun onStateSelect(data : StateData) {
        getCities(data.num)
        cur = CityInfo(data)
    }

    fun onCitySelect(data : StateData) {
        cur!!.city = data
        if(_selectCity.value?.size == 3) {
            _toast.value = "지역은 최대 3곳까지 선택할 수 있습니다."
            return
        }
        for (city in _selectCity.value!!) {
            if (cur!!.state.num == city.state.num && cur!!.city!!.num == city.city!!.num) {
                _toast.value = "동일한 지역이 이미 선택되어 있습니다."
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
        //delete

        chipUpdate()
    }

    fun chipUpdate() {
        chipVisible.value = List(3) { idx -> idx < _selectCity.value!!.size }
//        chipObjects.value = MutableList(3) { if(chipVisible.value!![it]) selectCity[it] else null }
    }

    init {
        _returnSignup.value = false
        getStates()
        _selectCity.value = ArrayList()
        chipUpdate()
    }
}

class SelectViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(SelectViewModel::class.java))
            return SelectViewModel() as T
        throw IllegalArgumentException("Unknown Class Name")
    }
}

@Parcelize
data class CityInfo(var state : StateData, var city : StateData? = null) : Parcelable {
    override fun toString(): String {
        return "${state.str} ${city?.str ?: ""}"
    }
}