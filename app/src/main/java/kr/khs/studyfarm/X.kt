package kr.khs.studyfarm

import java.util.regex.Pattern

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