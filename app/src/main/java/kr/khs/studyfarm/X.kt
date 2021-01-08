package kr.khs.studyfarm

import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.AnimationDrawable
import android.graphics.drawable.ColorDrawable
import android.widget.ImageView
import androidx.appcompat.app.AppCompatDialog
import java.util.regex.Pattern

private val spfJwt = "jwtTokens"
private val tokenKey = "jwt"
private val seqKey = "seq"

fun isEmailValidate(str : String) = Pattern.compile(
    "^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*\\.[a-zA-Z]{2,3}\$"
)
    .matcher(str)
    .matches()

//비밀번호 정규식 체크
fun isPasswordValidate(str: String) = Pattern.compile(
    "^.*(?=^.{8,15}\$)(?=.*\\d)(?=.*[a-zA-Z])(?=.*[!@#\$%^&+=]).*\$"
)
    .matcher(str)
    .matches()

enum class Gender (val MW : Int) {
    Not(-1), Man(0), Woman(1)
}

fun addUserSeq(context : Context, seq : Int) {
    val spf = context.getSharedPreferences(spfJwt, Context.MODE_PRIVATE)
    val edit = spf.edit()

    try {
        edit.putInt(seqKey, seq)
        edit.apply()
    }
    catch(e : Exception) {
        e.printStackTrace()
    }
}

fun getUserSeq(context : Context) : Int {
    val spf = context.getSharedPreferences(spfJwt, Context.MODE_PRIVATE)

    return spf.getInt(seqKey, 0)
}

fun addAccessToken(context : Context, jwt : String) {
    val spf = context.getSharedPreferences(spfJwt, Context.MODE_PRIVATE)
    val edit = spf.edit()

    try {
        edit.putString(tokenKey, jwt)
        edit.apply()
    }
    catch(e : Exception) {
        e.printStackTrace()
    }
}

fun getAccessToken(context : Context) : String {
    val spf = context.getSharedPreferences(spfJwt, Context.MODE_PRIVATE)

    return spf.getString(tokenKey, "noJwtToken")!!
}

fun clearAccessToken(context : Context) {
    val spf = context.getSharedPreferences(spfJwt, Context.MODE_PRIVATE)
    val edit = spf.edit()

    try {
        edit.clear()
        edit.apply()
    }
    catch(e : Exception) {
        e.printStackTrace()
    }
}

object dialog {
    var loadingDialog: AppCompatDialog? = null

    fun onLoadingDialog(activity: Activity?) {
        if(activity == null || activity.isFinishing)
            return

        loadingDialog?.let {
            if(it.isShowing)
                return
        }

        loadingDialog = AppCompatDialog(activity).apply {
            setCancelable(false)
            window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            setContentView(R.layout.dialog_loading)
        }

        loadingDialog?.show()

        val loadingImage = loadingDialog?.findViewById<ImageView>(R.id.loading_img)
        val loadingAni = loadingImage!!.background as AnimationDrawable
        loadingImage.post { loadingAni.start() }
    }

    fun offLoadingDialog() {
        if(loadingDialog!!.isShowing) {
            loadingDialog?.dismiss()
        }
    }
}