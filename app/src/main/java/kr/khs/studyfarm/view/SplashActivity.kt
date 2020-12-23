package kr.khs.studyfarm.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.Window
import android.view.WindowManager
import kr.khs.studyfarm.R
import kr.khs.studyfarm.getAccessToken

class SplashActivity : AppCompatActivity() {
    private val DELAY_TIME = 2000L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        makeFullScreen()

        setContentView(R.layout.activity_splash)

        //TODO : Handler is deprecated library -> find alternative
        Handler().postDelayed({
            val token = getAccessToken(applicationContext)

            startActivity(Intent(this,
                if(token == "noJwtToken")
                    SignActivity::class.java
                else
                    MainActivity::class.java)
            )

            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)

            finish()

        }, DELAY_TIME)
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