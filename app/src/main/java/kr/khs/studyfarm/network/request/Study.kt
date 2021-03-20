package kr.khs.studyfarm.network.request

import com.squareup.moshi.Json

data class MakeStudyData(
    val title : String,
    val content : String,
    val objective : String,
    @Json(name = "recruit_number")
    val numberOfMember : Int,
    @Json(name = "is_ignore_recruit")
    val isIgnoreRecruit : Boolean,
    @Json(name = "member_check_type")
    val typeOfRecruit : Int,
    @Json(name = "progress_type")
    val typeOfProgress : Int,
    val steps : List<Int>,
    @Json(name = "start_date")
    val startDate : String,
    @Json(name = "end_date")
    val endDate : String,
    @Json(name = "is_date_discuss")
    val isDateDiscuss : Boolean,
    val state : Int,
    val city : Int,
    val topic : Int,
    @Json(name = "studycafe_seq")
    val studyCafeSeq : Int?,
)