package kr.khs.studyfarm

import android.content.Context
import java.util.regex.Pattern

private val spfJwt = "jwtTokens"
private val tokenKey = "jwt"

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