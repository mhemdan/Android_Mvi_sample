package com.hemdan.mvipopularactors.ui.popularactorslist.mvi

import com.hemdan.mvipopularactors.ui.base.mvi.MviActionProcessor
import io.reactivex.Observable
import io.reactivex.ObservableTransformer

/**
 * Created by Mohammed Hemdan on 2019-10-21.
 * Email : mohammed.hemdan.faraj@gmail.com
 * Github : https://github.com/mhemdan
 */
class PopularActorsListActionProcessor :
    MviActionProcessor<PopularActorsListAction, PopularActorsListResult> {

    lateinit var loadTasksProcessor:
            ObservableTransformer<PopularActorsListAction, PopularActorsListResult>

//    private val loadTasksProcessor =
//        ObservableTransformer<PopularActorsListAction, PopularActorsListResult> { actions ->
//            actions.flatMap { action ->
//                tasksRepository.getTasks(action.forceUpdate)
//                    // Transform the Single to an Observable to allow emission of multiple
//                    // events down the stream (e.g. the InFlight event)
//                    .toObservable()
//                    // Wrap returned data into an immutable object
//                    .map { tasks -> LoadTasksResult.Success(tasks, action.filterType) }
//                    .cast(LoadTasksResult::class.java)
//                    // Wrap any error into an immutable object and pass it down the stream
//                    // without crashing.
//                    // Because errors are data and hence, should just be part of the stream.
//                    .onErrorReturn(LoadTasksResult::Failure)
//                    .subscribeOn(schedulerProvider.io())
//                    .observeOn(schedulerProvider.ui())
//                    // Emit an InFlight event to notify the subscribers (e.g. the UI) we are
//                    // doing work and waiting on a response.
//                    // We emit it after observing on the UI thread to allow the event to be emitted
//                    // on the current frame and avoid jank.
//                    .startWith(LoadTasksResult.InFlight)
//            }
//        }

    override var actionProcessor =
        ObservableTransformer<PopularActorsListAction, PopularActorsListResult> { actions ->
            actions.publish { shared ->
                shared.ofType(PopularActorsListAction.LoadPopularActorsAction::class.java).compose(
                    loadTasksProcessor
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