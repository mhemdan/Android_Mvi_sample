package com.hemdan.mvipopularactors.ui.popularactorslist

import com.hemdan.mvipopularactors.data.remote.api.PopularActorsListApi
import com.hemdan.mvipopularactors.ui.base.BaseRepository
import javax.inject.Inject

/**
 * Created by Mohammed Hemdan on 2019-10-21.
 * Email : mohammed.hemdan.faraj@gmail.com
 * Github : https://github.com/mhemdan
 */
class PopularActorsListRepository @Inject constructor(): BaseRepository() {

    @Inject
    lateinit var popularActorsApi: PopularActorsListApi

    fun getPopularActors(pageIndex: Int = 1) = popularActorsApi.getActorsList(pageIndex)

}