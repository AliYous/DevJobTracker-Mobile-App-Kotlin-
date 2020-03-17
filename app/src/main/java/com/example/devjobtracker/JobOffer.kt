package com.example.devjobtracker

import android.accounts.AuthenticatorDescription
import java.util.*

data class JobOffer (
    val id: String,
    val type: String,
    val url: String,
    val created_at: Date,
    val company: String,
    val location: String,
    val title: String,
    val description: String
)