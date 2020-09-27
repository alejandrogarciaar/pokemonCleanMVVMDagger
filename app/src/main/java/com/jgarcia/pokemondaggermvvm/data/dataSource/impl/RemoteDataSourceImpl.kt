package com.jgarcia.pokemondaggermvvm.data.dataSource.impl

import com.jgarcia.pokemondaggermvvm.data.dataSource.RemoteDataSource
import com.jgarcia.pokemondaggermvvm.data.mapper.PokemonDetailMapper
import com.jgarcia.pokemondaggermvvm.data.mapper.PokemonPreviewMapper
import com.jgarcia.pokemondaggermvvm.domain.PokemonDetail
import com.jgarcia.pokemondaggermvvm.domain.PokemonPreview
import com.jgarcia.pokemondaggermvvm.remoteData.api.PokemonAPI
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    private val pokemonAPI: PokemonAPI,
    private val pokemonPreviewMapper: PokemonPreviewMapper,
    private val pokemonDetailMapper: PokemonDetailMapper
) : RemoteDataSource {

    override suspend fun getPokemon(): List<PokemonPreview> {
        val currentPokemon = pokemonAPI.getPokemon()
        return currentPokemon.results.map { pokemonPreviewMapper.invoke(it) }
    }

    override suspend fun getPokemonDetail(pokemonId: Int): PokemonDetail {
        val pokemonDetail = pokemonAPI.getPokemonDetail(pokemonId)
        return pokemonDetailMapper.invoke(pokemonDetail)
    }
}