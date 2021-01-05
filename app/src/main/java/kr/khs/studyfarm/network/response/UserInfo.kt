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
    val interesting : List<UserInterestingInfo>,
    @Json(name = "simple_introduce")
    val simpleIntroduce : String?,
    val profile : String?,
    @Json(name = "user_info_process")
    val userInfoProcess : Boolean,
    @Json(name = "user_city_info")
    val userCityInfo : List<UserCityInfo>,
    @Json(name = "user_created_at")
    val userCreatedAt : String,
    @Json(name = "user_updated_at")
    val userUpdateAt : String,
    @Json(name = "user_active")
    val userActive : Boolean,
    val links : Links
)

data class UserInterestingInfo(
    val code : Double = 0.0,
    val name : String,
    @Json(name = "skill_level")
    val skillLevel : Double = 0.0,
    @Json(name = "parent_code")
    val parentCode : Double = 0.0,
)

data class UserCityInfo(
    @Json(name = "state_code")
    val stateCode : Double,
    @Json(name = "state_name")
    val stateName : String,
    @Json(name = "city_code")
    val cityCode : Double,
    @Json(name = "city_name")
    val cityName : String
)