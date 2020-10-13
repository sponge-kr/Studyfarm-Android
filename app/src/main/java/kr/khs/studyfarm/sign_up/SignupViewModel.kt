package kr.khs.studyfarm.sign_up

import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*
import kr.khs.studyfarm.network.ApiStatus
import kr.khs.studyfarm.network.StudyFarmApi
import kr.khs.studyfarm.network.User

class SignupViewModel : ViewModel() {
    val name = ObservableField<String>()

    val email = ObservableField<String>()

    val password = ObservableField<String>()

    val nickname = ObservableField<String>()

    val phone = ObservableField<String>()

    val age = ObservableField<String>()

    val state = ObservableField<String>()

    val city = ObservableField<String>()

    val simpleIntroduce = ObservableField<String>()

    val profile = ObservableField<String>()

    //api status 변경에 따라 회원가입 로딩, 성공, 실패 -> observer을 통해서 처리하기 위함
    private val _apiStatus = MutableLiveData<ApiStatus>()
    val apiStatus : LiveData<ApiStatus>
        get() = _apiStatus

    private val job = Job()
    private val coroutineScope = CoroutineScope(job + Dispatchers.Main)

    init {
        name.set("김희승")
        email.set("ks96ks@naver.com")
        password.set("test")
        nickname.set("김희승")
        phone.set("01047335304")
        age.set(25.toString())
        state.set(11.toString())
        city.set(1.toString())
        simpleIntroduce.set("안녕하세요")
    }

    fun onSignupBtnClicked() {
        //TODO : profile을 제외한 모든 값은 일단 null이 아니라고 가정 -> 나중에 예외처리
        val user = User(
            name = name.get()!!,
            email = email.get()!!,
            password = password.get()!!,
            nickname = nickname.get()!!,
            phone = phone.get()!!,
            age = age.get()!!.toDouble(),
            state = state.get()!!.toDouble(),
            city = city.get()!!.toDouble(),
            simpleIntroduce = simpleIntroduce.get()!!,
            profile = profile.get()
        )

        addUser(user)
    }

    private fun addUser(user: User) {
        coroutineScope.launch {
            try {
                _apiStatus.value = ApiStatus.LOADING
                val ret = StudyFarmApi.retrofitService.addUser(user)
                println(ret.toString())
                if(ret.code == 200.0)
                    _apiStatus.value = ApiStatus.DONE
                else
                    _apiStatus.value = ApiStatus.ERROR
            }
            catch (t : Throwable) {
                _apiStatus.value = ApiStatus.ERROR
                println(t.localizedMessage)
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        coroutineScope.cancel()
    }
}