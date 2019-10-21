package com.hemdan.mvipopularactors.di.module

import com.hemdan.mvipopularactors.utils.rx.SchedulerProvider
import com.hemdan.mvipopularactors.utils.rx.SchedulerProviderImp
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Mohammed Hemdan on 2019-10-21.
 * Email : mohammed.hemdan.faraj@gmail.com
 * Github : https://github.com/mhemdan
 */
@Module(includes = [ViewModelModule::class, RepositoryModule::class, NetworkModule::class])
class AppModule {

    @Provides
    @Singleton
    fun provideSchedulerProvider(schedulerProviderImp: SchedulerProviderImp): SchedulerProvider =
        schedulerProviderImp
}