package kr.khs.studyfarm.network

import com.squareup.moshi.Json
import retrofit2.HttpException

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

data class ResultSignUp(
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

data class ResultLogin(
    val token : String,
    val user : LoginUser
)

data class ResultCheckEmail(
    val docs : Href,
    val self : Href,
)

data class ResultStates(
    val content : List<State>
)

data class ResultCities(
    val content : List<City>
)

data class State(
    val code : Double,
    val name : String,
    val links : StateLinks
)

data class City(
    val code : Int,
    val name : String
)

data class StateLinks(
    val citylist : Href
)
/**
 * TODO - 어차피 Response는 result부분 제외하고 똑같으니 result를 any로 받고, 필요할때 해당 json을 as로 캐스팅해서 사용하기
 * class 명 재정의 필요할듯.
 */
data class Response(
    val code : Double,
    val message : String,
    val responseTime : String,
    val result : Any
)

data class ResponseError(
    val code : Double,
    val message : String,
    val errorDetails : List<String>?,
    val responseTime : String
)

fun errorHandling(t : Throwable) : ResponseError{
    val httpException = t as HttpException
    val errorBody = httpException.response()?.errorBody()!!
    val converter = StudyFarmApi.retrofit.responseBodyConverter<ResponseError>(ResponseError::class.java, ResponseError::class.java.annotations)
    return converter.convert(errorBody)!!
}