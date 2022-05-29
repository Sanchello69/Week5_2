package com.vas.feature_details_screen.data.repository

import com.vas.feature_details_screen.data.network.ApiDetailsHelper
import com.vas.feature_details_screen.domain.model.CharacterDetails
import com.vas.feature_details_screen.domain.repository.DetailsRepository

class DetailsRepositoryImpl(private val apiHelper: ApiDetailsHelper): DetailsRepository {

    override suspend fun getDetailsResult(name: String): CharacterDetails {
        val resultList = apiHelper.getDetailsResult(name)
        val result = resultList[0]
        return CharacterDetails(
            name = result.name,
            urlIcon = result.urlIcon,
            characterType = result.characterType,
            powers = result.powers
        )
    }


}