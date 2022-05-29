package com.vas.feature_main_screen.data.model

import com.google.gson.annotations.SerializedName

data class CharacterApi(

    @SerializedName("Name")
    val name: String,

    @SerializedName("Image")
    val urlIcon: String
)
