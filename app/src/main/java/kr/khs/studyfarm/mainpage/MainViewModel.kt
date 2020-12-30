package kr.khs.studyfarm.mainpage

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.*
import kr.khs.studyfarm.getAccessToken
import kr.khs.studyfarm.getUserSeq
import kr.khs.studyfarm.network.ApiStatus
import kr.khs.studyfarm.network.StudyFarmApi
import kr.khs.studyfarm.network.response.GetUserResponse
import kr.khs.studyfarm.network.response.Response
import kr.khs.studyfarm.network.response.ResponseError
import kr.khs.studyfarm.network.response.UserInfo

class MainViewModel(private val context : Context) : ViewModel() {

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

    init {
        getUserInfo()
    }

    fun getUserInfo() {
        coroutineScope.launch {
            try {
                _apiStatus.value = ApiStatus.LOADING
                _response.value = StudyFarmApi.retrofitService.getUserInfo("Bearer " + getAccessToken(context), getUserSeq(context))
                val user = _response.value!!.result
                println(_response.value!!.result.email)
            }
            catch(t : Throwable) {
                _apiStatus.value = ApiStatus.ERROR
                t.printStackTrace()
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        coroutineScope.cancel()
    }
}

class MainViewModelFactory(private val context : Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(MainViewModel::class.java))
            return MainViewModel(context) as T
        throw IllegalArgumentException("Unknown Class Name")
    }

}