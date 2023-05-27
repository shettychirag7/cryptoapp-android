package com.chiragshetty.cryptocurrencyapp.domain.use_case.get_coins

import com.chiragshetty.cryptocurrencyapp.common.Resource
import com.chiragshetty.cryptocurrencyapp.data.remote.dto.toCoin
import com.chiragshetty.cryptocurrencyapp.domain.model.Coin
import com.chiragshetty.cryptocurrencyapp.domain.repository.ICoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: ICoinRepository
) {
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading())
            val coins = repository.getCoins().map { it.toCoin() }
            emit(Resource.Success(coins))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occured"))
        } catch (e: IOException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occured"))
        }
    }
}