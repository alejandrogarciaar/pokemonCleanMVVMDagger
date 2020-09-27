package com.jgarcia.pokemondaggermvvm.remoteData.di

import com.jgarcia.pokemondaggermvvm.remoteData.api.PokemonAPI
import com.jgarcia.pokemondaggermvvm.remoteData.util.Url
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit

@Module
class NetworkModule {

    companion object {
        private const val DEFAULT_TIMEOUT = 10L
    }

    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
            .callTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
            .build()
    }

    @Provides
    fun provideRetrofitClient(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(Url.BASE_URL)
            .build()
    }

    @Provides
    fun providePokemonApi(retrofit: Retrofit): PokemonAPI {
        return retrofit.create(PokemonAPI::class.java)
    }
}