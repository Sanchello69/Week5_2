package com.vas.feature_main_screen.data.network

class ApiHelper (private val apiInterface: ApiInterface) {
    suspend fun getCharacterListResult() =
        apiInterface.getCharacterListResult()
}