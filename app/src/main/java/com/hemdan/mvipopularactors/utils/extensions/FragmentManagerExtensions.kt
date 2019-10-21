package com.sabbar.seeker.ibtikar.utils.extensions

import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

/**
 * Created by mohamed-hemdan on 01/04/19.
 * mohamed.hemdan@ibtikar.net.sa
 */

inline fun FragmentManager.inTransaction(func: FragmentTransaction.() -> FragmentTransaction?) {
    beginTransaction().func()?.commit()
}