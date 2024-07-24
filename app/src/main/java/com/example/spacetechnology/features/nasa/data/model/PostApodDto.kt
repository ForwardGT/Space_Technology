package com.example.spacetechnology.features.nasa.data.model

import com.google.gson.annotations.SerializedName

class PostApodDto(

    @SerializedName("date") val date: String,
    @SerializedName("url") val urlImage: String,
    @SerializedName("explanation") val explanation: String,
    @SerializedName("title") val title: String,

)