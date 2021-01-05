package kr.khs.studyfarm.network.response

import com.squareup.moshi.Json
import kr.khs.studyfarm.network.request.LoginUser

data class Href(
    val href : String
)

data class Links(
    val self : Href?,
    val edit : Href?,
    val get : Href?,
    val delete : Href?,
    @Json(name = "change-password")
    val changePassword : Href?,
    @Json(name = "change-nickname")
    val changeNickName : Href?,
    val docs : Href?
)

data class ResponseSignUp(
    @Json(name = "users_seq")
    val userSeq : Double,
    val email : String,
    val nickname : String,
    @Json(name = "user_created_at")
    val userCreatedAt : String,
    @Json(name = "user_updated_at")
    val userUpdateAt : String,
    val name : String,
    val phone : String,
    val age : Double,
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

data class ResponseLogin(
    val token : String,
    val user : LoginUser
)

data class ResponseCheckEmail(
    val docs : Href,
    val self : Href,
)

data class ResponseStates(
    val content : List<State>
)

data class ResponseCities(
    val content : List<City>
)

data class State(
    val code : Double,
    val name : String,
    val children : List<City>
)

data class City(
    val code : Int,
    val name : String
)

data class StateLinks(
    val citylist : Href
)

data class NicknameLinks(
    val docs : Href,
    val self : Href
)

data class ResponseCheckNickname(
    val exist : Boolean,
    val links : NicknameLinks
)