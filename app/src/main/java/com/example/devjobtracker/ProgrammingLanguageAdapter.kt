package com.example.devjobtracker

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.layout_language.view.*

class ProgrammingLanguageAdapter(private val programmingLanguages : List<ProgrammingLanguage>) : RecyclerView.Adapter<ProgrammingLanguageAdapter.ProgrammingLanguageViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProgrammingLanguageViewHolder {
        return ProgrammingLanguageViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.layout_language, parent, false)
        )
    }
    override fun getItemCount() = programmingLanguages.size

    override fun onBindViewHolder(holder: ProgrammingLanguageViewHolder, position: Int) {
        val programmingLanguage = programmingLanguages[position]
        holder.view.textViewTitleLang.text = "Ruby"//programmingLanguage.name
    }


    class ProgrammingLanguageViewHolder(val view: View) : RecyclerView.ViewHolder(view)



}