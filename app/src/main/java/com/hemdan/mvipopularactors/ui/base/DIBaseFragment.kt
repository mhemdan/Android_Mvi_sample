package com.hemdan.mvipopularactors.ui.base

import android.os.Bundle
import android.view.View
import com.hemdan.mvipopularactors.di.Injectable
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by Mohammed Hemdan on 2019-10-21.
 * Email : mohammed.hemdan.faraj@gmail.com
 * Github : https://github.com/mhemdan
 */
abstract class DIBaseFragment: BaseFragment(), Injectable {

    internal val disposables = CompositeDisposable()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bind()
    }

    abstract fun bind()


    override fun onDestroy() {
        super.onDestroy()
        disposables.dispose()
    }
}