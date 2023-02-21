package com.appiwedia.apps.android.countriesapp.domain

interface CountryClient {

    suspend fun getCountries(): List<SimpleCountry>
    suspend fun getCountry(code: String): DetailedCountry?
}