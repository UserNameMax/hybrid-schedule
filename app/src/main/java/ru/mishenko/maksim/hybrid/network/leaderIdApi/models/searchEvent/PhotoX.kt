package ru.mishenko.maksim.hybrid.network.leaderIdApi.models.searchEvent

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PhotoX(
    val full: String,
    val thumb: ThumbX
)