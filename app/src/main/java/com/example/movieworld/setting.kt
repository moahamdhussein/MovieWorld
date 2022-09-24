package com.example.movieworld

import android.app.Activity
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.fragment_setting.view.*


class setting() : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_setting, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val sharedPreferences: SharedPreferences =
            requireActivity().getSharedPreferences("MovieApp", AppCompatActivity.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        view.setting_userName.text = sharedPreferences.getString("userName", "name")
        view.logoutButton.setOnClickListener {
            editor.putInt("count", 0)
            editor.apply()
            val intent: Intent = Intent(context, LoginActivity::class.java)
            startActivity(intent)
            requireActivity().finishAffinity()
        }
        view.exitButton.setOnClickListener {
            Toast.makeText(
                context,
                "thank you to use our App ${view.setting_userName.text}",
                Toast.LENGTH_LONG
            ).show()
            requireActivity().finishAffinity()
        }


    }


}