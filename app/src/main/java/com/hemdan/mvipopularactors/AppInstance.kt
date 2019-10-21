package com.hemdan.mvipopularactors

import android.app.Application

/**
 * Created by Mohammed Hemdan on 2019-10-21.
 * Email : mohammed.hemdan.faraj@gmail.com
 * Github : https://github.com/mhemdan
 */
class AppInstance: Application() {

    override fun onCreate() {
        super.onCreate()

        initDI()
    }

    private fun initDI() {

    }
}