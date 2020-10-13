package kr.khs.studyfarm.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

private const val BASE_URL = "http://3.214.168.45:8080/api/v1/"

enum class ApiStatus { LOADING, ERROR, DONE }

private val loggingInterceptor = HttpLoggingInterceptor().apply {
    level = HttpLoggingInterceptor.Level.BODY
}
private val clientBuilder = OkHttpClient.Builder().apply {
    addInterceptor(loggingInterceptor)
}

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()



interface StudyFarmApiService {
    @Headers("Content-Type: application/hal+json;charset=UTF-8",
    "Accept: application/hal+json")
    @POST("user")
    suspend fun addUser(@Body user : User) : Response
}

object StudyFarmApi {
    val retrofit = Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create(moshi)) // json to kotlin
        .baseUrl(BASE_URL)
        .client(clientBuilder.build())
        .build()

    val retrofitService : StudyFarmApiService by lazy {
        retrofit.create(StudyFarmApiService::class.java)
    }
}