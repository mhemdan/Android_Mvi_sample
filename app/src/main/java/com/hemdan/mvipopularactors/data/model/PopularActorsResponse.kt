package com.hemdan.mvipopularactors.data.model

data class PopularActorsResponse(
    val page: Int,
    val results: List<ActorModel>,
    val total_pages: Int,
    val total_results: Int
)