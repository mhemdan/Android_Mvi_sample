package com.hemdan.mvipopularactors.ui.popularactorslist.mvi

import com.hemdan.mvipopularactors.ui.base.mvi.MviIntent

/**
 * Created by Mohammed Hemdan on 2019-10-21.
 * Email : mohammed.hemdan.faraj@gmail.com
 * Github : https://github.com/mhemdan
 */
sealed class PopularActorsListIntent : MviIntent<PopularActorsListAction> {

    object InitialIntent : PopularActorsListIntent()

    data class RefreshIntent(val forceUpdate: Boolean) : PopularActorsListIntent()

    override fun mapToAction(): PopularActorsListAction = when (this) {
        is InitialIntent -> PopularActorsListAction.LoadPopularActorsAction(true)
        is RefreshIntent -> PopularActorsListAction.LoadPopularActorsAction(this.forceUpdate)
    }
}
