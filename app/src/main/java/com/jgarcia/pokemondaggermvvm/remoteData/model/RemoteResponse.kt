package com.jgarcia.pokemondaggermvvm.remoteData.model

data class RemoteResponse(
    val count: Int,
    val next: String,
    val previous: String,
    val results: List<PokemonResponse>
) {
    data class PokemonResponse(
        val name: String,
        val url: String
    )
}