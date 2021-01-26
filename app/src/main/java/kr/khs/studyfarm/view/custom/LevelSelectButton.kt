package kr.khs.studyfarm.view.custom

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingComponent
import androidx.databinding.DataBindingUtil
import kr.khs.studyfarm.R
import kr.khs.studyfarm.databinding.ButtonLevelSelectBindingImpl
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

    private lateinit var lineOne : View
    private lateinit var lineTwo : View
    private lateinit var lineThree : View

    private var levelOneName = "Level 1"
    private var levelTwoName = "Level 2"
    private var levelThreeName = "Level 3"
    private var levelFourName = "Level 4"

    private var selectNumber = 0

    private var isRange = false

//    private var startIdx = 0
//    private var endIdx = 0

    private val startIdx : Int
        get() = selectNumber / 10

    private val endIdx : Int
        get() = selectNumber % 10

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

        initViews()
        initAttrs(attrs)
        initSettings()
    }

    private fun initViews() {
        btnLevelOne = findViewById(R.id.levelselect_button_level1)
        btnLevelTwo = findViewById(R.id.levelselect_button_level2)
        btnLevelThree = findViewById(R.id.levelselect_button_level3)
        btnLevelFour = findViewById(R.id.levelselect_button_level4)

        textLevelOne = findViewById(R.id.levelselect_tv_level1)
        textLevelTwo = findViewById(R.id.levelselect_tv_level2)
        textLevelThree = findViewById(R.id.levelselect_tv_level3)
        textLevelFour = findViewById(R.id.levelselect_tv_level4)

        lineOne = findViewById(R.id.levelselect_line1)
        lineTwo = findViewById(R.id.levelselect_line2)
        lineThree = findViewById(R.id.levelselect_line3)
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
        if(isRange) {
            if(idx == 0) {
                print("1 : $selectNumber, $idx")
                selectNumber = 0
            }
            else if(startIdx == 0 && endIdx == 0) {
                print("2 : $selectNumber, $idx")
                selectNumber = if(idx / 10 > 0) (idx / 10) * 10 + idx % 10 else idx * 10
            }
            else if(startIdx != 0 && endIdx == 0) {
                print("3 : $selectNumber, $idx")
                selectNumber = when {
                    startIdx == idx -> 0
                    else -> {
                        min(startIdx, idx) * 10 + max(startIdx, idx)
                    }
                }
            }
            else { // startIdx != 0 && endIdx != 0
                print("4 : $selectNumber, $idx")
                if(startIdx == idx) {
                    selectNumber = (selectNumber % 10) * 10
                }
                else if(endIdx == idx) {
                    selectNumber = (selectNumber / 10) * 10
                }
                else if(startIdx > idx) {
                    selectNumber = (selectNumber % 10) + idx * 10
                }
                else if(endIdx < idx) {
                    selectNumber = (selectNumber / 10) * 10 + idx
                }
                // 사이를 선택했다면 어떻게 처리가 될 것인지
            }

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
            selectNumber = idx

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
        println(", $selectNumber")
    }

    fun setSelectLevel(idx : Int) = btnClick(idx)

    fun getSelectLevel() =
        if(isRange)
            startIdx * 10 + endIdx
        else
            selectNumber
}