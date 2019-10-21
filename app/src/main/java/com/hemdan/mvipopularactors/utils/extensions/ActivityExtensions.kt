package com.sabbar.seeker.ibtikar.utils.extensions


import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle

/**
 * Created by mohmed on 23/12/18.
 * mohamed.hemdan@ibtikar.net.sa
 */

/**
 * Extensions for simpler launching of Activities
 */

inline fun <reified T : Any> Activity.launchActivity(
        requestCode: Int = -1,
        options: Bundle? = null,
        noinline init: Intent.() -> Unit = {}
) {

    val intent = newIntent<T>(this)
    intent.init()
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
        startActivityForResult(intent, requestCode, options)
    } else {
        startActivityForResult(intent, requestCode)
    }
}

inline fun <reified T : Any> Context.launchActivity(
        options: Bundle? = null,
        noinline init: Intent.() -> Unit = {}
) {

    val intent = newIntent<T>(this)
    intent.init()
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
        startActivity(intent, options)
    } else {
        startActivity(intent)
    }
}

inline fun <reified T : Any> newIntent(context: Context): Intent =
        Intent(context, T::class.java)

//fun Activity.changeLanguage(language: String){
//    val locale = Locale(language)
//    val res = this.application.resources
//    val dm = res.displayMetrics
//    val config = res.configuration
//    config.locale = locale
//    res.updateConfiguration(config, dm)
//    Locale.setDefault(locale)
//
//    if (Utilities.isAtLeastVersion(Build.VERSION_CODES.JELLY_BEAN_MR1)) {
//        config.setLocale(locale)
//        this.application.createConfigurationContext(config)
//    }
//}
