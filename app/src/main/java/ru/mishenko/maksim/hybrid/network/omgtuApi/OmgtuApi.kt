package ru.mishenko.maksim.hybrid.network.omgtuApi

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import ru.mishenko.maksim.hybrid.core.network.entity.Either
import ru.mishenko.maksim.hybrid.core.network.entity.ErrorReason
import ru.mishenko.maksim.hybrid.network.omgtuApi.model.search.SearchResponseItem
import ru.mishenko.maksim.hybrid.network.omgtuApi.model.timetable.GetTimetableResponseItem

interface OmgtuApi {
    @GET("search")
    suspend fun search(@Query("term") term: String): Either<ErrorReason,List<SearchResponseItem>>

    @GET("schedule/group/{group}")
    suspend fun getTimetable(@Path("group")groupId:Int, @Query("start") start: String, @Query("finish") finish: String): Either<ErrorReason, List<GetTimetableResponseItem>>
}