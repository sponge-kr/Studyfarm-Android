package kr.khs.studyfarm.view.custom

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import androidx.databinding.ObservableField
import kotlinx.android.synthetic.main.button_level_select.view.*
import kr.khs.studyfarm.R
import kr.khs.studyfarm.databinding.ButtonLevelSelectBinding
import kr.khs.studyfarm.setting

class LevelSelectButton @JvmOverloads constructor(
    context : Context, attrs : AttributeSet? = null, defStyle : Int = 0
) : ConstraintLayout(context, attrs, defStyle) {

    private var binding : ButtonLevelSelectBinding

    private val MAX_SIZE = 4

    private lateinit var target : TextView
//        get() = binding.root.levelselect_target
    private lateinit var btnLevelOne : Button
//        get() = binding.root.levelselect_btn1
    private lateinit var btnLevelTwo : Button
//        get() = binding.root.levelselect_btn2
    private lateinit var btnLevelThree : Button
//        get() = binding.root.levelselect_btn3
    private lateinit var btnLevelFour : Button
//        get() = binding.root.levelselect_btn4

    private var levelOneName = "초급"
    private var levelTwoName = "초중급"
    private var levelThreeName = "중급"
    private var levelFourName = "상급"

    private val selected = ObservableField<String>()

    // for databinding
    var targetName = ""
        set(value) {
            field = value
            target.text = value
        }

    private val btnClickListener = OnClickListener { v ->
        this.setting(when(v.id) {
            R.id.levelselect_btn1 -> "1"
            R.id.levelselect_btn2 -> "2"
            R.id.levelselect_btn3 -> "3"
            R.id.levelselect_btn4 -> "4"
            else -> "0"
        })

        when(v.id) {
            R.id.levelselect_btn1 -> {
                btnLevelOne.setBackgroundColor(resources.getColor(R.color.colorPrimary, null))
                btnLevelTwo.setBackgroundColor(resources.getColor(R.color.notActivateColor, null))
                btnLevelThree.setBackgroundColor(resources.getColor(R.color.notActivateColor, null))
                btnLevelFour.setBackgroundColor(resources.getColor(R.color.notActivateColor, null))
            }
            R.id.levelselect_btn2 -> {
                btnLevelOne.setBackgroundColor(resources.getColor(R.color.notActivateColor, null))
                btnLevelTwo.setBackgroundColor(resources.getColor(R.color.colorPrimary, null))
                btnLevelThree.setBackgroundColor(resources.getColor(R.color.notActivateColor, null))
                btnLevelFour.setBackgroundColor(resources.getColor(R.color.notActivateColor, null))
            }
            R.id.levelselect_btn3 -> {
                btnLevelOne.setBackgroundColor(resources.getColor(R.color.notActivateColor, null))
                btnLevelTwo.setBackgroundColor(resources.getColor(R.color.notActivateColor, null))
                btnLevelThree.setBackgroundColor(resources.getColor(R.color.colorPrimary, null))
                btnLevelFour.setBackgroundColor(resources.getColor(R.color.notActivateColor, null))
            }
            R.id.levelselect_btn4 -> {
                btnLevelOne.setBackgroundColor(resources.getColor(R.color.notActivateColor, null))
                btnLevelTwo.setBackgroundColor(resources.getColor(R.color.notActivateColor, null))
                btnLevelThree.setBackgroundColor(resources.getColor(R.color.notActivateColor, null))
                btnLevelFour.setBackgroundColor(resources.getColor(R.color.colorPrimary, null))
            }
        }

        selected.set(when(v.id) {
            R.id.levelselect_btn1 -> 1
            R.id.levelselect_btn2 -> 2
            R.id.levelselect_btn3 -> 3
            R.id.levelselect_btn4 -> 4
            else -> 0
        }.toString())

    }

    init {
        val inflater = LayoutInflater.from(context)
        binding = DataBindingUtil.inflate(
            inflater, R.layout.button_level_select, this, true
        )

        binding.view = this

        selected.set("0")

        initViews()
        initAttrs(attrs)
        initSettings()
    }

    private fun initViews() {
        target = binding.root.findViewById(R.id.levelselect_target)
        btnLevelOne = binding.root.findViewById(R.id.levelselect_btn1)
        btnLevelTwo = binding.root.findViewById(R.id.levelselect_btn2)
        btnLevelThree = binding.root.findViewById(R.id.levelselect_btn3)
        btnLevelFour = binding.root.findViewById(R.id.levelselect_btn4)
    }

    private fun initAttrs(attrs : AttributeSet?) {
        attrs?.run {
            context.obtainStyledAttributes(this, R.styleable.LevelSelectButton)
        }?.run {
            levelOneName = getString(R.styleable.LevelSelectButton_levelOneName) ?: levelOneName
            levelTwoName = getString(R.styleable.LevelSelectButton_levelTwoName) ?: levelTwoName
            levelThreeName = getString(R.styleable.LevelSelectButton_levelThreeName) ?: levelThreeName
            levelFourName = getString(R.styleable.LevelSelectButton_levelFourName) ?: levelFourName

        }
    }

    private fun initSettings() {
        btnLevelOne.apply {
            text = levelOneName
            setBackgroundColor(resources.getColor(R.color.notActivateColor, null))
            setOnClickListener(btnClickListener)
        }
        btnLevelTwo.apply {
            text = levelTwoName
            setBackgroundColor(resources.getColor(R.color.notActivateColor, null))
            setOnClickListener(btnClickListener)
        }
        btnLevelThree.apply {
            text = levelThreeName
            setBackgroundColor(resources.getColor(R.color.notActivateColor, null))
            setOnClickListener(btnClickListener)
        }
        btnLevelFour.apply {
            text = levelFourName
            setBackgroundColor(resources.getColor(R.color.notActivateColor, null))
            setOnClickListener(btnClickListener)
        }

        target.text = targetName
    }

    fun setSelectLevel(idx : Int) {
        when(idx) {
            1 -> btnLevelOne.callOnClick()
            2 -> btnLevelTwo.callOnClick()
            3 -> btnLevelThree.callOnClick()
            4 -> btnLevelFour.callOnClick()
        }
    }

    fun getSelectLevel() = selected.get()!!.toInt()
}