package com.chiragshetty.cryptocurrencyapp.presentation.coin_detail

import com.chiragshetty.cryptocurrencyapp.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)