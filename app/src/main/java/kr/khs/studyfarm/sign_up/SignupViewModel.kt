package kr.khs.studyfarm.sign_up

import android.util.Log
import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*
import kr.khs.studyfarm.network.*

class SignupViewModel : ViewModel() {
    private val _pointer = MutableLiveData<Int>()
    val pointer : LiveData<Int>
        get() = _pointer

    val descriptionList = arrayOf("name", "email", "password", "nickname", "phone", "age", "state", "city", "simpleIntroduce", "profile")
    val inputList = Array<String?>(10) { null }

    val descriptionField = ObservableField<String>()
    val inputField = ObservableField<String>()

    val btnName = Transformations.map(pointer) { num ->
        if(num < descriptionList.size - 1) "next"
        else "sign up"
    }

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

    init {
        _pointer.value = 0
        descriptionField.set(descriptionList[pointer.value!!])
//        name.set("김희승")
//        email.set("ks96ks@naver.com")
//        password.set("rlagmltmd1!")
//        nickname.set("김희승")
//        phone.set("01047335304")
//        age.set(25.toString())
//        state.set(11.toString())
//        city.set(1.toString())
//        simpleIntroduce.set("안녕하세요")
    }

    fun onNextBtnClicked() {
        Log.d("SAMPLE_BEFORE", pointer.value!!.toString())

        if(pointer.value!! < descriptionList.size && !inputField.get().isNullOrEmpty()) {
            Log.d("SAMPLE_DOING", "something")
            val cur = pointer.value!!
            inputList[cur] = inputField.get()!!
            _pointer.value = _pointer.value!!.plus(1)
            if(cur + 1 == descriptionList.size)
                onSignupBtnClicked()
            else
                descriptionField.set(descriptionList[cur + 1])
        }

        Log.d("SAMPLE_AFTER", pointer.value!!.toString())
    }

    fun onSignupBtnClicked() {
        //TODO : profile을 제외한 모든 값은 일단 null이 아니라고 가정 -> 나중에 예외처리
        val user = User(
            name = inputList[0]!!,
            email = inputList[1]!!,
            password = inputList[2]!!,
            nickname = inputList[3]!!,
            phone = inputList[4]!!,
            age = inputList[5]!!.toDouble(),
            state = inputList[6]!!.toDouble(),
            city = inputList[7]!!.toDouble(),
            simpleIntroduce = inputList[8]!!,
            profile = inputList[9]
        )

        addUser(user)
    }

    private fun addUser(user: User) {
        coroutineScope.launch {
            try {
                _apiStatus.value = ApiStatus.LOADING
                _response.value = StudyFarmApi.retrofitService.addUser(user)
                _apiStatus.value = ApiStatus.DONE
            }
            catch (t : Throwable) {
                _apiStatus.value = ApiStatus.ERROR
                _error.value = errorHandling(t)
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        coroutineScope.cancel()
    }
}