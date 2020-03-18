package com.example.devjobtracker

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

const val BASE_URL = "https://jobs.github.com/" //All the job offers in SF area with REACT in the description
const val TEST_PARAMS = "positions.json?location=sf&description=react"

interface JobOfferAPI {
    @GET(TEST_PARAMS)
    fun getPositions(): Call<List<JobOffer>>

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