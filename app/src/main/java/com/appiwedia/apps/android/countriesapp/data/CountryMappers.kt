package com.appiwedia.apps.android.countriesapp.data

import com.appiwedia.apps.android.CountriesQuery
import com.appiwedia.apps.android.CountryQuery
import com.appiwedia.apps.android.countriesapp.domain.DetailedCountry
import com.appiwedia.apps.android.countriesapp.domain.SimpleCountry


fun CountryQuery.Country.toDetailedCountry(): DetailedCountry {
    return DetailedCountry(
        code = code,
        name = name,
        emoji = emoji,
        capital = capital ?: "No capital",
        currency = currency ?: "No currency",
        languages = languages.mapNotNull { it.name },
        continent = continent.name
    )
}

fun CountriesQuery.Country.toSimpleCountry(): SimpleCountry {
    return SimpleCountry(
        code = code,
        name = name,
        emoji = emoji,
        capital = capital ?: "No capital"
    )
}