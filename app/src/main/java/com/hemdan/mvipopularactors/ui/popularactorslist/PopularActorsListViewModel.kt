package com.hemdan.mvipopularactors.ui.popularactorslist

import com.hemdan.mvipopularactors.ui.base.BaseViewModel
import com.hemdan.mvipopularactors.ui.popularactorslist.mvi.*
import com.hemdan.mvipopularactors.utils.notOfType
import io.reactivex.Observable
import io.reactivex.ObservableTransformer
import io.reactivex.functions.BiFunction

/**
 * Created by Mohammed Hemdan on 2019-10-21.
 * Email : mohammed.hemdan.faraj@gmail.com
 * Github : https://github.com/mhemdan
 */
class PopularActorsListViewModel : BaseViewModel<PopularActorsListAction,
        PopularActorsListIntent, PopularActorsListViewState,
        PopularActorsListResult, PopularActorsListActionProcessor>() {

    override fun getIntentFilters() =
        ObservableTransformer<PopularActorsListIntent, PopularActorsListIntent> { intents ->
            intents.publish { shared ->
                Observable.merge(
                    shared.ofType(PopularActorsListIntent.InitialIntent::class.java).take(1),
                    shared.notOfType(PopularActorsListIntent.InitialIntent::class.java)
                )
            }
        }

    override fun getIdleState() = PopularActorsListViewState.idle()

    override fun getReducer(): BiFunction<PopularActorsListViewState,
            in PopularActorsListResult, PopularActorsListViewState>? {
    }

}