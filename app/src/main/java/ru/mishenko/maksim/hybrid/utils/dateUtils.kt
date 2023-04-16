package ru.mishenko.maksim.hybrid.utils

import java.text.SimpleDateFormat
import java.util.*

fun getDate(calendar: GregorianCalendar): String =
    SimpleDateFormat("yyyy-MM-dd").format(calendar.time)

fun getCalendar(date: String, time: String): GregorianCalendar {
    val dateComponents = date.split('.').map { it.toInt() }
    val timeComponents = time.split(':').map { it.toInt() }
    return GregorianCalendar(
        dateComponents[0],
        dateComponents[1] - 1,
        dateComponents[2],
        timeComponents[0],
        timeComponents[1]
    )
}