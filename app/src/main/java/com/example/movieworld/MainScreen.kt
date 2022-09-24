package com.example.movieworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.movieworld.databinding.ActivityMainScreenBinding


class MainScreen : AppCompatActivity() {
    private lateinit var binding: ActivityMainScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replace(MovieScreen())
        val sharedPreferences = getSharedPreferences("MovieApp", MODE_PRIVATE)
        binding.mainScreenUser.text = "Welcome, ${sharedPreferences.getString("userName", "name")}"
        binding.bottomNavBar.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.movie -> replace(MovieScreen())
                R.id.tv -> replace(TvScreen())
                R.id.setting -> replace(setting())
                else -> {
                }
            }
            true
        }
    }

    private fun replace(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_Layout, fragment)
        fragmentTransaction.commit()
    }
}