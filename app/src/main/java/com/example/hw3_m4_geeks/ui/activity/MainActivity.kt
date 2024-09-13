package com.example.hw3_m4_geeks.ui.activity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.hw3_m4_geeks.R
import com.example.hw3_m4_geeks.databinding.ActivityMainBinding
import com.example.noteapp.utils.PreferenceHelper

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragment_container)as NavHostFragment
        navController= navHostFragment.navController

        val sharedPreferences = PreferenceHelper()
        sharedPreferences.unit(this)
        if (sharedPreferences.isOnBoardShown) {
            navController.navigate(R.id.noteFragment)
        } else if (!sharedPreferences.isOnBoardShown) {
            navController.navigate(R.id.onBoardFragment)
        }
    }
}