package com.chiragshetty.cryptocurrencyapp.domain.repository

import com.chiragshetty.cryptocurrencyapp.data.remote.dto.CoinDetailDto
import com.chiragshetty.cryptocurrencyapp.data.remote.dto.CoinDto

interface ICoinRepository {

    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoin(coinId: String): CoinDetailDto
}