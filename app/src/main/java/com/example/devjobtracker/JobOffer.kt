package com.example.devjobtracker

import android.accounts.AuthenticatorDescription
import com.google.gson.annotations.SerializedName
import java.util.*

data class JobOffer (
    @SerializedName("userId")
    val userId: Int,
    @SerializedName("id")
    val id: Int ,
    @SerializedName("title")
    val title: String,
    @SerializedName("body")
    val body: String


    //@SerializedName("id")
    //val id: String,
    //@SerializedName("type")
    //val type: String,
    //@SerializedName("url")
    //val url: String,
    //@SerializedName("created_at")
    //val created_at: Date,
    //@SerializedName("company")
    //val company: String,
    //@SerializedName("location")
    //val location: String,
    //@SerializedName("title")
    //val title: String,
    //@SerializedName("description")
    //val description: String
)