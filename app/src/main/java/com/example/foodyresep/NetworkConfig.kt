package com.example.foodyresep

import com.example.foodyresep.data.UserResponse
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

class NetworkConfig {



    fun getInterceptor() : OkHttpClient {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()
        return  okHttpClient
    }
    fun getRetrofit() : Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://foodyresep.000webhostapp.com/")
            .client(getInterceptor())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    fun getService(): Users = getRetrofit().create(Users::class.java)
}
interface Users {
    @FormUrlEncoded
    @POST("login.php")
    fun login(
        @Field("email") email: String,
        @Field("password") password: String
    ): Call<UserResponse>

    @FormUrlEncoded
    @POST("register.php")
    fun register(
        @Field("email") email: String,
        @Field("password") password: String,
        @Field("username") username: String
    ): Call<UserResponse>

}