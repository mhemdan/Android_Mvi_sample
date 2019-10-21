package com.sabbar.seeker.ibtikar.utils.extensions

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment

/**
 * Created by mohamed-hemdan on 27/03/19.
 * mohamed.hemdan@ibtikar.net.sa
 */

inline fun <reified T : Any> Fragment.launchActivity(
        requestCode: Int = -1,
        options: Bundle? = null,
        noinline init: Intent.() -> Unit = {}
) {

    val intent = context?.let { newIntent<T>(it) }
    intent?.init()
    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN) {
        startActivityForResult(intent, requestCode, options)
    } else {
        startActivityForResult(intent, requestCode)
    }
}

fun Fragment.replaceFragment(fragment: Fragment, frameId: Int) {
    childFragmentManager.inTransaction { replace(frameId, fragment) }
}

inline fun <T : Fragment> T.withArgs(
        argsBuilder: Bundle.() -> Unit
): T =
        this.apply {
            arguments = Bundle().apply(argsBuilder)
        }
