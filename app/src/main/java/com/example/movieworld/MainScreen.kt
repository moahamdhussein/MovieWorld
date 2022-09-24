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
        binding.bottomNavBar.setOnItemSelectedListener {
            when (it.itemId) {

                R.id.home -> replace(MovieScreen())
                R.id.profile -> replace(TvScreen())

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