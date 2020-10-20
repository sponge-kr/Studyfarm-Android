package kr.khs.studyfarm

import java.util.regex.Pattern

//이메일 정규식 체크
//fun isEmailValidate(str: String) : Boolean{
////    val regex = ("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
////            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")
//    val regex = ("0-9a-zA-Z@0-9a-zA-Z.[a-zA-Z]{2,3}$")
//    val pattern = Pattern.compile(regex)
//    val matcher = pattern.matcher(str)
//    return matcher.matches()
//}

fun isEmailValidate(str : String) = Pattern.compile(
    "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"
//    "0-9a-zA-Z@0-9a-zA-Z.[a-zA-Z]{2,3}$"
)
    .matcher(str)
    .matches()

//비밀번호 정규식 체크
fun isPasswordValidate(str: String) = Pattern.compile(
    "^.(?=^.{8,15}\$)(?=.\\d)(?=.[a-zA-Z])(?=.[!@#\$%^&+=]).*\$"
)
    .matcher(str)
    .matches()