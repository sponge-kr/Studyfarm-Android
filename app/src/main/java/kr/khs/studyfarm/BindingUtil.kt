package kr.khs.studyfarm

import android.text.Editable
import android.text.TextWatcher
import androidx.databinding.BindingAdapter
import com.google.android.material.textfield.TextInputLayout


@BindingAdapter("app:validation", "app:errorMsg")
fun setErrorEnable(textInputLayout: TextInputLayout, stringRule: StringRule, errorMsg : String) {
    textInputLayout.editText?.addTextChangedListener(object : TextWatcher {
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) { }

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) { }

        override fun afterTextChanged(p0: Editable?) {
            textInputLayout.error =
                if(stringRule.validate(p0))
                    null
                else
                    errorMsg
        }

    })
}

@BindingAdapter("app:setPasswordVisibilityToggle")
fun setPasswordVisibility(textInputLayout: TextInputLayout, enabled : Boolean) {
    textInputLayout.isPasswordVisibilityToggleEnabled = enabled
}

object Rule {
    val EMAIL_RULE: StringRule = object : StringRule {
        override fun validate(s: Editable?): Boolean {
            return isEmailValidate(s.toString())
        }
    }

    val PASSWORD_RULE : StringRule = object : StringRule {
        override fun validate(s : Editable?) : Boolean {
            return isPasswordValidate(s.toString())
        }
    }
}

interface StringRule {
    fun validate(s: Editable?): Boolean
}