package ru.mishenko.maksim.hybrid.network.repository.leaderId

import ru.mishenko.maksim.hybrid.core.network.entity.Either
import ru.mishenko.maksim.hybrid.domain.model.Event
import java.util.*

interface LeaderIdEventsInfoRepository {
    suspend fun getEventsInfo(finishDate: GregorianCalendar, cityId: Int = 893): Either<String, List<Event>>
}