package com.galhardo.chronometer

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.view.View
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Chronometer
import kotlinx.android.synthetic.main.activity_stopwatch.*

class StopwatchActivity : AppCompatActivity() {

    var pausetime: Long = 0
    var running: Boolean = false
    var state: Int = 0


    @SuppressLint("ResourceAsColor", "UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stopwatch)
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN)
        button_reflesh.animate().alpha(0.0f).setDuration(300).start()


        // Load animations
        var roudingalone: Animation = AnimationUtils.loadAnimation(this, R.anim.roudingalone)
        var bg_play_pause: Animation = AnimationUtils.loadAnimation(this, R.anim.bg_play_pause)


        button_play.setOnClickListener {

            when(state){
                0 -> {
                    button_play.background = getDrawable(R.drawable.ic_pause_lm)
                    image_bg_pointer_watch.startAnimation(roudingalone)
                    button_play.startAnimation(bg_play_pause)
                    button_reflesh.animate().alpha(1.0f).setDuration(300).start()
                    chronometer.base = SystemClock.elapsedRealtime() + pausetime
                    chronometer.start()
                    state =1
                    onStop()
                }
                1->{
                    button_play.background = getDrawable(R.drawable.ic_play_lm)
                    button_play.startAnimation(bg_play_pause)
                    image_bg_pointer_watch.clearAnimation()
                    button_play.animate().alpha(1.0f).setDuration(300).start()
                    pausetime = chronometer.base - SystemClock.elapsedRealtime()
                    chronometer.stop()
                    state=0
                    onStop()
                }
            }
        }

        button_reflesh.setOnClickListener() {
            button_play.background = getDrawable(R.drawable.ic_play_lm)
            button_reflesh.animate().alpha(0.0f).setDuration(300).start()
            image_bg_pointer_watch.clearAnimation()
            chronometer.base=SystemClock.elapsedRealtime()
            chronometer.stop()
            pausetime=0
            state=0
            onStop()
        }
    }
}

