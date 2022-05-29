package com.vas.week5_2.di

import com.vas.feature_details_screen.domain.useCase.GetDetailsUseCase
import com.vas.feature_details_screen.presentation.DetailsViewModelFactory
import com.vas.feature_main_screen.domain.useCase.GetMainUseCase
import com.vas.feature_main_screen.presentation.MainViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class AppModule {

    @Provides
    fun provideMainViewModelFactory(getMainUseCase: GetMainUseCase): MainViewModelFactory {
        return MainViewModelFactory(getMainUseCase = getMainUseCase)
    }

    @Provides
    fun provideDetailsViewModelFactory(getDetailsUseCase: GetDetailsUseCase): DetailsViewModelFactory {
        return DetailsViewModelFactory(getDetailsUseCase = getDetailsUseCase)
    }
}