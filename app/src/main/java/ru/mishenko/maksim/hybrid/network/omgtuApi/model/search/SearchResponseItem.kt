package ru.mishenko.maksim.hybrid.network.omgtuApi.model.search

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SearchResponseItem(
    val description: String,
    val id: Int,
    val label: String,
    val type: String
)