package kr.khs.studyfarm.mainpage

import android.content.Context
import androidx.annotation.RawRes
import androidx.databinding.ObservableField
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.*
import kotlinx.coroutines.*
import kr.khs.studyfarm.getAccessToken
import kr.khs.studyfarm.getUserSeq
import kr.khs.studyfarm.mainpage.vp.InterestingVPAdapter
import kr.khs.studyfarm.network.ApiStatus
import kr.khs.studyfarm.network.StudyFarmApi
import kr.khs.studyfarm.network.response.*

class MainViewModel(private val fm : FragmentManager, private val context : Context) : ViewModel() {

    val nickName = ObservableField<String>()

    val resources = context.resources

    private val user = Transformations.map(response) {
        it.result
    }

    val interestings = MutableLiveData<List<UserInterestingInfo>>()

    val interestingVPAdapter = InterestingVPAdapter(fm, listOf())

    private val _makeStudy = MutableLiveData<Boolean>()
    val makeStudy : LiveData<Boolean>
        get() = _makeStudy

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

    fun getUserInfo() {
        coroutineScope.launch {
            try {
                _apiStatus.value = ApiStatus.LOADING
                _response.value = StudyFarmApi.retrofitService.getUserInfo("Bearer " + getAccessToken(context), getUserSeq(context))
                val user = _response.value!!.result
                interestings.value = user.interesting
                nickName.set(user.nickname)
                _apiStatus.value = ApiStatus.DONE
            }
            catch(t : Throwable) {
                _apiStatus.value = ApiStatus.ERROR
                t.printStackTrace()
            }
        }
    }

    fun onMakeStudy() {
        _makeStudy.value = true
    }

    fun doneMakeStudy() {
        _makeStudy.value = false
    }

    init {
        nickName.set("OO")
        interestings.value = listOf()
        getUserInfo()
        _makeStudy.value = false
    }

    override fun onCleared() {
        super.onCleared()
        coroutineScope.cancel()
    }
}

class MainViewModelFactory(private val fm : FragmentManager, private val context : Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(MainViewModel::class.java))
            return MainViewModel(fm, context) as T
        throw IllegalArgumentException("Unknown Class Name")
    }

}