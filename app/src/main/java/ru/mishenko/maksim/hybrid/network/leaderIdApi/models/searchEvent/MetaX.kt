package ru.mishenko.maksim.hybrid.network.leaderIdApi.models.searchEvent

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MetaX(
    val currentPage: Int,
    val pageCount: Int,
    val perPage: Int,
    val totalCount: Int
)