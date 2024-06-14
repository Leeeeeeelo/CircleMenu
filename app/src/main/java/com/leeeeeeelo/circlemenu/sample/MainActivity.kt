package com.leeeeeeelo.circlemenu.sample

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import kotlin.reflect.KClass

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.simpleMenu).setOnClickListener {
            openScreen(SimpleMenuActivity::class)
        }
        findViewById<Button>(R.id.bottomBarMenu).setOnClickListener {
            openScreen(BottomBarMenuActivity::class)
        }
        findViewById<Button>(R.id.fabMenu).setOnClickListener {
            openScreen(FabMenuActivity::class)
        }
    }

    private fun openScreen(activity: KClass<out Activity>) {
        startActivity(Intent(this, activity.java))
    }
}