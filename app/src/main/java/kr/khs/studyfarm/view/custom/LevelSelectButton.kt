package kr.khs.studyfarm.view.custom

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import androidx.databinding.ObservableField
import androidx.databinding.ObservableInt
import kotlinx.android.synthetic.main.button_level_select.view.*
import kr.khs.studyfarm.R
import kr.khs.studyfarm.databinding.ButtonLevelSelectBindingImpl
import kr.khs.studyfarm.setting
import kotlin.math.max
import kotlin.math.min

class LevelSelectButton @JvmOverloads constructor(
    context : Context, attrs : AttributeSet? = null, defStyle: Int = 0
) : ConstraintLayout(context, attrs, defStyle) {

    private var binding : ButtonLevelSelectBindingImpl

    private val dotCount = 4

    private lateinit var btnLevelOne : ImageView
    private lateinit var btnLevelTwo : ImageView
    private lateinit var btnLevelThree : ImageView
    private lateinit var btnLevelFour : ImageView

    private lateinit var textLevelOne : TextView
    private lateinit var textLevelTwo : TextView
    private lateinit var textLevelThree : TextView
    private lateinit var textLevelFour : TextView
    val textLevelSelect : TextView
        get() = binding.root.levelselect_tv_select

    private lateinit var lineOne : View
    private lateinit var lineTwo : View
    private lateinit var lineThree : View

    private var levelOneName = "Level 1"
    private var levelTwoName = "Level 2"
    private var levelThreeName = "Level 3"
    private var levelFourName = "Level 4"

    val selectNumber = ObservableField<String>()

    private var isRange = false

//    private var startIdx = 0
//    private var endIdx = 0

    private val startIdx : Int
        get() = selectNumber.get()!!.toInt() / 10

    private val endIdx : Int
        get() = selectNumber.get()!!.toInt() % 10

    init {
        val inflater = LayoutInflater.from(context)
        binding = DataBindingUtil.inflate(
            inflater, R.layout.button_level_select, this, true
        )
        binding.view = this
//        val inflaterService = Context.LAYOUT_INFLATER_SERVICE
//        val layoutInflater = getContext().getSystemService(inflaterService) as LayoutInflater
//        val view = layoutInflater.inflate(R.layout.button_level_select, this, false)
//        addView(view)

        selectNumber.set("0")

        initViews()
        initAttrs(attrs)
        initSettings()
    }

    private fun initViews() {
        btnLevelOne = binding.root.findViewById(R.id.levelselect_button_level1)
        btnLevelTwo = binding.root.findViewById(R.id.levelselect_button_level2)
        btnLevelThree = binding.root.findViewById(R.id.levelselect_button_level3)
        btnLevelFour = binding.root.findViewById(R.id.levelselect_button_level4)

        textLevelOne = binding.root.findViewById(R.id.levelselect_tv_level1)
        textLevelTwo = binding.root.findViewById(R.id.levelselect_tv_level2)
        textLevelThree = binding.root.findViewById(R.id.levelselect_tv_level3)
        textLevelFour = binding.root.findViewById(R.id.levelselect_tv_level4)

        lineOne = binding.root.findViewById(R.id.levelselect_line1)
        lineTwo = binding.root.findViewById(R.id.levelselect_line2)
        lineThree = binding.root.findViewById(R.id.levelselect_line3)
    }

    private fun initAttrs(attrs : AttributeSet?) {
        attrs?.run {
            context.obtainStyledAttributes(this, R.styleable.LevelSelectButton)
        }?.run {
            levelOneName = getString(R.styleable.LevelSelectButton_levelOneName) ?: levelOneName
            levelTwoName = getString(R.styleable.LevelSelectButton_levelTwoName) ?: levelTwoName
            levelThreeName = getString(R.styleable.LevelSelectButton_levelThreeName) ?: levelThreeName
            levelFourName = getString(R.styleable.LevelSelectButton_levelFourName) ?: levelFourName

            isRange = getBoolean(R.styleable.LevelSelectButton_range, isRange)
        }
    }

    private fun initSettings() {
        textLevelOne.text = levelOneName
        textLevelTwo.text = levelTwoName
        textLevelThree.text = levelThreeName
        textLevelFour.text = levelFourName

        btnLevelOne.setOnClickListener { btnClick(1) }
        btnLevelTwo.setOnClickListener { btnClick(2) }
        btnLevelThree.setOnClickListener { btnClick(3) }
        btnLevelFour.setOnClickListener { btnClick(4) }
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private fun btnClick(idx : Int) {
        this.setting(idx.toString())
        if(isRange) {
            var change = 0
            if(idx == 0) {
//                selectNumber.set(0)
                change = 0
            }
            else if(startIdx == 0 && endIdx == 0) {
//                selectNumber.set(if(idx / 10 > 0) (idx / 10) * 10 + idx % 10 else idx * 10)
                change = if(idx / 10 > 0) (idx / 10) * 10 + idx % 10 else idx * 10
            }
            else if(startIdx != 0 && endIdx == 0) {
//                selectNumber.set( when {
//                    startIdx == idx -> 0
//                    else -> {
//                        min(startIdx, idx) * 10 + max(startIdx, idx)
//                    }
//                })
                change = when (startIdx) {
                    idx -> 0
                    else -> {
                        min(startIdx, idx) * 10 + max(startIdx, idx)
                    }
                }
            }
            else { // startIdx != 0 && endIdx != 0
//                selectNumber.set(
//                    if(startIdx == idx) {
//                        (selectNumber.get()!!.toInt()!!.toInt() % 10) * 10
//                    }
//                    else if(endIdx == idx) {
//                        (selectNumber.get()!!.toInt() / 10) * 10
//                    }
//                    else if(startIdx > idx) {
//                        (selectNumber.get()!!.toInt() % 10) + idx * 10
//                    }
//                    else /*if(endIdx < idx)*/ {
//                        (selectNumber.get()!!.toInt() / 10) * 10 + idx
//                    }
//                // 사이를 선택했다면 어떻게 처리가 될 것인지
//                )
                change = if(startIdx == idx) {
                    (selectNumber.get()!!.toInt()!!.toInt() % 10) * 10
                }
                else if(endIdx == idx) {
                    (selectNumber.get()!!.toInt() / 10) * 10
                }
                else if(startIdx > idx) {
                    (selectNumber.get()!!.toInt() % 10) + idx * 10
                }
                else /*if(endIdx < idx)*/ {
                    (selectNumber.get()!!.toInt() / 10) * 10 + idx
                }
                // 사이를 선택했다면 어떻게 처리가 될 것인지
            }
            selectNumber.set(change.toString())

            btnLevelOne.background = resources.getDrawable(
                if (startIdx == 1 || endIdx == 1)
                    R.drawable.custom_circle_select_o
                else
                    R.drawable.custom_circle_select_x,
                null
            )

            btnLevelTwo.background = resources.getDrawable(
                if (startIdx == 2 || endIdx == 2)
                    R.drawable.custom_circle_select_o
                else
                    R.drawable.custom_circle_select_x,
                null
            )

            btnLevelThree.background = resources.getDrawable(
                if (startIdx == 3 || endIdx == 3)
                    R.drawable.custom_circle_select_o
                else
                    R.drawable.custom_circle_select_x,
                null
            )

            btnLevelFour.background = resources.getDrawable(
                if (startIdx == 4 || endIdx == 4)
                    R.drawable.custom_circle_select_o
                else
                    R.drawable.custom_circle_select_x,
                null
            )

            lineOne.setBackgroundColor(resources.getColor(
                if(startIdx <= 1 && endIdx > 1 && startIdx != 0 && endIdx != 0)
                    R.color.colorPrimary
                else
                    android.R.color.darker_gray
                , null)
            )

            lineTwo.setBackgroundColor(resources.getColor(
                if(startIdx <= 2 && endIdx > 2 && startIdx != 0 && endIdx != 0)
                    R.color.colorPrimary
                else
                    android.R.color.darker_gray
                , null)
            )

            lineThree.setBackgroundColor(resources.getColor(
                if(startIdx <= 3 && endIdx > 3 && startIdx != 0 && endIdx != 0)
                    R.color.colorPrimary
                else
                    android.R.color.darker_gray
                , null)
            )
        }
        else {
            selectNumber.set(idx.toString())

            btnLevelOne.background = resources.getDrawable(
                if (idx == 1)
                    R.drawable.custom_circle_select_o
                else
                    R.drawable.custom_circle_select_x,
                null
            )

            btnLevelTwo.background = resources.getDrawable(
                if (idx == 2)
                    R.drawable.custom_circle_select_o
                else
                    R.drawable.custom_circle_select_x,
                null
            )

            btnLevelThree.background = resources.getDrawable(
                if (idx == 3)
                    R.drawable.custom_circle_select_o
                else
                    R.drawable.custom_circle_select_x,
                null
            )

            btnLevelFour.background = resources.getDrawable(
                if (idx == 4)
                    R.drawable.custom_circle_select_o
                else
                    R.drawable.custom_circle_select_x,
                null
            )
        }
    }

    fun setSelectLevel(idx : Int) = btnClick(idx)

    fun getSelectLevel() = selectNumber.get()!!.toInt()
}