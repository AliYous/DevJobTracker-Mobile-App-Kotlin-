package com.example.devjobtracker

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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

        holder.view.textViewTitle.text = jobOffer.title  //Binds title data to the view (txtView having the id : textWiewTitle in layout_offer.xml)
        holder.view.textViewLocation.text = jobOffer.body
        //We need to bind the data the same exact way for all of the JobOffer's class attributes, I'm just testing with this for now

        //Will show only if the offer is 'new', need to write a function that changes the new variable from true to false based on the 'created_at' date
        //holder.view.textViewIsNew.visibility = if (jobOffer.isNew) View.VISIBLE else View.INVISIBLE
    }

    class JobOfferViewHolder(val view: View) : RecyclerView.ViewHolder(view)
}