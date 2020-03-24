package com.example.devjobtracker

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.layout_offer.view.*

class JobOffersAdapter(private val jobOffers : List<JobOffer>) : RecyclerView.Adapter<JobOffersAdapter.JobOfferViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JobOfferViewHolder {
        return JobOfferViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.layout_offer, parent, false)
        )
    }

    override fun getItemCount() = jobOffers.size

    override fun onBindViewHolder(holder: JobOfferViewHolder, position: Int) {
        val jobOffer = jobOffers[position]

        holder.view.textViewTitle.text = jobOffer.title.subSequence(0,10)
        holder.view.textViewLocation.text = jobOffer.body.subSequence(0,10) //Pour réduire a 50 le nb de char en attendant d'avoir la vraie data
        //We need to bind the data the same exact way for all of the JobOffer's class attributes, I'm just testing with this for now

        /*holder.view.buttonSeeOffer.setOnClickListener(({
            val intent = Intent(Context context, SeeOfferActivity::class.java)
            //intent.putExtra("jobOffer", jobOffer)
            startActivity(intent)
        }))*/
        //Will show only if the offer is 'new', need to write a function that changes the new variable from true to false based on the 'created_at' date
        //holder.view.textViewIsNew.visibility = if (jobOffer.isNew) View.VISIBLE else View.INVISIBLE
    }

    class JobOfferViewHolder(val view: View) : RecyclerView.ViewHolder(view)
}