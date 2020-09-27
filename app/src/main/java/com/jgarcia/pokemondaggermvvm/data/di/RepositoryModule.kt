package com.jgarcia.pokemondaggermvvm.data.di

import com.jgarcia.pokemondaggermvvm.data.dataSource.RemoteDataSource
import com.jgarcia.pokemondaggermvvm.data.dataSource.impl.RemoteDataSourceImpl
import com.jgarcia.pokemondaggermvvm.data.repository.RemoteRepository
import com.jgarcia.pokemondaggermvvm.data.repository.impl.RemoteRepositoryImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindRemoteRepository(remoteRepositoryImpl: RemoteRepositoryImpl): RemoteRepository

    @Binds
    @Singleton
    abstract fun bindRemoteDataSource(remoteDataSourceImpl: RemoteDataSourceImpl): RemoteDataSource

}