package ru.mishenko.maksim.hybrid.network.leaderIdApi.models

import ru.mishenko.maksim.hybrid.network.leaderIdApi.models.searchEvent.PhotoX
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class HallX(
    val capacity: Int?,
    val id: Int?,
    val name: String?,
    val photos: List<PhotoX>,
    val preparePeriod: Int?,
    val square: String?,
    val tags: List<String>?,
    val type: String?
)