package ru.mishenko.maksim.hybrid.network.leaderIdApi.models.searchEvent

import com.squareup.moshi.JsonClass
import ru.mishenko.maksim.hybrid.network.leaderIdApi.models.searchEvent.ParticipantsX

@JsonClass(generateAdapter = true)
data class StatXX(
    val participants: ParticipantsX
)