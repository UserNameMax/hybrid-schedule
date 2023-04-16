package ru.mishenko.maksim.hybrid.network.leaderIdApi.models.searchEvent

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class DataX(
    @Json(name = "_items")
    val items: List<Item>,
    @Json(name = "_meta")
    val meta: MetaX?
)