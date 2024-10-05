package com.lizardoreyes.rickmortykmp.data.remote.response

import com.lizardoreyes.rickmortykmp.domain.model.EpisodeModel
import com.lizardoreyes.rickmortykmp.domain.model.SeasonEpisode
import com.lizardoreyes.rickmortykmp.domain.model.SeasonEpisode.*
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class EpisodeResponse(
    @SerialName("id")
    val id: Int,
    @SerialName("name")
    val name: String,
    @SerialName("episode")
    val episode: String,
    @SerialName("characters")
    val characters: List<String>,
) {
    fun toDomain(): EpisodeModel {
        val season = getSeasonFromEpisodeCode(episode)
        
        return EpisodeModel(
            id = id,
            name = name,
            episode = episode,
            characters = characters.map { url -> url.substringAfter("/") },
            season = season,
            videoURL = getVideoUrlFromSeason(season)
        )
    }

    private fun getSeasonFromEpisodeCode(episode: String): SeasonEpisode {
        return when {
            episode.startsWith("S01") -> SEASON_1
            episode.startsWith("S02") -> SEASON_2
            episode.startsWith("S03") -> SEASON_3
            episode.startsWith("S04") -> SEASON_4
            episode.startsWith("S05") -> SEASON_5
            episode.startsWith("S06") -> SEASON_6
            episode.startsWith("S07") -> SEASON_7
            else -> UNKNOWN
        }
    }

    private fun getVideoUrlFromSeason(season: SeasonEpisode): String {
        return when (season) {
            SEASON_1 -> "https://firebasestorage.googleapis.com/v0/b/fir-example-80d7b.appspot.com/o/Rick%20and%20Morty_%20The%20Anime%20_%20Tr%C3%A1iler%20Oficial%20_%20Max.mp4?alt=media&token=96c756c4-2805-43aa-9aa4-1149f7de3f6d"
            SEASON_2 -> "https://firebasestorage.googleapis.com/v0/b/fir-example-80d7b.appspot.com/o/Rick%20and%20Morty_%20The%20Anime%20_%20Tr%C3%A1iler%20Oficial%20_%20Max.mp4?alt=media&token=96c756c4-2805-43aa-9aa4-1149f7de3f6d"
            SEASON_3 -> "https://firebasestorage.googleapis.com/v0/b/fir-example-80d7b.appspot.com/o/Rick%20and%20Morty_%20The%20Anime%20_%20Tr%C3%A1iler%20Oficial%20_%20Max.mp4?alt=media&token=96c756c4-2805-43aa-9aa4-1149f7de3f6d"
            SEASON_4 -> "https://firebasestorage.googleapis.com/v0/b/fir-example-80d7b.appspot.com/o/Rick%20and%20Morty_%20The%20Anime%20_%20Tr%C3%A1iler%20Oficial%20_%20Max.mp4?alt=media&token=96c756c4-2805-43aa-9aa4-1149f7de3f6d"
            SEASON_5 -> "https://firebasestorage.googleapis.com/v0/b/fir-example-80d7b.appspot.com/o/Rick%20and%20Morty_%20The%20Anime%20_%20Tr%C3%A1iler%20Oficial%20_%20Max.mp4?alt=media&token=96c756c4-2805-43aa-9aa4-1149f7de3f6d"
            SEASON_6 -> "https://firebasestorage.googleapis.com/v0/b/fir-example-80d7b.appspot.com/o/Rick%20and%20Morty_%20The%20Anime%20_%20Tr%C3%A1iler%20Oficial%20_%20Max.mp4?alt=media&token=96c756c4-2805-43aa-9aa4-1149f7de3f6d"
            SEASON_7 -> "https://firebasestorage.googleapis.com/v0/b/fir-example-80d7b.appspot.com/o/Rick%20and%20Morty_%20The%20Anime%20_%20Tr%C3%A1iler%20Oficial%20_%20Max.mp4?alt=media&token=96c756c4-2805-43aa-9aa4-1149f7de3f6d"
            else -> "https://firebasestorage.googleapis.com/v0/b/fir-example-80d7b.appspot.com/o/Rick%20and%20Morty_%20The%20Anime%20_%20Tr%C3%A1iler%20Oficial%20_%20Max.mp4?alt=media&token=96c756c4-2805-43aa-9aa4-1149f7de3f6d"
        }
    }
}
