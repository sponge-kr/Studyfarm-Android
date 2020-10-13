package kr.khs.studyfarm.network

import com.squareup.moshi.Json

data class Href(
    val href : String
)

data class Links(
    val self : Href,
    val edit : Href,
    val get : Href,
    val delete : Href,
    @Json(name = "change-password")
    val changePassword : Href,
    @Json(name = "change-nickname")
    val changeNickName : Href,
    val docs : Href
)

//data class Links(
//    val links : HashMap<String, Href>
//)

data class Result(
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
    val links : Links
)

data class Response(
    val code : Double,
    val message : String,
    val responseTime : String,
    val result : Result
)