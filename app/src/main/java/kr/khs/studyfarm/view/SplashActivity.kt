package kr.khs.studyfarm.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import kotlinx.coroutines.*
import kr.khs.studyfarm.R
import kr.khs.studyfarm.createAlertDialog
import kr.khs.studyfarm.getAccessToken
import kr.khs.studyfarm.network.StudyFarmApi

class SplashActivity : AppCompatActivity() {

    private val job = Job()
    private val coroutineScope = CoroutineScope(job + Dispatchers.Main)

    val next = MutableLiveData<Class<out AppCompatActivity>>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        makeFullScreen()

        setContentView(R.layout.activity_splash)

        val token = getAccessToken(applicationContext)

        next.value = SplashActivity::class.java

        checkTokenAvailable(token)

        next.observe(this, Observer {
            if(it != SplashActivity::class.java) {
                startActivity(Intent(this, it))

                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)

                finish()
            }
        })

    }

    private fun checkTokenAvailable(token : String) {
        var isComplete = false
        coroutineScope.launch {
            delay(2000)
            if(token == "noJwtToken")
                next.value = SignActivity::class.java
            else {
                try {
                    val result = StudyFarmApi.retrofitService.checkToken(token)
                    if (result.result.checkResult) {
                        next.value = MainActivity::class.java
                        isComplete = true
                    }
                } catch (t: Throwable) {
                    t.printStackTrace()
                }
                finally {
                    if(!isComplete) {
                        createAlertDialog(this@SplashActivity,
                            "로그인에 문제가 생겼습니다. 다시 로그인해주세요.",
                            "로그인하러 가기"
                        )
                        next.value = SignActivity::class.java
                    }
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        coroutineScope.cancel()
    }

    override fun onBackPressed() { }

    private fun makeFullScreen() {
        requestWindowFeature(Window.FEATURE_NO_TITLE)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)

        supportActionBar?.hide()
    }
}