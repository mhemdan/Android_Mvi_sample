package com.hemdan.mvipopularactors.utils

fun <T> unsafeLazy(block: () -> T) = lazy(LazyThreadSafetyMode.NONE) { block() }