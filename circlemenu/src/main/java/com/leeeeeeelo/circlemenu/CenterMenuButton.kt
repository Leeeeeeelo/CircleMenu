package com.leeeeeeelo.circlemenu

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.ColorStateList
import android.graphics.drawable.AnimatedVectorDrawable
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton

@SuppressLint("ViewConstructor")
internal class CenterMenuButton(
    context: Context,
    backgroundColor: Int,
    menuIconType: CircleMenu.MenuIconType,
    private val iconColor: Int,
    private var isOpened: Boolean
) : FloatingActionButton(context) {

    private val menuIcon: MenuIcon by lazy {
        when (menuIconType) {
            CircleMenu.MenuIconType.HAMBURGER -> HamburgerMenuIcon()
            CircleMenu.MenuIconType.PLUS -> PlusMenuIcon()
        }
    }

    init {
        backgroundTintList = ColorStateList.valueOf(backgroundColor)
        setImageDrawable(getIconDrawable(!isOpened))
    }

    fun setOpened(isOpened: Boolean) {
        this.isOpened = isOpened
        startVectorAnimation(isOpened)
    }

    private fun startVectorAnimation(isOpening: Boolean) {
        val menuIcon = getIconDrawable(isOpening) as AnimatedVectorDrawable
        setImageDrawable(menuIcon)
        menuIcon.start()
    }

    private fun getIconDrawable(isOpening: Boolean): Drawable {
        //animation from closed to opened
        val iconResId = if (isOpening) menuIcon.openingAnimatedIcon else menuIcon.closingAnimatedIcon

        val icon = ContextCompat.getDrawable(context, iconResId) as AnimatedVectorDrawable
        icon.reset()
        icon.setTintCompat(iconColor)
        return icon
    }

}