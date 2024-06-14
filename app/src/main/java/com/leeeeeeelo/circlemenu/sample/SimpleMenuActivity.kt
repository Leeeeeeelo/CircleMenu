package com.leeeeeeelo.circlemenu.sample

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import com.leeeeeeelo.circlemenu.CircleMenu

class SimpleMenuActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple_menu)

        val titles = arrayListOf("Favorite", "Search", "Alert", "Place", "Edit")

        val circleMenu = findViewById<CircleMenu>(R.id.circleMenu)

        circleMenu.setOnItemClickListener { buttonIndex ->
            Log.d("CircleMenuStatus", titles[buttonIndex])
        }

        circleMenu.onMenuOpenAnimationStart {
            Log.d("CircleMenuStatus", "onMenuOpenAnimationStart")
        }

        circleMenu.onMenuOpenAnimationEnd {
            Log.d("CircleMenuStatus", "onMenuOpenAnimationEnd")
        }

        circleMenu.onMenuCloseAnimationStart {
            Log.d("CircleMenuStatus", "onMenuCloseAnimationStart")
        }

        circleMenu.onMenuCloseAnimationEnd {
            Log.d("CircleMenuStatus", "onMenuCloseAnimationEnd")
        }

        circleMenu.onButtonClickAnimationStart { buttonIndex ->
            Log.d("CircleMenuStatus", "onButtonClickAnimationStart: $buttonIndex")
        }

        circleMenu.onButtonClickAnimationEnd { buttonIndex ->
            Log.d("CircleMenuStatus", "onButtonClickAnimationEnd: $buttonIndex")
        }
    }

}