package data.remote.api

import domain.model.Currency
import domain.model.RequestState

interface CurrencyApiService {
    fun getLatestExchangeRates(): RequestState<List<Currency>>
}