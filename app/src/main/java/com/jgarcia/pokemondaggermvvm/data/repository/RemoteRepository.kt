package com.jgarcia.pokemondaggermvvm.data.repository

import com.jgarcia.pokemondaggermvvm.domain.PokemonDetail
import com.jgarcia.pokemondaggermvvm.domain.PokemonPreview
import com.jgarcia.pokemondaggermvvm.domain.util.Result

interface RemoteRepository {
    suspend fun getPokemon(): Result<List<PokemonPreview>>
    suspend fun getPokemonDetail(pokemonId: Int): Result<PokemonDetail>
}