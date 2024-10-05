package com.lizardoreyes.rickmortykmp.ui.home.tabs.episodes

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import app.cash.paging.compose.collectAsLazyPagingItems
import com.lizardoreyes.rickmortykmp.domain.model.EpisodeModel
import com.lizardoreyes.rickmortykmp.domain.model.SeasonEpisode
import com.lizardoreyes.rickmortykmp.ui.core.components.PagingLoadingState
import com.lizardoreyes.rickmortykmp.ui.core.components.PagingType
import com.lizardoreyes.rickmortykmp.ui.core.components.PagingWrapper
import com.lizardoreyes.rickmortykmp.ui.core.components.VideoPlayer
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI
import rickmortykmp.composeapp.generated.resources.Res
import rickmortykmp.composeapp.generated.resources.portal
import rickmortykmp.composeapp.generated.resources.season1
import rickmortykmp.composeapp.generated.resources.season2
import rickmortykmp.composeapp.generated.resources.season3
import rickmortykmp.composeapp.generated.resources.season4
import rickmortykmp.composeapp.generated.resources.season5
import rickmortykmp.composeapp.generated.resources.season6
import rickmortykmp.composeapp.generated.resources.season7

@OptIn(KoinExperimentalAPI::class)
@Composable
fun EpisodesScreen() {
    val episodesViewModel = koinViewModel<EpisodesViewModel>()
    val state by episodesViewModel.state.collectAsState()
    val episodes = state.characters.collectAsLazyPagingItems()

    Column(Modifier.fillMaxSize()) {
        PagingWrapper(
            pagingType = PagingType.ROW,
            pagingItems = episodes,
            initialView = { PagingLoadingState() },
            itemView = { it -> EpisodeItemList(it) { episodesViewModel.onPlaySelected(it) } }
        )

        EpisodePlayer(state.playVideo){ episodesViewModel.onCloseVideo() }
    }
}

@Composable
fun EpisodePlayer(playVideo: String, onCloseVideo: () -> Unit = {}) {
    AnimatedVisibility (playVideo.isNotBlank()) {
        ElevatedCard(
            modifier = Modifier.fillMaxWidth().height(250.dp).padding(16.dp)
                .border(3.dp, Color.Green, CardDefaults.elevatedShape)
        ) {
            Box(
                modifier = Modifier.background(Color.Black).padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                Box(modifier = Modifier.padding(16.dp), contentAlignment = Alignment.Center) {
                    VideoPlayer(
                        modifier = Modifier.fillMaxWidth().height(200.dp),
                        url = playVideo
                    )
                }
                Row {
                    Spacer(modifier = Modifier.weight(1f))
                    Image(
                        painter = painterResource(Res.drawable.portal),
                        contentDescription = "",
                        modifier = Modifier.padding(8.dp).size(40.dp).clickable { onCloseVideo() }
                    )
                }
            }
        }
    }
}

@Composable
fun EpisodeItemList(episode: EpisodeModel, onEpisodeSelected: (String) -> Unit) {
    Column(
        modifier = Modifier.width(120.dp).padding(horizontal = 8.dp)
            .clickable { onEpisodeSelected(episode.videoURL) }) {
        Image(
            painter = painterResource(resource = getSeasonImage(episode.season)),
            contentDescription = null,
            modifier = Modifier.height(200.dp).fillMaxWidth(),
            contentScale = ContentScale.Inside
        )
    }
}

fun getSeasonImage(seasonEpisode: SeasonEpisode): DrawableResource {
    return when (seasonEpisode) {
        SeasonEpisode.SEASON_1 -> Res.drawable.season1
        SeasonEpisode.SEASON_2 -> Res.drawable.season2
        SeasonEpisode.SEASON_3 -> Res.drawable.season3
        SeasonEpisode.SEASON_4 -> Res.drawable.season4
        SeasonEpisode.SEASON_5 -> Res.drawable.season5
        SeasonEpisode.SEASON_6 -> Res.drawable.season6
        SeasonEpisode.SEASON_7 -> Res.drawable.season7
        SeasonEpisode.UNKNOWN -> Res.drawable.season7
    }
}