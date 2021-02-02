package kr.khs.studyfarm.network.request

import com.squareup.moshi.Json

data class MakeStudyData(
    val title : String,
    val content : String,
    @Json(name = "recruit_number")
    val numberOfMemeber : Int,
    @Json(name = "member_check_type")
    val typeOfRecruit : Int,
    @Json(name = "progress_type")
    val typeOfProgress : Int,
    val steps : Array<Int>,
    @Json(name = "start_date")
    val startDate : String,
    @Json(name = "end_date")
    val endDate : String,
    val state : Int,
    val city : Int,
    val topic : Int,
    @Json(name = "studycafe_seq")
    val studyCafeSeq : Int,
)