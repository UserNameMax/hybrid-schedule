package ru.mishenko.maksim.hybrid.network.leaderIdApi.models.searchEvent

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ParticipantsItem(
    val id: Int,
    val name: String,
    val photo: Any?
)