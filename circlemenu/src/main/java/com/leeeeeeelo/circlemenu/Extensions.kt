package com.leeeeeeelo.circlemenu

import android.graphics.drawable.Drawable
import android.view.View
import android.view.ViewTreeObserver
import android.view.ViewTreeObserver.OnGlobalLayoutListener
import androidx.core.view.ViewCompat


internal fun Drawable.setTintCompat(color: Int) {
    setTint(color)
}

fun View.onLaidOut(listener: () -> Unit) {
    onLaidOut(true, listener)
}

/** Executes the given [java.lang.Runnable] when the view is laid out  */
internal fun View.onLaidOut(removeListener: Boolean, listener: () -> Unit) {
    if (isLaidOut(this)) {
        listener()
        return
    }
    viewTreeObserver.addOnGlobalLayoutListener(object : OnGlobalLayoutListener {
        override fun onGlobalLayout() {
            if (removeListener) {
                removeOnGlobalLayoutListener(viewTreeObserver, this)
            }
            listener()
        }
    })
}

private fun removeOnGlobalLayoutListener(observer: ViewTreeObserver,
                                         listener: OnGlobalLayoutListener?) {
    observer.removeOnGlobalLayoutListener(listener)
}

/** Returns whether or not the view has been laid out  */
private fun View.isLaidOut(view: View): Boolean {
    return ViewCompat.isLaidOut(view) && view.width > 0 && view.height > 0
}