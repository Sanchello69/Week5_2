package com.vas.feature_main_screen.data.network

import com.vas.core.utils.Constants.CHARACTERS_URL
import com.vas.feature_main_screen.data.model.CharacterApi
import retrofit2.http.GET

interface ApiInterface {
    @GET(CHARACTERS_URL)
    suspend fun getMainResult(): List<CharacterApi>
}