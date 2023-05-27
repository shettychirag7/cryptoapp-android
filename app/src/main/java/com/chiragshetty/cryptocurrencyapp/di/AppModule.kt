package com.chiragshetty.cryptocurrencyapp.di

import com.chiragshetty.cryptocurrencyapp.common.Constants
import com.chiragshetty.cryptocurrencyapp.data.remote.CoinPaprikaApi
import com.chiragshetty.cryptocurrencyapp.data.repository.CoinRepositoryImpl
import com.chiragshetty.cryptocurrencyapp.domain.repository.ICoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideCoinPaprikaApi(): CoinPaprikaApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinPaprikaApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCoinRepository(api: CoinPaprikaApi): ICoinRepository {
        return CoinRepositoryImpl(api)
    }
}