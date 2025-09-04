package com.maciejweglarz.rickandmortyapp.list.data.di

import com.maciejweglarz.rickandmortyapp.list.data.mapper.CharacterInfoMapper
import com.maciejweglarz.rickandmortyapp.list.data.mapper.CharacterInfoMapperImpl
import com.maciejweglarz.rickandmortyapp.list.data.remote.CharacterListApi
import com.maciejweglarz.rickandmortyapp.list.data.repository.CharacterListRepositoryImpl
import com.maciejweglarz.rickandmortyapp.list.domain.repository.CharacterListRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object CharacterListModule {

    @Provides
    @Singleton
    fun provideCharacterListApi(retrofit: Retrofit): CharacterListApi = retrofit.create(CharacterListApi::class.java)

    @Module
    @InstallIn(SingletonComponent::class)
    interface BindsModule {
        @Binds
        @Singleton
        fun bindCharacterListRepository(impl: CharacterListRepositoryImpl): CharacterListRepository

        @Binds
        @Singleton
        fun bindCharacterInfoMapper(impl: CharacterInfoMapperImpl): CharacterInfoMapper

    }


}