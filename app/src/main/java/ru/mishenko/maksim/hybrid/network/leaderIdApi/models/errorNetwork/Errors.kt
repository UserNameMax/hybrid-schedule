package ru.mishenko.maksim.hybrid.network.leaderIdApi.models.errorNetwork

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Errors(
    val paginationSize: List<String>
)