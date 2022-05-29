package com.vas.feature_main_screen.domain.useCase

import com.vas.feature_main_screen.domain.model.Character
import com.vas.feature_main_screen.domain.repository.MainRepository

class GetMainUseCase(private val mainRepository: MainRepository) {

    suspend fun execute(): List<Character> {
        return mainRepository.getMainResult()
    }
}