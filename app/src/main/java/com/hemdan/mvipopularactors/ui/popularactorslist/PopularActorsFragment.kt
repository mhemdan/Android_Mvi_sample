package com.hemdan.mvipopularactors.ui.popularactorslist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hemdan.mvipopularactors.R
import com.hemdan.mvipopularactors.ui.base.DIBaseFragment
import com.hemdan.mvipopularactors.ui.base.mvi.MviView
import com.hemdan.mvipopularactors.ui.popularactorslist.mvi.PopularActorsListAction
import com.hemdan.mvipopularactors.ui.popularactorslist.mvi.PopularActorsListIntent
import com.hemdan.mvipopularactors.ui.popularactorslist.mvi.PopularActorsListViewState
import com.jakewharton.rxbinding2.support.v4.widget.RxSwipeRefreshLayout
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import kotlinx.android.synthetic.main.popular_actors_list_fragment.*
import javax.inject.Inject

/**
 * Created by Mohammed Hemdan on 2019-10-21.
 * Email : mohammed.hemdan.faraj@gmail.com
 * Github : https://github.com/mhemdan
 */
class PopularActorsFragment: DIBaseFragment(), MviView<PopularActorsListAction, PopularActorsListIntent, PopularActorsListViewState> {

    @Inject
    lateinit var viewModel: PopularActorsListViewModel

    private val refreshIntentPublisher = PublishSubject.create<PopularActorsListIntent.RefreshIntent>()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?  =
        inflater.inflate(R.layout.popular_actors_list_fragment, container, false)


    override fun bind() {

        // Subscribe to the ViewModel and call render for every emitted state
        disposables.add(viewModel.states().subscribe(this::render))
        // Pass the UI's intents to the ViewModel
        viewModel.processIntents(intents())

    }

    override fun intents(): Observable<PopularActorsListIntent> {
        return Observable.merge(
            initialIntent(),
            refreshIntent())
    }


    override fun render(state: PopularActorsListViewState) {
        actorsSwipeLayout.isRefreshing = state.isLoading
        if (state.error != null) {
//            showLoadingTasksError()
            return
        }


        if (state.actors.isEmpty()) {

        } else {

        }
    }


    override fun onResume() {
        super.onResume()

        //for first load data call and on each resume after that to recall get data
        refreshIntentPublisher.onNext(PopularActorsListIntent.RefreshIntent(false))
    }

    /**
     * The initial Intent the [MviView] emit to convey to the [MviViewModel]
     * that it is ready to receive data.
     * This initial Intent is also used to pass any parameters the [MviViewModel] might need
     * to render the initial [MviViewState] (e.g. the task id to load).
     */
    private fun initialIntent(): Observable<PopularActorsListIntent.InitialIntent> {
        return Observable.just(PopularActorsListIntent.InitialIntent)
    }

    private fun refreshIntent(): Observable<PopularActorsListIntent.RefreshIntent> {
        return RxSwipeRefreshLayout.refreshes(actorsSwipeLayout)
            .map { PopularActorsListIntent.RefreshIntent(false) }
            .mergeWith(refreshIntentPublisher)
    }

    companion object {
        fun newInstance() = PopularActorsFragment()
    }
}