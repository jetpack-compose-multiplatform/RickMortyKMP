package com.lizardoreyes.rickmortykmp.data.remote.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class EpisodesWrapperResponse(
    @SerialName("info")
    val info: InfoResponse,
    @SerialName("results")
    val results : List<EpisodeResponse>
)
