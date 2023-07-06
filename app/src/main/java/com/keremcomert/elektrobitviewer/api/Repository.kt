package com.keremcomert.elektrobitviewer.api

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import javax.inject.Inject
import javax.inject.Singleton

/**
 * The repository that acts as a middle-ware between the requesters within the app and the
 * external API.
 */
@Singleton
class Repository @Inject constructor(private val sourceApi: SourceApi) {

    /**
     * @return A LiveData of PagingData, which mirrors the stream provided by Pager.flow,
     * but exposes it as a LiveData for the front-end to consume.
     */
    fun getResults(selectedRover: String) =
        Pager(config = PagingConfig(pageSize = 25, maxSize = 100, enablePlaceholders = false),
            pagingSourceFactory  = { PagingSource(sourceApi = sourceApi) }).liveData
}