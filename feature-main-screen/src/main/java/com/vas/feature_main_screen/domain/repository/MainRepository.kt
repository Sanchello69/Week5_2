package com.vas.feature_main_screen.domain.repository

import com.vas.feature_main_screen.domain.model.Character

interface MainRepository {
    suspend fun getCharacterListResult() : List<Character>
}