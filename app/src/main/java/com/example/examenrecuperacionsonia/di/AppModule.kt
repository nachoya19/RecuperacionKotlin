package com.example.examenrecuperacionsonia.di

import com.example.examenrecuperacionsonia.data.repositorio.PostRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providePostRepository(): PostRepository{
        return PostRepository()
    }
}