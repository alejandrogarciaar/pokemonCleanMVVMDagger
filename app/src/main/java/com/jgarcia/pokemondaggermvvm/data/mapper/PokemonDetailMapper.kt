package com.jgarcia.pokemondaggermvvm.data.mapper

import com.jgarcia.pokemondaggermvvm.domain.PokemonDetail
import com.jgarcia.pokemondaggermvvm.remoteData.model.PokemonDetailResponse
import javax.inject.Inject

class PokemonDetailMapper @Inject constructor() {
    operator fun invoke(pokemonDetailResponse: PokemonDetailResponse): PokemonDetail {
        return with(pokemonDetailResponse) {
            PokemonDetail(name = this.name)
        }
    }
}