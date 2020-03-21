package com.example.devjobtracker

import android.accounts.AuthenticatorDescription
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
const val BASE_URL = "https://jobs.github.com/" //Pass "positions.json?" as a parameter in the get request and "description=ruby" as query for example
const val TEST_BASE_URL = "https://jsonplaceholder.typicode.com/" //All the job offers in SF area with REACT in the description
const val TEST_PARAMS = "positions.json?location=sf&description=react" //
//authentic jobs api key ab75b9d90f263baf5fdca2a2bfc53133
interface JobOfferAPI {
    @GET("/positions.json")
    fun getPositions(@Query("description") description: String) : Call<List<JobOffer>>

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

// Example of call to the authentic jobs api "https://authenticjobs.com/api?api_key=ab75b9d90f263baf5fdca2a2bfc53133&method=aj.jobs.search&keywords=php,mysql&perpage=1&format=json"
// Auth jobs key : ab75b9d90f263baf5fdca2a2bfc53133