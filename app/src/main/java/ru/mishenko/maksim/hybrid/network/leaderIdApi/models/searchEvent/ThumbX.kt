package ru.mishenko.maksim.hybrid.network.leaderIdApi.models.searchEvent

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ThumbX(
    @Json(name = "360")
    val size360: String,
    @Json(name = "520")
    val size520: String
)