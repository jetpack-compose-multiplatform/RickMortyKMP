package com.lizardoreyes.rickmortykmp.data.remote.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.lizardoreyes.rickmortykmp.data.remote.ApiService
import com.lizardoreyes.rickmortykmp.domain.model.EpisodeModel

class EpisodesPagingSource(
    private val apiService: ApiService
) : PagingSource<Int, EpisodeModel>() {

    override fun getRefreshKey(state: PagingState<Int, EpisodeModel>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, EpisodeModel> {
        return try {
            val page = params.key ?: 1
            val response = apiService.getAllEpisodes(page)
            val episodes = response.results

            val prev = if (page > 0) -1 else null
            val next = if (response.info.next != null) page + 1 else null

            LoadResult.Page(
                data = episodes.map { episodesResponse -> episodesResponse.toDomain() },
                prevKey = prev,
                nextKey = next
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}