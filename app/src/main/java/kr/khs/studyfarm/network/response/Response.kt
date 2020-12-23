package kr.khs.studyfarm.network.response

import kr.khs.studyfarm.network.StudyFarmApi
import retrofit2.HttpException

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

fun errorHandling(t : Throwable) : ResponseError {
    val httpException = t as HttpException
    val errorBody = httpException.response()?.errorBody()!!
    val converter = StudyFarmApi.retrofit.responseBodyConverter<ResponseError>(ResponseError::class.java, ResponseError::class.java.annotations)
    return converter.convert(errorBody)!!
}