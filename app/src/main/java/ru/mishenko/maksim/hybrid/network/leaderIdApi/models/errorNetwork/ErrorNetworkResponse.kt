package ru.mishenko.maksim.hybrid.network.leaderIdApi.models.errorNetwork

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ErrorNetworkResponse(
    val code: Int?,
    val error: Error?,
    val errors: Errors?,
    val message: String?
)