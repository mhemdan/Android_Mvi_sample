package com.hemdan.mvipopularactors.di.builder

import com.hemdan.mvipopularactors.ui.popularactorslist.PopularActorsFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Mohammed Hemdan on 2019-10-21.
 * Email : mohammed.hemdan.faraj@gmail.com
 * Github : https://github.com/mhemdan
 */
@Module
abstract class PopularActorsFragmentBuilder {

    @ContributesAndroidInjector
    abstract fun contributePopularActorsFragment(): PopularActorsFragment
}