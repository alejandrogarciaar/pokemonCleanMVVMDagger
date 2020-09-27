package com.jgarcia.pokemondaggermvvm.data.dataSource

import com.jgarcia.pokemondaggermvvm.domain.PokemonDetail
import com.jgarcia.pokemondaggermvvm.domain.PokemonPreview

interface RemoteDataSource {
    suspend fun getPokemon(): List<PokemonPreview>
    suspend fun getPokemonDetail(pokemonId: Int): PokemonDetail
}