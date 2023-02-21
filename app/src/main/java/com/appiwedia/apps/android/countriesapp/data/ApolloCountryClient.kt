package com.appiwedia.apps.android.countriesapp.data

import com.apollographql.apollo3.ApolloClient
import com.appiwedia.apps.android.CountriesQuery
import com.appiwedia.apps.android.CountryQuery
import com.appiwedia.apps.android.countriesapp.domain.CountryClient
import com.appiwedia.apps.android.countriesapp.domain.DetailedCountry
import com.appiwedia.apps.android.countriesapp.domain.SimpleCountry

class ApolloCountryClient(
    private val apolloClient: ApolloClient
) : CountryClient {

    override suspend fun getCountries(): List<SimpleCountry> {
        return apolloClient
            .query(CountriesQuery())
            .execute()
            .data
            ?.countries
            ?.map { it.toSimpleCountry() }
            ?: emptyList()
    }

    override suspend fun getCountry(code: String): DetailedCountry? {
        return apolloClient
            .query(CountryQuery(code))
            .execute()
            .data
            ?.country
            ?.toDetailedCountry()
    }
}