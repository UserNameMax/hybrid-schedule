package ru.mishenko.maksim.hybrid.network.repository.omgtu.impl

import ru.mishenko.maksim.hybrid.core.network.entity.Either
import ru.mishenko.maksim.hybrid.domain.model.Event
import ru.mishenko.maksim.hybrid.network.omgtuApi.OmgtuApi
import ru.mishenko.maksim.hybrid.network.repository.omgtu.OmgtuRepository
import ru.mishenko.maksim.hybrid.utils.getCalendar
import ru.mishenko.maksim.hybrid.utils.getDate
import java.util.*
import javax.inject.Inject

class OmgtuRepositoryImpl @Inject constructor(private val api: OmgtuApi) : OmgtuRepository {
    override suspend fun getTimetable(
        groupName: String,
        start: GregorianCalendar,
        finish: GregorianCalendar
    ): Either<String, List<Event>> =
        when (val search = api.search(groupName)) {
            is Either.Failure -> Either.Failure(search.error.message)
            is Either.Success -> if (search.data.isEmpty()) Either.Failure("not found group")
            else when (val timetable =
                api.getTimetable(search.data.first().id, getDate(start), getDate(finish))) {
                is Either.Failure -> Either.Failure(timetable.error.message)
                is Either.Success -> Either.Success(timetable.data.map {
                    Event(
                        name = it.discipline,
                        start = getCalendar(it.date, it.beginLesson),
                        finish = getCalendar(it.date, it.endLesson)
                    )
                })
            }
        }
}