package com.example.devjobtracker

import android.accounts.AuthenticatorDescription
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

const val BASE_URL = "https://jsonplaceholder.typicode.com/" //All the job offers in SF area with REACT in the description
const val TEST_PARAMS = "positions.json?location=sf&description=react" //

interface JobOfferAPI {
    @GET("/posts")
    fun getPositions() : Call<List<JobOffer>>

    companion object {

        operator fun invoke() : JobOfferAPI{
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(JobOfferAPI::class.java)
        }
    }

}