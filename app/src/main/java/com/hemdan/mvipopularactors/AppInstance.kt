package com.hemdan.mvipopularactors

import android.app.Activity
import android.app.Application
import com.hemdan.mvipopularactors.di.AppInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

/**
 * Created by Mohammed Hemdan on 2019-10-21.
 * Email : mohammed.hemdan.faraj@gmail.com
 * Github : https://github.com/mhemdan
 */
class AppInstance: Application(), HasActivityInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun activityInjector() = dispatchingAndroidInjector

    override fun onCreate() {
        super.onCreate()

        initDI()
    }

    private fun initDI() {
        AppInjector.init(this)
    }
}