package com.hemdan.mvipopularactors.di.module

import com.hemdan.mvipopularactors.ui.base.BaseRepository
import com.hemdan.mvipopularactors.ui.popularactorslist.PopularActorsListRepository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

/**
 * Created by Mohammed Hemdan on 2019-10-21.
 * Email : mohammed.hemdan.faraj@gmail.com
 * Github : https://github.com/mhemdan
 */
@Module
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindPopularActorsListRepository(repository: PopularActorsListRepository): BaseRepository

}