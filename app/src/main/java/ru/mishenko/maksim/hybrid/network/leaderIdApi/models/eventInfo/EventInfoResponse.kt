package ru.mishenko.maksim.hybrid.network.leaderIdApi.models.eventInfo

import com.squareup.moshi.JsonClass
import ru.mishenko.maksim.hybrid.network.leaderIdApi.models.eventInfo.Data

@JsonClass(generateAdapter = true)
data class EventInfoResponse(
    val data: Data
)