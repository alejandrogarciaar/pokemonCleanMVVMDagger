package com.jgarcia.pokemondaggermvvm.remoteData.model

import com.google.gson.annotations.SerializedName

data class PokemonDetailResponse(
    val id: Int,
    val name: String,
    val abilityResponses: List<AbilityResponse>,
    @SerializedName("base_experience")
    val baseExperience: Int,
    val height: Int,
    val weight: Int,
    val moves: List<MoveResponse>
) {
    data class AbilityResponse(
        val name: String,
        val url: String,
        @SerializedName("is_hidden")
        val isHidden: Boolean,
        val slot: Int
    )

    data class MoveResponse(
        val name: String,
        val url: String
    )
}