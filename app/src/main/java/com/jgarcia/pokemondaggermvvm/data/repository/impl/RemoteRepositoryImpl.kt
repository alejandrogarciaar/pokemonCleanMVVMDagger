package com.jgarcia.pokemondaggermvvm.data.repository.impl

import com.jgarcia.pokemondaggermvvm.data.dataSource.RemoteDataSource
import com.jgarcia.pokemondaggermvvm.data.repository.RemoteRepository
import com.jgarcia.pokemondaggermvvm.domain.PokemonDetail
import com.jgarcia.pokemondaggermvvm.domain.PokemonPreview
import com.jgarcia.pokemondaggermvvm.domain.util.ErrorType
import com.jgarcia.pokemondaggermvvm.domain.util.Result
import java.io.IOException
import java.lang.Exception
import java.net.SocketTimeoutException

class RemoteRepositoryImpl(private val remoteDataSource: RemoteDataSource) : RemoteRepository {

    override suspend fun getPokemon(): Result<List<PokemonPreview>> {
        return try {
            val currentPokemon = remoteDataSource.getPokemon()
            Result.Success(currentPokemon)
        } catch (exception: IOException) {
            Result.Error(ErrorType.NetworkError)
        } catch (exception: SocketTimeoutException) {
            Result.Error(ErrorType.SocketTimeoutError)
        } catch (exception: Exception) {
            Result.Error(ErrorType.UnknownError)
        }
    }

    override suspend fun getPokemonDetail(pokemonId: Int): Result<PokemonDetail> {
        return try {
            val currentPokemonDetail = remoteDataSource.getPokemonDetail(pokemonId)
            Result.Success(currentPokemonDetail)
        } catch (exception: IOException) {
            Result.Error(ErrorType.NetworkError)
        } catch (exception: SocketTimeoutException) {
            Result.Error(ErrorType.SocketTimeoutError)
        } catch (exception: Exception) {
            Result.Error(ErrorType.UnknownError)
        }
    }
}