package com.keremcomert.elektrobitviewer.api

import retrofit2.http.GET
import retrofit2.http.Url

interface SourceApi {
    /**
     * The GET method that interfaces with the API. It requires the suspend keyword as API
     * operations are asynchronous.
     * @param urlToGet depends on simply the BASE_URL, but one can alternatively define different endpoints.
     * @return An instance of Response data class, that contains a List of returned Countries.
     */
    @GET
    suspend fun getData(@Url urlToGet: String): Response
}