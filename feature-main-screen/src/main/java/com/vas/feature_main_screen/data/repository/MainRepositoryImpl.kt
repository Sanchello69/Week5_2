package com.vas.feature_main_screen.data.repository

import com.vas.feature_main_screen.data.network.ApiHelper
import com.vas.feature_main_screen.domain.model.Character
import com.vas.feature_main_screen.domain.repository.MainRepository

class MainRepositoryImpl(private val apiHelper: ApiHelper): MainRepository {

    override suspend fun getCharacterListResult() : List<Character> = apiHelper.getCharacterListResult().map {
        Character(
            name = it.name,
            urlIcon = it.urlIcon
        )
    }
}