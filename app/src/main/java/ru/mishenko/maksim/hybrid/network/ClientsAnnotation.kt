package ru.mishenko.maksim.hybrid.network

import javax.inject.Qualifier


//this annotations for retrofit
@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class LeaderIdRetrofitClient

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class OmgtuClient