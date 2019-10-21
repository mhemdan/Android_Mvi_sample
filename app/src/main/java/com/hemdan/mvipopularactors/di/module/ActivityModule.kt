package com.hemdan.mvipopularactors.di.module

import com.hemdan.mvipopularactors.PopularActorsListActivity
import com.hemdan.mvipopularactors.di.builder.PopularActorsFragmentBuilder
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Mohammed Hemdan on 2019-10-21.
 * Email : mohammed.hemdan.faraj@gmail.com
 * Github : https://github.com/mhemdan
 */
@Module
abstract class ActivityModule {

    @ContributesAndroidInjector(modules = [PopularActorsFragmentBuilder::class])
    abstract fun contributePopularActorsListActivity(): PopularActorsListActivity

}