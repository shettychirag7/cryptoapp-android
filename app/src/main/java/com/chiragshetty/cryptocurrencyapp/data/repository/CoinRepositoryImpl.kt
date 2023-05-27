package com.chiragshetty.cryptocurrencyapp.data.repository

import com.chiragshetty.cryptocurrencyapp.data.remote.CoinPaprikaApi
import com.chiragshetty.cryptocurrencyapp.data.remote.dto.CoinDetailDto
import com.chiragshetty.cryptocurrencyapp.data.remote.dto.CoinDto
import com.chiragshetty.cryptocurrencyapp.domain.repository.ICoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
) : ICoinRepository {
    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoin(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId)
    }
}