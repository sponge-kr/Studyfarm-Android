package kr.khs.studyfarm.login_process.login

import android.content.Context
import android.util.Log
import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.kakao.sdk.auth.LoginClient
import com.kakao.sdk.auth.model.OAuthToken
import com.kakao.sdk.user.UserApiClient
import kotlinx.coroutines.*
import kr.khs.studyfarm.R
import kr.khs.studyfarm.Rule
import kr.khs.studyfarm.addAccessToken
import kr.khs.studyfarm.addUserSeq
import kr.khs.studyfarm.network.*
import kr.khs.studyfarm.network.request.KakaoSignupData
import kr.khs.studyfarm.network.request.LoginData
import kr.khs.studyfarm.network.response.Response
import kr.khs.studyfarm.network.response.ResponseError
import java.util.AbstractMap

class LoginViewModel(val context : Context) : ViewModel() {

    val email = ObservableField<String>()

    val password = ObservableField<String>()

    var nickname = ""

    val rule = Rule

    private val _gotoSignUp = MutableLiveData<Boolean>()
    val gotoSignUp : LiveData<Boolean>
        get() = _gotoSignUp

    private val _gotoFindPW = MutableLiveData<Boolean>()
    val gotoFindPW : LiveData<Boolean>
        get() = _gotoFindPW

    private val _loginSuccess = MutableLiveData<Boolean>()
    val loginSuccess : LiveData<Boolean>
        get() = _loginSuccess

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

    // 카카오톡으로 로그인
    fun loginByKakao() {
        // 로그인 공통 callback 구성
        val callback: (OAuthToken?, Throwable?) -> Unit = { token, error ->
            if (error != null) {
                Log.e("KAKAO_LOGIN", "로그인 실패", error)
            }
            else if (token != null) {
                Log.i("KAKAO_LOGIN", "로그인 성공 ${token.accessToken}")
                UserApiClient.instance.me { user, error ->
                    if(error != null) throw Error("사용자 정보 요청 실패")
                    else
                        nickname = user?.kakaoAccount?.profile?.nickname ?: ""
                }
                kakaoIdCheck(token.accessToken)
            }
        }

        // 카카오톡이 설치되어 있으면 카카오톡으로 로그인, 아니면 카카오계정으로 로그인
        if (LoginClient.instance.isKakaoTalkLoginAvailable(context)) {
            LoginClient.instance.loginWithKakaoTalk(context, callback = callback)
        } else {
            LoginClient.instance.loginWithKakaoAccount(context, callback = callback)
        }
    }

    fun kakaoIdCheck(kakaoToken : String) {
        coroutineScope.launch {
            try {
                _apiStatus.value = ApiStatus.LOADING
                _response.value = StudyFarmApi.retrofitService.loginByKakao(kakaoToken)
                val abMap = _response.value!!.result as AbstractMap<*, *>
                val token = abMap["token"] as String
                val user = abMap["user"] as AbstractMap<*, *>
                val seq = user["users_seq"] as Double
                addAccessToken(context, token)
                addUserSeq(context, seq.toInt())
              
                _loginSuccess.value = true
            }
            catch(t : Throwable) {
                _apiStatus.value = ApiStatus.ERROR
                // 401일 경우 가입되지 않은 유저

                if(t.message!!.contains("HTTP 401"))
                    kakaoSignUp(kakaoToken)
            }
        }
    }

    fun kakaoSignUp(kakaoToken : String) {
        coroutineScope.launch {
            try {
                _apiStatus.value = ApiStatus.LOADING
                _response.value = StudyFarmApi.retrofitService.signupByKakao(
                    kakaoToken,
                    KakaoSignupData(nickname)
                )
                _apiStatus.value = ApiStatus.DONE
                kakaoIdCheck(kakaoToken)
            }
            catch(t : Throwable) {
                _apiStatus.value = ApiStatus.ERROR
                t.printStackTrace()
            }
        }
    }

    fun onLoginBtnClick() {
        login()
    }

    private fun login() {
        coroutineScope.launch {
            try {
                _apiStatus.value = ApiStatus.LOADING
                _response.value = StudyFarmApi.retrofitService.loginUser(LoginData(email.get()!!, password.get()!!))
                val abMap = _response.value!!.result as AbstractMap<*, *>
                val token = abMap["token"] as String
                val user = abMap["user"] as AbstractMap<*, *>
                val seq = user["users_seq"] as Double
                addAccessToken(context, token)
                addUserSeq(context, seq.toInt())
              
                _loginSuccess.value = true
                _apiStatus.value = ApiStatus.DONE
            }
            catch (t : Throwable) {
                _apiStatus.value = ApiStatus.ERROR
                t.printStackTrace()
                _toast.value = context.getString(R.string.login_error)
            }
        }
    }

    fun doGoToSignUp() {
        _gotoSignUp.value = true
    }

    fun doneGoToSignUp() {
        _gotoSignUp.value = false
    }

    fun doGoToFindPW() {
        _gotoFindPW.value = true
    }

    fun doneGoToFindPW() {
        _gotoFindPW.value = false
    }

    fun doneLogin() {
        _loginSuccess.value = false
    }

    fun doneToast() {
        _toast.value = ""
    }

    init {
        email.set("ks96ks@naver.com")
        password.set("gmltmd!23")
        _gotoSignUp.value = false
        _loginSuccess.value = false
        _gotoFindPW.value = false
    }


    override fun onCleared() {
        super.onCleared()
        coroutineScope.cancel()
    }
}

class LoginViewModelFactory(private val context : Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(LoginViewModel::class.java))
            return LoginViewModel(context) as T
        throw IllegalArgumentException("Unknown Class Name")
    }
}