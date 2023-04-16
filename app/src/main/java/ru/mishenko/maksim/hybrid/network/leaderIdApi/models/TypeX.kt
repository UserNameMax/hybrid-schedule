package ru.mishenko.maksim.hybrid.network.leaderIdApi.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TypeX(
    val id: Int,
    val name: String
)