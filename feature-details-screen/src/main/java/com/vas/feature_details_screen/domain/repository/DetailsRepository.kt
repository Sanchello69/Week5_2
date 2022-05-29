package com.vas.feature_details_screen.domain.repository

import com.vas.feature_details_screen.domain.model.CharacterDetails

interface DetailsRepository {
    suspend fun getDetailsResult(name: String) : CharacterDetails
}