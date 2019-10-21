package com.hemdan.mvipopularactors.ui.popularactorslist.mvi

import com.hemdan.mvipopularactors.data.model.ActorModel
import com.hemdan.mvipopularactors.ui.base.mvi.MviResult

/**
 * Created by Mohammed Hemdan on 2019-10-21.
 * Email : mohammed.hemdan.faraj@gmail.com
 * Github : https://github.com/mhemdan
 */
sealed class PopularActorsListResult : MviResult {
    sealed class LoadPopularActorsResult : PopularActorsListResult() {
        data class Success(val popularActors: List<ActorModel>) : LoadPopularActorsResult()
        data class Failure(val error: Throwable) : LoadPopularActorsResult()
        object InFlight : LoadPopularActorsResult()
    }
}