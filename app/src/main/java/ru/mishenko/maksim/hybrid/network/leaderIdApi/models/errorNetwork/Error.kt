package ru.mishenko.maksim.hybrid.network.leaderIdApi.models.errorNetwork

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Error(
    val code: Int,
    val message: String,
    val name: String,
    val status: Int
)