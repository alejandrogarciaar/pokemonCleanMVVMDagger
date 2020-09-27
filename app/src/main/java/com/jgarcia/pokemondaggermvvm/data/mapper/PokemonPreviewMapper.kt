package com.jgarcia.pokemondaggermvvm.data.mapper

import com.jgarcia.pokemondaggermvvm.domain.PokemonPreview
import com.jgarcia.pokemondaggermvvm.remoteData.model.RemoteResponse
import javax.inject.Inject

class PokemonPreviewMapper @Inject constructor() {
    operator fun invoke(pokemonResponse: RemoteResponse.PokemonResponse): PokemonPreview {
        return with(pokemonResponse) {
            PokemonPreview(name = this.name)
        }
    }
}