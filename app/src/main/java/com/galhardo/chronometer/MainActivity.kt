package com.galhardo.chronometer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN)

        button_get_started.setOnClickListener {
            startActivity(Intent(this, StopwatchActivity::class.java))
        }

        // Load animations
        var atg: Animation
        var btgone: Animation
        var btgtwo: Animation
        atg = AnimationUtils.loadAnimation(this, R.anim.atg)
        btgone = AnimationUtils.loadAnimation(this, R.anim.btgone)
        btgtwo = AnimationUtils.loadAnimation(this, R.anim.btgtwo)

        // Parsing Animations

        image_bg_main.startAnimation(atg)
        text_title_main.startAnimation(btgone)
        text_sub_title_main.startAnimation(btgone)
        button_get_started.startAnimation(btgtwo)


    }
}