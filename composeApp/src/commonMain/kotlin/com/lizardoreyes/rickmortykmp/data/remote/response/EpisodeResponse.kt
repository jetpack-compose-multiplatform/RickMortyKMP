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
            SEASON_1 -> "https://www.youtube.com/watch?v=BFTSrbB2wII"
            SEASON_2 -> "https://www.youtube.com/watch?v=_IZfO_LfK5Q"
            SEASON_3 -> "https://www.youtube.com/watch?v=rLyOul8kau0"
            SEASON_4 -> "https://www.youtube.com/watch?v=hl1U0bxTHbY"
            SEASON_5 -> "https://www.youtube.com/watch?v=qbHYYXj2gMc"
            SEASON_6 -> "https://www.youtube.com/watch?v=P9WZhGMlDBE"
            SEASON_7 -> "https://www.youtube.com/watch?v=PkZtVBNkmso"
            else -> "https://www.youtube.com/watch?v=Kvrt8_b6xsY"
        }
    }
}
