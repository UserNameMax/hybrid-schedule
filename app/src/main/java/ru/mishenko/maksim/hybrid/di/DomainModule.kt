package ru.mishenko.maksim.hybrid.di

import ru.mishenko.maksim.hybrid.network.repository.leaderId.impl.LeaderIdEventsInfoRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import ru.mishenko.maksim.hybrid.network.repository.leaderId.LeaderIdEventsInfoRepository
import ru.mishenko.maksim.hybrid.network.repository.omgtu.OmgtuRepository
import ru.mishenko.maksim.hybrid.network.repository.omgtu.impl.OmgtuRepositoryImpl


@Module
@InstallIn(ViewModelComponent::class)
interface Binds {

    @Binds
    fun provideOmgtuRepository(impl: OmgtuRepositoryImpl): OmgtuRepository

    @Binds
    fun provideLeaderRepository(impl: LeaderIdEventsInfoRepositoryImpl): LeaderIdEventsInfoRepository
}