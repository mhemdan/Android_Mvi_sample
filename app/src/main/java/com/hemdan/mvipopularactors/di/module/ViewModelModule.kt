package com.hemdan.mvipopularactors.di.module

import androidx.lifecycle.ViewModel
import com.hemdan.mvipopularactors.di.ViewModelKey
import com.hemdan.mvipopularactors.ui.popularactorslist.PopularActorsListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Created by Mohammed Hemdan on 2019-10-21.
 * Email : mohammed.hemdan.faraj@gmail.com
 * Github : https://github.com/mhemdan
 */
@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(PopularActorsListViewModel::class)
    abstract fun bindPopularActorsListViewModel(viewModel: PopularActorsListViewModel): ViewModel

}