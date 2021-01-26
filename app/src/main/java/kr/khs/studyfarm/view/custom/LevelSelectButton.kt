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
import kr.khs.studyfarm.R

class LevelSelectButton @JvmOverloads constructor(
    context : Context, attrs : AttributeSet? = null, defStyle: Int = 0
) : ConstraintLayout(context, attrs, defStyle) {

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

    private var startIdx = 0
    private var endIdx = 0

    init {
        val inflaterService = Context.LAYOUT_INFLATER_SERVICE
        val layoutInflater = getContext().getSystemService(inflaterService) as LayoutInflater
        val view = layoutInflater.inflate(R.layout.button_level_select, this, false)
        addView(view)

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
            if(startIdx == 0 && endIdx == 0) {
                startIdx = idx
            }
            else if(startIdx != 0 && endIdx == 0) {
                when {
                    startIdx == idx -> startIdx = 0
                    startIdx > idx -> {
                        endIdx = startIdx
                        startIdx = idx
                    }
                    else -> {
                        endIdx = idx
                    }
                }
            }
            else { // startIdx != 0 && endIdx != 0
                if(startIdx == idx) {
                    startIdx = endIdx
                    endIdx = 0
                }
                else if(endIdx == idx) {
                    endIdx = 0
                }
                else if(startIdx > idx)
                    startIdx = idx
                else if(endIdx < idx)
                    endIdx = idx
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
    }

    fun getSelectLevel() =
        if(isRange)
            startIdx * 10 + endIdx
        else
            selectNumber
}