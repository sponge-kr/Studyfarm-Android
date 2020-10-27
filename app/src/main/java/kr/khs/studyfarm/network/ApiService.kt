package kr.khs.studyfarm.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.*

private const val BASE_URL = "http://3.214.168.45:8080/api/v1/"

enum class ApiStatus { LOADING, ERROR, DONE }

//TODO - 헤더 한번에 고정시키기(지금은 못찾겟음)
private val headerInterceptor = Interceptor {
    val request = it.request()
        .newBuilder()
        .addHeader("Content-Type", "application/hal+json;charset=UTF-8")
        .addHeader("Accept", "application/hal+json")
        .build()
    return@Interceptor it.proceed(request)
}

private val loggingInterceptor = HttpLoggingInterceptor().apply {
    level = HttpLoggingInterceptor.Level.BODY
}
private val clientBuilder = OkHttpClient.Builder().apply {
    addInterceptor(loggingInterceptor)
//    addInterceptor(headerInterceptor)
}

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

interface StudyFarmApiService {
    @Headers("Content-Type: application/hal+json;charset=UTF-8",
        "Accept: application/hal+json")
    @POST("user")
    suspend fun addUser(@Body user : User) : Response


    @Headers("Content-Type: application/hal+json;charset=UTF-8",
        "Accept: application/hal+json")
    @POST("auth/login")
    suspend fun loginUser(@Body login : LoginData) : Response

    @Headers("Content-Type: application/hal+json;charset=UTF-8",
        "Accept: application/hal+json")
    @GET("user/check-email/{email}")
    suspend fun checkEmail(@Path("email") email : String) : Response

    @Headers("Content-Type: application/hal+json;charset=UTF-8",
        "Accept: application/hal+json")
    @GET("user/check-nickname")
    suspend fun checkNickName(@FieldMap params : Map<String, String>) : Response
}

object StudyFarmApi {
    private val _retrofit = Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create(moshi)) // json to kotlin
        .baseUrl(BASE_URL)
        .client(clientBuilder.build())
        .build()

    val retrofit : Retrofit
        get() = _retrofit

    val retrofitService : StudyFarmApiService by lazy {
        retrofit.create(StudyFarmApiService::class.java)
    }
}