package ru.mishenko.maksim.hybrid.network.leaderIdApi.models.searchEvent

import com.squareup.moshi.JsonClass
import ru.mishenko.maksim.hybrid.network.leaderIdApi.models.searchEvent.ParticipantsItem

@JsonClass(generateAdapter = true)
data class ParticipantsX(
    val count: Int,
    val list: List<ParticipantsItem>
)