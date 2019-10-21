package com.hemdan.mvipopularactors.ui.base.mvi

/**
 * Created by Mohammed Hemdan on 2019-10-21.
 * Email : mohammed.hemdan.faraj@gmail.com
 * Github : https://github.com/mhemdan
 */
interface MviIntent<A: MviAction> {
    fun mapToAction(): A
}