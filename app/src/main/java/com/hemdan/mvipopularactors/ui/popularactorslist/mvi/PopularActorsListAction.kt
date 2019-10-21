package com.hemdan.mvipopularactors.ui.popularactorslist.mvi

import com.hemdan.mvipopularactors.ui.base.mvi.MviAction

/**
 * Created by Mohammed Hemdan on 2019-10-21.
 * Email : mohammed.hemdan.faraj@gmail.com
 * Github : https://github.com/mhemdan
 */
sealed class PopularActorsListAction : MviAction {

    data class LoadPopularActorsAction(
        val forceUpdate: Boolean
    ) : PopularActorsListAction()
}