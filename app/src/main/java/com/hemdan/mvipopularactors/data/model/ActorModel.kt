package com.hemdan.mvipopularactors.data.model
data class ActorModel(
    val adult: Boolean,
    val id: Int,
    val name: String,
    val popularity: Double,
    val profile_path: String,
    val biography: String,
    val birthday: String,
    val place_of_birth: String
)