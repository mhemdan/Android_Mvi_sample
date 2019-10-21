package com.hemdan.mvipopularactors.ui.popularactorslist

import com.hemdan.mvipopularactors.ui.base.BaseViewModel
import com.hemdan.mvipopularactors.ui.popularactorslist.mvi.*
import com.hemdan.mvipopularactors.utils.notOfType
import io.reactivex.Observable
import io.reactivex.ObservableTransformer
import io.reactivex.functions.BiFunction
import javax.inject.Inject

/**
 * Created by Mohammed Hemdan on 2019-10-21.
 * Email : mohammed.hemdan.faraj@gmail.com
 * Github : https://github.com/mhemdan
 */
class PopularActorsListViewModel @Inject constructor(processor: PopularActorsListActionProcessor) : BaseViewModel<PopularActorsListAction,
        PopularActorsListIntent, PopularActorsListViewState,
        PopularActorsListResult>(processor) {

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
            in PopularActorsListResult, PopularActorsListViewState>?  = reducer

    companion object {
        /**
         * The Reducer is where [MviViewState], that the [MviView] will use to
         * render itself, are created.
         * It takes the last cached [MviViewState], the latest [MviResult] and
         * creates a new [MviViewState] by only updating the related fields.
         * This is basically like a big switch statement of all possible types for the [MviResult]
         */
        private val reducer = BiFunction { previousState: PopularActorsListViewState, result: PopularActorsListResult ->
            when (result) {
                is PopularActorsListResult.LoadPopularActorsResult -> when (result) {
                    is PopularActorsListResult.LoadPopularActorsResult.Success -> {

                        previousState.copy(
                            isLoading = false,
                            actors = result.actors
                        )
                    }
                    is PopularActorsListResult.LoadPopularActorsResult.Failure -> previousState.copy(isLoading = false, error = result.error)
                    is PopularActorsListResult.LoadPopularActorsResult.InFlight -> previousState.copy(isLoading = true)
                }
            }
        }
    }

}