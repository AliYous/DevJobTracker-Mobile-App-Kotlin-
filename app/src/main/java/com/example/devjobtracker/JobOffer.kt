package com.example.devjobtracker

import android.accounts.AuthenticatorDescription
import com.google.gson.annotations.SerializedName
import java.util.*

data class JobOffer (
    // --Test values ---

    @SerializedName("userId")
    val userId: Int,
    @SerializedName("id")
    val id: Int ,
    @SerializedName("title")
    val title: String,
    @SerializedName("body")
    val body: String

    // --! Test values ---


    // Real attributes for job offer, commented for test purpose
    /*
    @SerializedName("id")
    val id: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("url")
    val url: String,
    @SerializedName("created_at")
    val created_at: Date,
    @SerializedName("company")
    val company: String,
    @SerializedName("company_url")
    val company_url: String,
    @SerializedName("location")
    val location: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("how_to_apply")
    val how_to_apply: String,
    @SerializedName("company_logo")
    val company_logo: String
    */


)