package com.hemdan.mvipopularactors.ui.base.mvi

import io.reactivex.ObservableTransformer

/**
 * Created by Mohammed Hemdan on 2019-10-21.
 * Email : mohammed.hemdan.faraj@gmail.com
 * Github : https://github.com/mhemdan
 */
interface MviActionProcessor<A: MviAction, R: MviResult> {
    var actionProcessor :
            ObservableTransformer<A, R>
}