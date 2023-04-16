package ru.mishenko.maksim.hybrid.di

import ru.mishenko.maksim.hybrid.network.leaderIdApi.LeaderApi
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import ru.mishenko.maksim.hybrid.core.network.EitherAdapterFactory
import ru.mishenko.maksim.hybrid.network.LeaderIdRetrofitClient
import ru.mishenko.maksim.hybrid.network.OmgtuClient
import ru.mishenko.maksim.hybrid.network.omgtuApi.OmgtuApi
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    @Provides
    fun provideMoshi(): Moshi = Moshi.Builder().build()

    @Provides
    fun provideOkHttpClient() =
        OkHttpClient.Builder().addInterceptor(HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }).build()

    @Singleton
    @Provides
    fun provideEitherAdapterFactory(): EitherAdapterFactory = EitherAdapterFactory()

    @Singleton
    @Provides
    @OmgtuClient
    fun provideOmgtuRetrofit(
        moshiConverterFactory: MoshiConverterFactory,
        client: OkHttpClient,
        eitherAdapterFactory: EitherAdapterFactory
    ): Retrofit = Retrofit.Builder().addConverterFactory(moshiConverterFactory)
        .addCallAdapterFactory(eitherAdapterFactory).client(client)
        .baseUrl("https://rasp.omgtu.ru/api/").build()

    @Singleton
    @Provides
    @LeaderIdRetrofitClient
    fun provideLeaderIdRetrofit(
        moshiConverterFactory: MoshiConverterFactory,
        client: OkHttpClient,
        eitherAdapterFactory: EitherAdapterFactory
    ): Retrofit = Retrofit.Builder().addConverterFactory(moshiConverterFactory)
        .addCallAdapterFactory(eitherAdapterFactory).client(client).baseUrl("https://leader-id.ru/")
        .build()


    @Singleton
    @Provides
    fun provideMoshiConverterFactory(moshi: Moshi): MoshiConverterFactory =
        MoshiConverterFactory.create(moshi).asLenient()

    @Singleton
    @Provides
    fun provideOmgtuApi(@OmgtuClient retrofit: Retrofit): OmgtuApi = retrofit.create()

    @Singleton
    @Provides
    fun provideLeaderApi(@LeaderIdRetrofitClient retrofit: Retrofit): LeaderApi = retrofit.create()
}