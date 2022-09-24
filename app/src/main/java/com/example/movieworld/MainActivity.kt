package com.example.movieworld

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView


class MainActivity : AppCompatActivity() {
    private val splash: Long = 2000

    private lateinit var topAnim: Animation
    private lateinit var bottomAnim: Animation

    private lateinit var imageFirstScreen: ImageView
    private lateinit var textFirstScreen: TextView
    private lateinit var descFirstScreen: TextView
    private val handler: Handler = Handler()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        topAnim = AnimationUtils.loadAnimation(this, R.anim.top_animation)
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation)

        imageFirstScreen = findViewById(R.id.image_firstScreenImage)
        textFirstScreen = findViewById(R.id.text_firstScreenTitle)
        descFirstScreen = findViewById(R.id.text_firstScreenDesc)


        imageFirstScreen.animation = topAnim
        textFirstScreen.animation = bottomAnim
        descFirstScreen.animation = bottomAnim

    }

    private val runnable: Runnable = Runnable {
        if (!isFinishing) {
            val intent: Intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    override fun onResume() {
        super.onResume()

        handler.postDelayed(runnable, splash)
    }

    override fun onPause() {
        super.onPause()
        handler.removeCallbacks(runnable)
    }



}