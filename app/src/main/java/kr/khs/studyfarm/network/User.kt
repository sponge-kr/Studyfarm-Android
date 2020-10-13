package kr.khs.studyfarm.network

data class User(
    val email : String,
    val password : String,
    val nickname : String,
    val name : String,
    val phone : String,
    val age : Double,
    val state : Double,
    val city : Double,
    val simpleIntroduce : String,
    val profile : String?
)