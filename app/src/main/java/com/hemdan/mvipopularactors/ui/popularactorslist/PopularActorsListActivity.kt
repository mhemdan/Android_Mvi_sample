package com.hemdan.mvipopularactors

import android.os.Bundle
import com.hemdan.mvipopularactors.ui.base.DIBaseActivity
import com.hemdan.mvipopularactors.ui.popularactorslist.PopularActorsFragment
import com.sabbar.seeker.ibtikar.utils.extensions.replaceFragment

class PopularActorsListActivity : DIBaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.popular_actors_list_activity)

        replaceFragment(PopularActorsFragment.newInstance(), R.id.fragmentContainer)
    }
}
