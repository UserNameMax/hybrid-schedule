package ru.mishenko.maksim.hybrid.domain.model

import java.util.GregorianCalendar

data class Event(
    val name: String,
    val start: GregorianCalendar,
    val finish: GregorianCalendar
)
