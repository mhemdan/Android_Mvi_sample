package com.hemdan.mvipopularactors.utils.rx

import io.reactivex.ObservableTransformer
import io.reactivex.SingleTransformer
import io.reactivex.CompletableTransformer
import io.reactivex.FlowableTransformer
import io.reactivex.MaybeTransformer
import javax.inject.Inject

/**
 * Created by mohmed on 23/12/18.
 * github: https://github.com/mhemdan
 */

class SchedulerProviderImp @Inject constructor() : SchedulerProvider {
    override fun <T> ioToMainObservableScheduler(): ObservableTransformer<T, T> = ObservableTransformer { upstream ->
        upstream.subscribeOn(getIOThreadScheduler())
            .observeOn(getMainThreadScheduler())
    }

    override fun <T> ioToMainSingleScheduler(): SingleTransformer<T, T> = SingleTransformer { upstream ->
        upstream.subscribeOn(getIOThreadScheduler())
            .observeOn(getMainThreadScheduler())
    }

    override fun ioToMainCompletableScheduler(): CompletableTransformer = CompletableTransformer { upstream ->
        upstream.subscribeOn(getIOThreadScheduler())
            .observeOn(getMainThreadScheduler())
    }

    override fun <T> ioToMainFlowableScheduler(): FlowableTransformer<T, T> = FlowableTransformer { upstream ->
        upstream.subscribeOn(getIOThreadScheduler())
            .observeOn(getMainThreadScheduler())
    }

    override fun <T> ioToMainMaybeScheduler(): MaybeTransformer<T, T> = MaybeTransformer { upstream ->
        upstream.subscribeOn(getIOThreadScheduler())
            .observeOn(getMainThreadScheduler())
    }
}