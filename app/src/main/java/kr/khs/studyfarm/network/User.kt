package kr.khs.studyfarm.network

import com.squareup.moshi.Json

data class Interesting(
    val name : String,
    @Json(name = "skill_level")
    val skillLevel : String
)

data class User(
    val email : String,
    val password : String,
    val nickname : String,
    val name : String = "",
    val phone : String = "",
    val age : Double = 0.0,
    val state : Double = 0.0,
    val city : Double = 0.0,
    val simpleIntroduce : String = "",
    val profile : String?,
    @Json(name = "city_info")
    val cityInfo : List<Int>,
    @Json(name = "born_date")
    val bornDate : String = "2000-01-01",
    val gender : Int,
    val interesting : List<Interesting>,
    @Json(name = "service_way")
    val serviceWay : String,
    @Json(name = "study_purpose")
    val studyPurpose : String,
    @Json(name = "service_use_agree")
    val serviceAgree : Boolean,
)

data class LoginUser(
    @Json(name = "users_seq")
    val userSeq : Double,
    val email : String,
    @Json(name = "user_created_at")
    val userCreatedAt : String,
    @Json(name = "user_updated_at")
    val userUpdateAt : String,
    val name : String,
    val phone : String,
    val age : Double,
    val nickname : String,
    @Json(name = "user_state")
    val userState : Double,
    @Json(name = "user_city")
    val userCity : Double,
    @Json(name = "simple_introduce")
    val simpleIntroduce : String,
    val profile : String?,
    @Json(name = "user_active")
    val userActive : Boolean,
)

data class LoginData(
    val email : String,
    val password : String
)