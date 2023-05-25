package ru.viknist.aston_dz_6

import android.view.View
import androidx.annotation.IdRes
import kotlin.reflect.KClass

fun <T> View.find(@IdRes idRes: Int): Lazy<T> {
    return lazy { findViewById(idRes) }
}

fun <T : Any> KClass<T>.getTag(): String = this.java.simpleName