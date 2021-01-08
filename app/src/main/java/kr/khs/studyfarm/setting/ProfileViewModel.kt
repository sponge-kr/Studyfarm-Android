package kr.khs.studyfarm.setting

import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kr.khs.studyfarm.Gender
import kr.khs.studyfarm.network.ApiStatus
import kr.khs.studyfarm.network.response.Response
import kr.khs.studyfarm.network.response.ResponseError

class ProfileViewModel : ViewModel() {

    val age = ObservableField<Int>()

    var gender = Gender.Not

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

    init {

    }
}

class ProfileViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(ProfileViewModel::class.java))
            return ProfileViewModel() as T
        throw IllegalArgumentException("Unknown Class Name")
    }
}