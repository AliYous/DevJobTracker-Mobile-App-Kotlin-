package com.example.devjobtracker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Whenever we swipe down (to refresh the page) it will recall fetchJobOffers() to get the latest offers available
        refreshLayout.setOnRefreshListener {
            fetchJobOffers()
        }

        //Test Languages

        //to fetch the offers whenever the ui is displayed
        showProgLanguages(fetchProgLanguages())
        fetchJobOffers()
    }



    //Fetches all Offers (Positions) from the API
    private fun fetchJobOffers() {
        refreshLayout.isRefreshing = true;
        JobOfferAPI().getPositions().enqueue(object: Callback<List<JobOffer>> {

            override fun onFailure(call: Call<List<JobOffer>>, t: Throwable) {
                refreshLayout.isRefreshing = false;
                Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
            }

            override fun onResponse(call: Call<List<JobOffer>>, response: Response<List<JobOffer>>) {
                refreshLayout.isRefreshing = false;
                val jobOffers = response.body()
                jobOffers?.let{
                    showJobOffers(jobOffers)
                }
            }
        } )
    }

    fun fetchProgLanguages(): List<ProgrammingLanguage> {
        //Creating languages manually to test
        val python = ProgrammingLanguage("Python", R.drawable.python)
        val java = ProgrammingLanguage("Java", R.drawable.java)
        val ruby = ProgrammingLanguage("Ruby", R.drawable.ruby)
        val csharp = ProgrammingLanguage("C#", R.drawable.csharp)
        val javascript = ProgrammingLanguage("JavaScript", R.drawable.javascript)
        val swift = ProgrammingLanguage("Swift", R.drawable.swift)
        val angular = ProgrammingLanguage("AngularJS", R.drawable.angular)
        val node = ProgrammingLanguage("nodeJS", R.drawable.nodejs)

        val progLanguages = listOf(python, java, ruby, csharp, javascript, swift, angular,  node)
        return progLanguages
    }


    private fun showJobOffers(jobOffers: List<JobOffer>) {
        recyclerViewOffers.layoutManager = LinearLayoutManager(this)
        recyclerViewOffers.adapter = JobOffersAdapter(jobOffers)
    }

    private fun showProgLanguages(progLanguages: List<ProgrammingLanguage>) {
        recyclerViewLanguages.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerViewLanguages.adapter = ProgrammingLanguageAdapter(progLanguages)
    }
}
