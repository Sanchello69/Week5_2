package com.vas.feature_details_screen.data.network

import com.vas.feature_details_screen.data.model.CharacterDetailsApi

class ApiDetailsHelper(private val apiInterface: ApiDetailsInterface) {
    suspend fun getDetailsResult(name: String) : List<CharacterDetailsApi> {
        return apiInterface.getDetailsResult(name = name)
    }

}