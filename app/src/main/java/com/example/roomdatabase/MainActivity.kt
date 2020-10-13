package com.example.roomdatabase

import android.os.Bundle
import android.preference.PreferenceManager
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupActionBarWithNavController(findNavController(R.id.fragment))

        val mSharedPreference = PreferenceManager.getDefaultSharedPreferences(
            baseContext
        )
        val value = mSharedPreference.getString("loginusername", "")
        Log.e("Value ","value of loginusername$value")
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.fragment)
        return super.onSupportNavigateUp()
    }
}