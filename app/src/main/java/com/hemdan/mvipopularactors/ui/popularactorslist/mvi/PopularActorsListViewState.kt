package com.hemdan.mvipopularactors.ui.popularactorslist.mvi

import com.hemdan.mvipopularactors.data.model.ActorModel
import com.hemdan.mvipopularactors.ui.base.mvi.MviViewState

/**
 * Created by Mohammed Hemdan on 2019-10-21.
 * Email : mohammed.hemdan.faraj@gmail.com
 * Github : https://github.com/mhemdan
 */
data class PopularActorsListViewState(
    val isLoading: Boolean,
    val actors: List<ActorModel>,
    val error: Throwable?
    ) : MviViewState {

    companion object {
        fun idle(): PopularActorsListViewState {
            return PopularActorsListViewState(
                isLoading = false,
                actors = emptyList(),
                error = null
            )
        }
    }
}