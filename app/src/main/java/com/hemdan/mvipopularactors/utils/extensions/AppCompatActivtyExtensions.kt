package com.sabbar.seeker.ibtikar.utils.extensions

import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment

/**
 * Created by mohamed-hemdan on 01/04/19.
 * mohamed.hemdan@ibtikar.net.sa
 */

fun AppCompatActivity.addFragment(fragment: Fragment, frameId: Int) {
    supportFragmentManager.inTransaction { add(frameId, fragment, fragment.javaClass.simpleName) }
}

fun AppCompatActivity.addFragmentWithBackStack(fragment: Fragment, frameId: Int) {
    supportFragmentManager.inTransaction {
        add(frameId, fragment)
        addToBackStack(fragment.javaClass.simpleName)
    }
}

fun AppCompatActivity.addFragment(fragment: DialogFragment) {
    supportFragmentManager.inTransaction { add(fragment, fragment.javaClass.simpleName) }
}

fun AppCompatActivity.findFragment(fragmentTag: String): Fragment? = supportFragmentManager.findFragmentByTag(fragmentTag)

fun AppCompatActivity.replaceFragment(fragment: Fragment, frameId: Int, tag:String = "") {
    supportFragmentManager.inTransaction { replace(frameId, fragment, tag) }
}

fun AppCompatActivity.removeFragment(tag: String) {
    supportFragmentManager.inTransaction { supportFragmentManager.findFragmentByTag(tag)?.let { remove(it) } }
}

fun AppCompatActivity.removeFragment(fragment: Fragment) {
    supportFragmentManager.inTransaction { remove(fragment) }
}

fun AppCompatActivity.addAndHide(fragment: Fragment, frameId: Int){
    supportFragmentManager.inTransaction {
        add(frameId, fragment, fragment.javaClass.simpleName)
    hide(fragment)}
}

fun AppCompatActivity.addAndShow(fragment: Fragment, frameId: Int){
    supportFragmentManager.inTransaction {
        add(frameId, fragment, fragment.javaClass.simpleName)
        show(fragment)}
}


fun AppCompatActivity.hideAndShow(toHide: Fragment, toShow: Fragment) {
    supportFragmentManager.inTransaction {
        hide(toHide)
        show(toShow)
    }
}

fun <T> AppCompatActivity.runOnUi(delay: Long, f: () -> T) {
    Handler().postDelayed({ f() }, delay)
}