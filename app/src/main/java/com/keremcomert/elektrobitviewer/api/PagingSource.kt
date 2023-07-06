package com.keremcomert.elektrobitviewer.api

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.keremcomert.elektrobitviewer.model.Country
import com.keremcomert.elektrobitviewer.util.BASE_URL
import com.keremcomert.elektrobitviewer.util.INITIAL_PAGE_INDEX
import retrofit2.HttpException
import java.io.IOException
import java.util.*

/**
 * @param sourceApi is the API requesting the pages. There is only one instance within this app
 * @return PagingSource, with the requested articles retrieved from the API endpoint.
 */
class PagingSource(
    private val sourceApi: SourceApi,
): PagingSource<Int, Country>(){


    /**
     * @param params Includes the current key, needed to know which page the user
     * requests the function for.
     * The API has only one endpoint to simply return the whole data, but one can
     * be smarter with this by defining several endpoints to get countries, sites and
     * site details separately for instance.
     * @return The LoadResult, that contains the returned countries and the keys
     * @exception HTTPException for 5** response codes.
     *@exception IOException for connectivity related issues.
     */
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Country> {
        val currentPage = params.key ?: INITIAL_PAGE_INDEX

        return try{
            val response = sourceApi.getData(BASE_URL)
            LoadResult.Page(
                data = response.countries,
                prevKey = if(currentPage == INITIAL_PAGE_INDEX) null else currentPage - 1,
                nextKey = if(response.countries.isEmpty()) null else currentPage + 1
            )
        }catch (e: HttpException){
            LoadResult.Error(e)
        }catch (e: IOException){
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Country>): Int? = state.anchorPosition
}