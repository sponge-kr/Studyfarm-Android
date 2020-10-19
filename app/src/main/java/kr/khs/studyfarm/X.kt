package kr.khs.studyfarm

import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import java.util.regex.Pattern

//이메일 정규식 체크
fun isEmailValidate(str : String) = Pattern.matches("0-9a-zA-Z@0-9a-zA-Z.[a-zA-Z]{2,3}\$", str)

//비밀번호 정규식 체크
fun isPasswordValidate(str : String) = Pattern.matches("^.(?=^.{8,15}\$)(?=.\\d)(?=.[a-zA-Z])(?=.[!@#\$%^&+=]).*\$", str)

//fragment 백스택
fun <T : Any> Fragment.setBackStackData(key: String, data : T, doBack : Boolean = true) {
    findNavController().previousBackStackEntry?.savedStateHandle?.set(key, data)
    if(doBack)
        findNavController().popBackStack()
}

fun <T : Any> Fragment.getBackStackData(key: String, result: (T) -> (Unit)) {
    findNavController().currentBackStackEntry?.savedStateHandle?.getLiveData<T>(key)?.observe(viewLifecycleOwner) {
        result(it)
    }
}