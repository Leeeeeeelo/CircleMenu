package com.leeeeeeelo.circlemenu.sample

import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.view.animation.Animation
import android.view.animation.Animation.AnimationListener
import android.view.animation.AnimationUtils
import android.widget.Button
import androidx.activity.ComponentActivity
import com.leeeeeeelo.circlemenu.CircleMenu

class SimpleMenuActivity : ComponentActivity(), OnClickListener {

    private var circleMenu: CircleMenu? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple_menu)
        setupCircleMenu()
        setupButtons()
    }

    private fun setupCircleMenu() {
        val titles = arrayListOf("Favorite", "Search", "Alert", "Place", "Edit")

        circleMenu = findViewById(R.id.circleMenu)

        circleMenu?.setOnItemClickListener { buttonIndex ->
            Log.d("CircleMenuStatus", titles[buttonIndex])
        }

        circleMenu?.onMenuOpenAnimationStart {
            Log.d("CircleMenuStatus", "onMenuOpenAnimationStart")
        }

        circleMenu?.onMenuOpenAnimationEnd {
            Log.d("CircleMenuStatus", "onMenuOpenAnimationEnd")
        }

        circleMenu?.onMenuCloseAnimationStart {
            Log.d("CircleMenuStatus", "onMenuCloseAnimationStart")
        }

        circleMenu?.onMenuCloseAnimationEnd {
            Log.d("CircleMenuStatus", "onMenuCloseAnimationEnd")
        }

        circleMenu?.onButtonClickAnimationStart { buttonIndex ->
            Log.d("CircleMenuStatus", "onButtonClickAnimationStart: $buttonIndex")
        }

        circleMenu?.onButtonClickAnimationEnd { buttonIndex ->
            Log.d("CircleMenuStatus", "onButtonClickAnimationEnd: $buttonIndex")
        }
    }

    private fun setupButtons() {
        findViewById<Button>(R.id.openMenuButton).setOnClickListener(this)
        findViewById<Button>(R.id.closeMenuButton).setOnClickListener(this)
        findViewById<Button>(R.id.toggleMenuButton).setOnClickListener(this)
        findViewById<Button>(R.id.showMenuButton).setOnClickListener(this)
        findViewById<Button>(R.id.hideMenuButton).setOnClickListener(this)
        findViewById<Button>(R.id.animateInMenuButton).setOnClickListener(this)
        findViewById<Button>(R.id.animateOutMenuButton).setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.openMenuButton -> circleMenu?.open()
            R.id.closeMenuButton -> circleMenu?.close()
            R.id.toggleMenuButton -> circleMenu?.toggle()
            R.id.showMenuButton -> circleMenu?.visibility = View.VISIBLE
            R.id.hideMenuButton -> circleMenu?.visibility = View.GONE
            R.id.animateOutMenuButton -> animateOut()
            R.id.animateInMenuButton -> animateIn()
        }
    }

    private fun animateIn() {
        if (circleMenu?.visibility == View.VISIBLE) {
            return
        }
        circleMenu?.visibility = View.VISIBLE
        val animation = AnimationUtils.loadAnimation(this, R.anim.push_right_in_and_bounce)
        circleMenu?.startAnimation(animation)
    }

    private fun animateOut() {
        if (circleMenu?.visibility != View.VISIBLE) {
            return
        }
        val animation = AnimationUtils.loadAnimation(this, R.anim.bounce_and_push_right_out)
        animation.setAnimationListener(object : AnimationListener {
            override fun onAnimationStart(animation: Animation?) {}

            override fun onAnimationEnd(animation: Animation?) {
                circleMenu?.visibility = View.GONE
            }

            override fun onAnimationRepeat(animation: Animation?) {}
        })
        circleMenu?.startAnimation(animation)
    }

    override fun onDestroy() {
        super.onDestroy()
        circleMenu = null
    }
}