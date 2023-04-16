package ru.mishenko.maksim.hybrid.network.repository.leaderId.impl

import ru.mishenko.maksim.hybrid.network.leaderIdApi.LeaderApi
import ru.mishenko.maksim.hybrid.core.network.entity.Either
import ru.mishenko.maksim.hybrid.domain.model.Event
import ru.mishenko.maksim.hybrid.network.repository.leaderId.LeaderIdEventsInfoRepository
import ru.mishenko.maksim.hybrid.utils.getDate
import java.util.*
import javax.inject.Inject

class LeaderIdEventsInfoRepositoryImpl @Inject constructor(val api: LeaderApi) :
    LeaderIdEventsInfoRepository {
    override suspend fun getEventsInfo(
        finishDate: GregorianCalendar, cityId: Int
    ): Either<String, List<Event>> = when (val events =
        api.searchEvents(100, getDate(GregorianCalendar()), getDate(finishDate), cityId)) {
        is Either.Failure -> Either.Failure(events.error.message)
        is Either.Success -> Either.Success(events.data.data.items.map {
            Event(
                name = it.fullName, start = stringToDateTime(it.dateStart), finish = stringToDateTime(it.dateEnd)
            )
        })
    }
}

fun stringToDateTime(str: String): GregorianCalendar {
    val date = str.substring(0, str.indexOf(" "))
    val time = str.replace(date + " ", "")
    val dateComponents = date.split("-")
    val timeComponents = time.split(":")
    return GregorianCalendar(
        dateComponents[0].toInt(),
        dateComponents[1].toInt() - 1,
        dateComponents[2].toInt(),
        timeComponents[0].toInt(),
        timeComponents[1].toInt()
    )
}