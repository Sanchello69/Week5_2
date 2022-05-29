package com.vas.week5_2.di

import com.vas.feature_details_screen.domain.repository.DetailsRepository
import com.vas.feature_details_screen.domain.useCase.GetDetailsUseCase
import com.vas.feature_main_screen.domain.repository.MainRepository
import com.vas.feature_main_screen.domain.useCase.GetMainUseCase
import dagger.Module
import dagger.Provides

@Module
class DomainModule {

    @Provides
    fun provideGetMainUseCase(mainRepository: MainRepository): GetMainUseCase{
        return GetMainUseCase(mainRepository = mainRepository)
    }

    @Provides
    fun provideGetDetailsUseCase(detailsRepository: DetailsRepository): GetDetailsUseCase {
        return GetDetailsUseCase(detailsRepository = detailsRepository)
    }
}