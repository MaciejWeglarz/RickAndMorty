package com.maciejweglarz.rickandmortyapp.details.data.di

import com.maciejweglarz.rickandmortyapp.details.data.mapper.CharacterDetailsInfoMapper
import com.maciejweglarz.rickandmortyapp.details.data.mapper.CharacterDetailsInfoMapperImpl
import com.maciejweglarz.rickandmortyapp.details.data.remote.CharacterDetailsApi
import com.maciejweglarz.rickandmortyapp.details.data.repository.CharacterDetailsRepositoryImpl
import com.maciejweglarz.rickandmortyapp.details.domain.repository.CharacterDetailsRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
internal object CharacterDetailsModule {

    @Provides
    @Singleton
    fun provideCharacterDetailsApi(retrofit: Retrofit): CharacterDetailsApi = retrofit.create(CharacterDetailsApi::class.java)

    @Module
    @InstallIn(SingletonComponent::class)
    interface BindsModule {
        @Binds
        @Singleton
        fun bindCharacterDetailsRepository(impl: CharacterDetailsRepositoryImpl): CharacterDetailsRepository

        @Binds
        @Singleton
        fun bindCharacterDetailsMapper(impl: CharacterDetailsInfoMapperImpl): CharacterDetailsInfoMapper

    }
}