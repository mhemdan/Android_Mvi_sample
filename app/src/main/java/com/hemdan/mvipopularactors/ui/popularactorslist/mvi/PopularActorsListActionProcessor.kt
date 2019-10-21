package com.hemdan.mvipopularactors.ui.popularactorslist.mvi

import com.hemdan.mvipopularactors.ui.base.mvi.MviActionProcessor
import com.hemdan.mvipopularactors.ui.popularactorslist.PopularActorsListRepository
import com.hemdan.mvipopularactors.utils.rx.SchedulerProvider
import io.reactivex.Observable
import io.reactivex.ObservableTransformer
import javax.inject.Inject

/**
 * Created by Mohammed Hemdan on 2019-10-21.
 * Email : mohammed.hemdan.faraj@gmail.com
 * Github : https://github.com/mhemdan
 */
class PopularActorsListActionProcessor @Inject constructor(repository: PopularActorsListRepository, schedulerProvider: SchedulerProvider):
    MviActionProcessor<PopularActorsListAction, PopularActorsListResult> {

    private val loadPopularActorsProcessor =
        ObservableTransformer<PopularActorsListAction, PopularActorsListResult> { actions ->
            actions.flatMap { action ->
                repository.getPopularActors()
                    // Transform the Single to an Observable to allow emission of multiple
                    // events down the stream (e.g. the InFlight event)
                    .toObservable()
                    // Wrap returned data into an immutable object
                    .map { actors -> PopularActorsListResult.LoadPopularActorsResult.Success(actors = actors.results) }
                    .cast(PopularActorsListResult.LoadPopularActorsResult::class.java)
                    // Wrap any error into an immutable object and pass it down the stream
                    // without crashing.
                    // Because errors are data and hence, should just be part of the stream.
                    .onErrorReturn(PopularActorsListResult.LoadPopularActorsResult::Failure)
                    .compose(schedulerProvider.ioToMainObservableScheduler())
                    // Emit an InFlight event to notify the subscribers (e.g. the UI) we are
                    // doing work and waiting on a response.
                    // We emit it after observing on the UI thread to allow the event to be emitted
                    // on the current frame and avoid jank.
                    .startWith(PopularActorsListResult.LoadPopularActorsResult.InFlight)
            }
        }

    override var actionProcessor =
        ObservableTransformer<PopularActorsListAction, PopularActorsListResult> { actions ->
            actions.publish { shared ->
                shared.ofType(PopularActorsListAction.LoadPopularActorsAction::class.java).compose(
                    loadPopularActorsProcessor
                )
                    .mergeWith(
                        // Error for not implemented actions
                        shared.filter { v ->
                            v !is PopularActorsListAction.LoadPopularActorsAction
                        }.flatMap { w ->
                            Observable.error<PopularActorsListResult>(
                                IllegalArgumentException("Unknown Action type: $w")
                            )
                        }
                    )

            }
        }
}