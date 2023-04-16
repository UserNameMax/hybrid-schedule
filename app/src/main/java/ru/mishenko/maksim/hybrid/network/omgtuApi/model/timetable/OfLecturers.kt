package ru.mishenko.maksim.hybrid.network.omgtuApi.model.timetable

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class OfLecturers(
    val lecturer: String,
    val lecturerCustomUID: Any?,
    val lecturerEmail: String,
    val lecturerOid: Int,
    val lecturerUID: Any?,
    val lecturer_rank: String,
    val lecturer_title: String
)