package com.hemdan.mvipopularactors.data.remote.api

import com.hemdan.mvipopularactors.data.model.PopularActorsResponse
import com.hemdan.mvipopularactors.data.remote.ApiEndPoints
import com.hemdan.mvipopularactors.data.remote.ApiKeys.PAGE_INDEX
import com.hemdan.mvipopularactors.data.remote.ApiKeys.SEARCH_QUERY
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface PopularActorsListApi {

    @GET(ApiEndPoints.ACTORS_LIST)
    fun getActorsList(@Query(PAGE_INDEX) pageIndex: Int): Single<PopularActorsResponse>

    @GET(ApiEndPoints.ACTOR_SEARCH)
    fun searchActors(@Query(SEARCH_QUERY) searchQuery: String, @Query(PAGE_INDEX) pageIndex: Int): Single<PopularActorsResponse>
}