package com.example.foodyresep

import com.example.foodyresep.data.UserResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.POST

class NetworkConfig {
//    fun getInterceptor() : OkHttpClient {
//        val logging = HttpLoggingInterceptor()
//        logging.level = HttpLoggingInterceptor.Level.BODY
//        val okHttpClient = OkHttpClient.Builder()
//            .addInterceptor(logging)
//            .build()
//        return  okHttpClient
//    }
//    fun getRetrofit() : Retrofit {
//        return Retrofit.Builder()
//            .baseUrl("https://foodyresep.000webhostapp.com/")
//            .client(getInterceptor())
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//    }
//    fun getService() = getRetrofit().create(Users::class.java)
}
interface Users {
    @POST("login.php")
    fun login(
        @Field("email") email: String,
        @Field("password") password: String
    ): Call<UserResponse>

    @POST("register.php")
    fun register(
        @Field("email") email: String,
        @Field("password") password: String,
        @Field("usernmae") username: String
    ): Call<UserResponse>

}