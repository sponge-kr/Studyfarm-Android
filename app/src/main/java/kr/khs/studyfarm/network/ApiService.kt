package kr.khs.studyfarm.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

private const val BASE_URL = "http://3.214.168.45:8080/api/v1/"

enum class ApiStatus { LOADING, ERROR, DONE }

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

//private val gson =

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi)) // json to kotlin
    .baseUrl(BASE_URL)
    .build()

interface StudyFarmApiService {
    @Headers("Content-Type: application/hal+json;charset=UTF-8",
    "Accept: application/hal+json")
    @POST("user")
    suspend fun addUser(@Body user : User) : Response
}

object StudyFarmApi {
    val retrofitService : StudyFarmApiService by lazy {
        retrofit.create(StudyFarmApiService::class.java)
    }
}