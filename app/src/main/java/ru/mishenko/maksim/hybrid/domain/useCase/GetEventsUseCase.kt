package ru.mishenko.maksim.hybrid.domain.useCase

import ru.mishenko.maksim.hybrid.core.network.entity.Either
import ru.mishenko.maksim.hybrid.domain.model.Event
import ru.mishenko.maksim.hybrid.network.repository.leaderId.LeaderIdEventsInfoRepository
import ru.mishenko.maksim.hybrid.network.repository.omgtu.OmgtuRepository
import java.util.*
import javax.inject.Inject

class GetEventsUseCase @Inject constructor(
    private val omgtuRepository: OmgtuRepository,
    private val leaderIdEventsInfoRepository: LeaderIdEventsInfoRepository
) {
    suspend operator fun invoke(): Either<String, List<Event>> {
        val finishDate = GregorianCalendar()
        finishDate.set(Calendar.DAY_OF_MONTH, finishDate.get(Calendar.DAY_OF_MONTH) + 7)
        val events = mutableListOf<Event>()
        val omgtuEvents = omgtuRepository.getTimetable("ИВТ-213", GregorianCalendar(), finishDate)
        val leaderEvents = leaderIdEventsInfoRepository.getEventsInfo(finishDate)
        when (omgtuEvents) {
            is Either.Failure -> return Either.Failure(omgtuEvents.error)
            is Either.Success -> events += omgtuEvents.data
        }
        when (leaderEvents) {
            is Either.Failure -> return Either.Failure(leaderEvents.error)
            is Either.Success -> events += leaderEvents.data
        }
        events.sortBy { it.start }
        return Either.Success(events.filter { it.start > GregorianCalendar() })
    }
}