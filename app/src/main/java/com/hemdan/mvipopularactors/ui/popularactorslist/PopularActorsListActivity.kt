package com.hemdan.mvipopularactors

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.hemdan.mvipopularactors.ui.base.BaseActivity
import com.hemdan.mvipopularactors.ui.base.DIBaseActivity
import dagger.android.AndroidInjector

class PopularActorsListActivity : DIBaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
