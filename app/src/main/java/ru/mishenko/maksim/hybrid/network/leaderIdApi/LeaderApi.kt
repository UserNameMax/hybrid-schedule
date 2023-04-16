package ru.mishenko.maksim.hybrid.network.leaderIdApi

import ru.mishenko.maksim.hybrid.network.leaderIdApi.models.eventInfo.EventInfoResponse
import ru.mishenko.maksim.hybrid.network.leaderIdApi.models.searchEvent.SearchEventsResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import ru.mishenko.maksim.hybrid.core.network.entity.Either
import ru.mishenko.maksim.hybrid.core.network.entity.ErrorReason

interface LeaderApi {
    @GET("api/v4/events/search")
    suspend fun searchEvents(
        @Query("paginationSize") count: Int,
        @Query("dateFrom") dateFrom: String,
        @Query("dateTo") dateTo: String,
        @Query("cityId") cityId: Int
    ): Either<ErrorReason, SearchEventsResponse>

    @GET("api/v4/events/{eventId}")
    suspend fun eventInfo(@Path("eventId") eventId: Int): Either<ErrorReason, EventInfoResponse>
}