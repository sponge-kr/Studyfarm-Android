package kr.khs.studyfarm

import java.util.regex.Pattern

//이메일 정규식 체크
fun isEmailValidate(str : String) = Pattern.matches("0-9a-zA-Z@0-9a-zA-Z.[a-zA-Z]{2,3}\$", str)

//비밀번호 정규식 체크
fun isPasswordValidate(str : String) = Pattern.matches("^.(?=^.{8,15}\$)(?=.\\d)(?=.[a-zA-Z])(?=.[!@#\$%^&+=]).*\$", str)