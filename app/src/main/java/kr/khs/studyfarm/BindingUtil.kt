package kr.khs.studyfarm

import android.content.res.Resources
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.*
import com.shawnlin.numberpicker.NumberPicker
import androidx.core.content.res.ResourcesCompat
import androidx.databinding.BindingAdapter
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import com.google.android.material.textfield.TextInputLayout
import kr.khs.studyfarm.login_process.select.SelectInfo
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

//닉네임 중복 표시
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
//    textInputLayout.isPasswordVisibilityToggleEnabled = enabled
    textInputLayout.endIconMode = TextInputLayout.END_ICON_PASSWORD_TOGGLE
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

// 현재 상태 : visibility가 똑바로 조정이 안된다. 삭제할떄. -> chipgroup에 binding adapter을 연결하자! -> 나아가서 spinner listener까지?
@BindingAdapter("app:cityChipList", "app:cityList")
fun cityChipEventListener(view : Chip, chipList : MutableList<String>, cityList : ArrayList<Int>) {
    view.apply {
        isCheckable = false
        isCloseIconVisible = true
        closeIcon = ResourcesCompat.getDrawable(resources, android.R.drawable.ic_menu_close_clear_cancel, null)
        setOnCloseIconClickListener {
            var idx = 0
            for(i in 0 until 3)
                if(chipList[i] == this.text)
                    idx = i
            println(idx.toString() + " " + this.text)
            for(i in 0 until 3)
                print("${chipList[i]}, ")
            println()
            for(i in 0 until cityList.size)
                print("${cityList[i]}, ")
            println()

            chipList.removeAt(idx)
            chipList.add("")
            cityList.removeAt(idx * 2)
            cityList.removeAt(idx * 2)
            (parent as ChipGroup).removeView(it)
        }
    }
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

//spinner에 onItemSelectedListener추가
@BindingAdapter("app:setOnItemSelectedListener")
fun addOnItemSelectedListener(view : Spinner, listener: AdapterView.OnItemSelectedListener) {
    view.onItemSelectedListener = listener
}

@BindingAdapter("app:nicknameCheck")
fun checkNickName(view : TextInputLayout, listener : View.OnFocusChangeListener) {
    view.editText?.onFocusChangeListener = listener
}

//20201112 현재 없어져도 뷰에서 업데이트가 안된다,,
//setOnCloseIconClickListener에 추가해보자!
@BindingAdapter("app:visibility", "app:chipText", "app:chipArray", "app:chipUpdate")
fun setVisibility(view : Chip, visible : Boolean, city : SelectInfo?, arr : ArrayList<SelectInfo>, update : () -> Unit ) {
    if(city == null)
        view.visibility = View.INVISIBLE
    city?.let {
        view.apply {
            visibility = if (visible) View.VISIBLE else View.INVISIBLE
            text = city.toString()
            isCheckable = false
            isCloseIconVisible = true
            closeIcon = ResourcesCompat.getDrawable(
                resources,
                android.R.drawable.ic_menu_close_clear_cancel,
                null
            )
            setOnCloseIconClickListener {
                for(obj in arr)
                    if(obj == city) {
                        arr.remove(obj)
                        break
                    }
                update()
            }
        }
    }
}

@BindingAdapter("app:agePickerSettting")
fun numberPickerSetting(view : NumberPicker, age : Int) {
    view.apply {
        value = age
    }
}

@BindingAdapter("app:ratingBarSetting")
fun ratingBarSetting(view : RatingBar, value : Float) {
    view.apply {
        rating = value
        this.stepSize = 1.0f
    }
}

@BindingAdapter("app:resources", "app:whoLogined")
fun greetingMessage(view : TextView, res : Resources, nickname : String) {
    view.text = String.format(res.getString(R.string.main_greeting), nickname)
}