package com.chiragshetty.cryptocurrencyapp.domain.use_case.get_coin

import com.chiragshetty.cryptocurrencyapp.common.Resource
import com.chiragshetty.cryptocurrencyapp.data.remote.dto.toCoinDetail
import com.chiragshetty.cryptocurrencyapp.domain.model.CoinDetail
import com.chiragshetty.cryptocurrencyapp.domain.repository.ICoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: ICoinRepository
) {
    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading())
            val coin = repository.getCoin(coinId).toCoinDetail()
            emit(Resource.Success(coin))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occured"))
        } catch (e: IOException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occured"))
        }
    }
}