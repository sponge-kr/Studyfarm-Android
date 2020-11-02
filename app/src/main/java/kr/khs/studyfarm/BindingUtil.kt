package kr.khs.studyfarm

import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.AdapterView
import android.widget.DatePicker
import android.widget.Spinner
import android.widget.Toast
import androidx.core.content.res.ResourcesCompat
import androidx.databinding.BindingAdapter
import androidx.databinding.ObservableField
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import com.google.android.material.textfield.TextInputLayout
import java.util.*

//이메일, 비밀번호 등 textinputlayout가 주어진 조건에 부합하는지 체크
@BindingAdapter("app:validation", "app:errorMsg")
fun setErrorEnable(textInputLayout: TextInputLayout, stringRule: StringRule, errorMsg: String) {
    textInputLayout.editText?.addTextChangedListener(object : TextWatcher {
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

        override fun afterTextChanged(p0: Editable?) {
            textInputLayout.error =
                if (stringRule.validate(p0))
                    null
                else
                    errorMsg
        }

    })
}

@BindingAdapter("app:validationBoolean", "app:errorMsgBoolean")
fun setErrorEnableBoolean(textInputLayout: TextInputLayout, boolean : Boolean, errorMsg: String) {
    textInputLayout.error =
        if(!boolean)
            null
        else
            errorMsg
}

// 비밀번호 토글
@BindingAdapter("setPasswordVisibilityToggle")
fun setPasswordVisibility(textInputLayout: TextInputLayout, enabled: Boolean) {
    textInputLayout.isPasswordVisibilityToggleEnabled = enabled
}

object Rule {
    val EMAIL_RULE: StringRule = object : StringRule {
        override fun validate(s: Editable?): Boolean {
            return isEmailValidate(s.toString())
        }
    }

    val PASSWORD_RULE : StringRule = object : StringRule {
        override fun validate(s: Editable?) : Boolean {
            return isPasswordValidate(s.toString())
        }
    }
}

interface StringRule {
    fun validate(s: Editable?): Boolean
}

// datepicker 자동으로 현재 날짜
@BindingAdapter("android:year", "android:month", "android:day")
fun setDate(view: DatePicker, year: Int, month: Int, day: Int) {
    view.updateDate(year, month, day)
}

//spinner와 chipgroup 연결
@BindingAdapter("app:connectChipGroup", "app:chipsLiveData")
fun addChip(view : Spinner, chipGroupId : Int, chips : ArrayList<String>) {
    val chipGroup = view.rootView.findViewById<ChipGroup>(chipGroupId)
    val context = chipGroup.rootView.context
    view.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
        override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
            if(p2 == 0)
                return
            val text = p0?.getItemAtPosition(p2).toString()
            if(chipGroup.childCount >= 3) {
                Toast.makeText(context, "관심 스터디는 최대 3개까지 선택할 수 있습니다.", Toast.LENGTH_SHORT).show()
                return
            }
            if(chips.contains(text)) {
                Toast.makeText(context, "중복된 항목입니다. 다시 선택해주세요.", Toast.LENGTH_SHORT).show()
                return
            }
            val chip = Chip(context)
            chip.apply {
                this.text = p0?.getItemAtPosition(p2).toString()
                isCheckable = false
                isCloseIconVisible = true
                closeIcon = ResourcesCompat.getDrawable(resources, android.R.drawable.ic_menu_close_clear_cancel, null)
                setOnCloseIconClickListener {
                    chipGroup.removeView(it)
                    chips.remove(text)
                }
            }
            chipGroup.addView(chip)
            chips.add(text)
        }

        override fun onNothingSelected(p0: AdapterView<*>?) {
        }

    }
}

@BindingAdapter("app:nicknameCheck")
fun checkNickName(view : TextInputLayout, listener : View.OnFocusChangeListener) {
    view.editText?.onFocusChangeListener = listener
}