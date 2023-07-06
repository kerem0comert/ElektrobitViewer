package com.keremcomert.elektrobitviewer.api

import com.keremcomert.elektrobitviewer.model.Country


data class Response(
    val countries: List<Country>
)