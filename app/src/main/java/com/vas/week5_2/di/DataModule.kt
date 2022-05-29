package com.vas.week5_2.di

import com.vas.feature_details_screen.data.network.ApiDetailsHelper
import com.vas.feature_details_screen.data.network.RetrofitDetailsClient
import com.vas.feature_details_screen.data.repository.DetailsRepositoryImpl
import com.vas.feature_details_screen.domain.repository.DetailsRepository
import com.vas.feature_main_screen.data.network.ApiHelper
import com.vas.feature_main_screen.data.network.RetrofitClient
import com.vas.feature_main_screen.data.repository.MainRepositoryImpl
import com.vas.feature_main_screen.domain.repository.MainRepository
import dagger.Module
import dagger.Provides

@Module
class DataModule {

    @Provides
    fun provideApiHelper(): ApiHelper {
        return ApiHelper(RetrofitClient.apiInterface)
    }

    @Provides
    fun provideMainRepository(apiHelper: ApiHelper): MainRepository{
        return MainRepositoryImpl(apiHelper = apiHelper)
    }

    @Provides
    fun provideDetailsApiHelper(): ApiDetailsHelper{
        return ApiDetailsHelper(RetrofitDetailsClient.apiInterface)
    }

    @Provides
    fun provideDetailsRepository(apiHelper: ApiDetailsHelper): DetailsRepository{
        return DetailsRepositoryImpl(apiHelper = apiHelper)
    }
}