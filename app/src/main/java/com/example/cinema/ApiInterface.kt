package com.example.cinema

import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiInterface {
   @Headers(
        "X-RapidAPI-Key: 0580e53b5emshd579628326954fcp1aadaejsneacb796f56c6",
    "X-RapidAPI-Host: moviesdatabase.p.rapidapi.com")

    @GET("titles?")
fun getMovies(@Query ("list") sort : String) : Call<movies>

    companion object {
        var BASE_URL = "https://moviesdatabase.p.rapidapi.com/"

        fun create() : ApiInterface {

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())

                .baseUrl(BASE_URL)
                .build()

            return retrofit.create(ApiInterface::class.java)

        }
    }
}