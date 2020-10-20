package kr.khs.studyfarm

import android.text.Editable
import android.text.TextUtils
import androidx.databinding.BindingAdapter
import com.google.android.material.textfield.TextInputLayout


@BindingAdapter("app:validation", "app:errorMsg")
fun setErrorEnable(textInputLayout: TextInputLayout, stringRule: StringRule, errorMsg : String) {

}

object Rule {
    var EMAIL_RULE: StringRule = object : StringRule {
        override fun validate(s: Editable?): Boolean {
            return isEmailValidate(s.toString())
        }
    }
}

interface StringRule {
    fun validate(s: Editable?): Boolean
}