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
import kr.khs.studyfarm.login_process.sign_up_info.InfoData
import kr.khs.studyfarm.network.*
import kr.khs.studyfarm.network.response.Response
import kr.khs.studyfarm.network.response.ResponseError
import kr.khs.studyfarm.network.response.errorHandling
import java.util.AbstractMap
import java.util.ArrayList

class SelectViewModel(val context : Context, private val cityOrInterested : Boolean, _dataInit : Array<SelectInfo>?) : ViewModel() {
    private val _returnSignup = MutableLiveData<Boolean>()
    val returnSignup : LiveData<Boolean>
        get() = _returnSignup

    val parentList = MutableLiveData<List<InfoData>>()

    val childrenList = MutableLiveData<List<InfoData>>()

    val _selectData = MutableLiveData<ArrayList<SelectInfo>>()
    val selectData : Array<SelectInfo>
        get() = Array(_selectData.value!!.size) { _selectData.value!![it] }
    var cur : SelectInfo? = null

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

    private fun getParent() {
        coroutineScope.launch {
            try {
                println("getParent")
                _apiStatus.value = ApiStatus.LOADING
                _response.value =
                    if(!cityOrInterested)
                        StudyFarmApi.retrofitService.getStates()
                    else
                        StudyFarmApi.retrofitService.getStudies()
                val abMap = _response.value!!.result as AbstractMap<*, *>
                val jsonState = abMap["content"] as ArrayList<*>
                parentList.value = (List(jsonState.size) { InfoData(
                    ((jsonState[it] as AbstractMap<*, *>)["code"] as Double).toInt(),
                    (jsonState[it] as AbstractMap<*, *>)["name"] as String,
                )})

                for(i in 0 until jsonState.size) {
                    val list = ArrayList<InfoData>()
                    val temp = (jsonState[i] as AbstractMap<*, *>)["children"] as ArrayList<*>
                    for(j in 0 until temp.size) {
                        val split = temp[j].toString().split("{", "=", ",", "}")
                        list.add(InfoData(
                            split[2].toDouble().toInt(),
                            split[4]
                        ))
                    }
                    parentList.value!![i].children = list
                }
                _apiStatus.value = ApiStatus.DONE
            }
            catch (t : Throwable) {
                _apiStatus.value = ApiStatus.ERROR
                _error.value = errorHandling(t)
            }
        }
    }

    fun onParentSelect(data : InfoData) {
        cur = SelectInfo(data)
        if(data.children.isEmpty()) {
            onChildrenSelect(InfoData(0, ""))
        }
        else {
            childrenList.value = data.children
        }
    }

    fun onChildrenSelect(data : InfoData) {
        cur!!.children = data
        if(_selectData.value?.size == 3) {
            _toast.value = if(cityOrInterested) context.getString(R.string.signup_maxStudy) else context.getString(R.string.select_maxCity)
            return
        }
        for (city in _selectData.value!!) {
            if (cur!!.parent.num == city.parent.num && cur!!.children!!.num == city.children!!.num) {
                _toast.value = if(cityOrInterested) context.getString(R.string.select_duplicateStudy) else context.getString(R.string.select_duplicateCity)
                return
            }
        }
        _selectData.value!!.add(cur!!.copy())
        chipUpdate()
    }

    fun doneToast() {
        _toast.value = ""
    }

    val chipUpdateListener : () -> Unit = {
        chipUpdate()
    }

    fun chipUpdate() {
        chipVisible.value = List(3) { idx -> idx < _selectData.value!!.size }
    }

    init {
        _returnSignup.value = false
        getParent()
        _selectData.value = ArrayList()
        if (_dataInit != null)
            for (element in _dataInit)
                _selectData.value!!.add(element)
        chipUpdate()
    }
}

class SelectViewModelFactory(private val context : Context,
                             private val cityOrInterested : Boolean,
                             private val cityInit: Array<SelectInfo>?) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(SelectViewModel::class.java))
            return SelectViewModel(context, cityOrInterested, cityInit) as T
        throw IllegalArgumentException("Unknown Class Name")
    }
}

@Parcelize
data class SelectInfo(var parent : InfoData, var children : InfoData? = null) : Parcelable {
    override fun toString(): String {
        return "${parent.str} ${children?.str ?: ""}"
    }
}