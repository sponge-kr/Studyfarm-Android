package kr.khs.studyfarm.network.response

import com.squareup.moshi.Json

data class GetUserResponse(
    val code : Double,
    val message : String,
    val responseTime : String,
    val result : UserInfo
)

data class UserInfo(
    @Json(name = "users_seq")
    val userSeq : Double,
    val email : String,
    val nickname : String,
    val gender : String?,
    val age : Double?,
    val interesting : List<Any>,
    @Json(name = "simple_introduce")
    val simpleIntroduce : String?,
    val profile : String?,
    @Json(name = "user_info_process")
    val userInfoProcess : Boolean,
    @Json(name = "user_city_info")
    val userCityInfo : List<Any>,
    @Json(name = "user_created_at")
    val userCreatedAt : String,
    @Json(name = "user_updated_at")
    val userUpdateAt : String,
    @Json(name = "user_active")
    val userActive : Boolean,
    val links : Links
)