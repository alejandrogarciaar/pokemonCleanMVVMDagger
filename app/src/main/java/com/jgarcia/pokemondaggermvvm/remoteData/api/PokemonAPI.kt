package com.jgarcia.pokemondaggermvvm.remoteData.api

import com.jgarcia.pokemondaggermvvm.remoteData.model.PokemonDetailResponse
import com.jgarcia.pokemondaggermvvm.remoteData.model.RemoteResponse
import com.jgarcia.pokemondaggermvvm.remoteData.util.Url
import retrofit2.http.GET
import retrofit2.http.Query

interface PokemonAPI {

    @GET(Url.SEARCH_POKEMON_PATH)
    suspend fun getPokemon(): RemoteResponse

    @GET(Url.SEARCH_POKEMON_PATH + "/{pokemonId}")
    suspend fun getPokemonDetail(@Query("pokemonId") pokemonId: Int): PokemonDetailResponse

}