package com.lizardoreyes.rickmortykmp.ui.home.tabs.episodes

import androidx.paging.PagingData
import com.lizardoreyes.rickmortykmp.domain.model.EpisodeModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

data class EpisodesState(
    val characters: Flow<PagingData<EpisodeModel>> = emptyFlow()
)