package ru.mishenko.maksim.hybrid.utils

import android.util.Log
import ru.mishenko.maksim.hybrid.domain.model.Event
import java.util.*


fun separaateOnDay(events: List<Event>): List<Pair<GregorianCalendar, List<Event>>> {
    var result = mutableListOf<Pair<GregorianCalendar, List<Event>>>()
    val mutableEvents = events.toMutableList()
    while (mutableEvents.isNotEmpty()) {
        val day = mutableEvents.first().start
        val eventsOnDay = mutableEvents.filter { isEqualDay(it.start, day) }
        mutableEvents -= eventsOnDay.toSet()
        result.add(Pair(day, eventsOnDay))
    }
    return result
}

fun isEqualDay(first: GregorianCalendar, second: GregorianCalendar): Boolean =
    isEqualByParam(first, second, Calendar.YEAR) &&
            isEqualByParam(first, second, Calendar.DAY_OF_MONTH) &&
            isEqualByParam(first, second, Calendar.MONTH)

fun isEqualByParam(first: GregorianCalendar, second: GregorianCalendar, param: Int): Boolean =
    first.get(param) == second.get(param)