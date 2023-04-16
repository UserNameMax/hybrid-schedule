package ru.mishenko.maksim.hybrid.network.repository.omgtu

import ru.mishenko.maksim.hybrid.core.network.entity.Either
import ru.mishenko.maksim.hybrid.domain.model.Event
import java.util.*

interface OmgtuRepository {
    suspend fun getTimetable(groupName: String, start: GregorianCalendar, finish: GregorianCalendar): Either<String, List<Event>>
}