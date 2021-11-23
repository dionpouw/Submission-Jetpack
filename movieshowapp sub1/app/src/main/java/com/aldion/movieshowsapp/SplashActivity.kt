package com.aldion.movieshowsapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.aldion.movieshowsapp.databinding.ActivitySplashBinding
import com.aldion.movieshowsapp.ui.home.HomeActivity
import kotlinx.coroutines.*

class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        withCoroutine(2000L)
    }

    private fun withCoroutine(delay: Long) {
        val mScope = CoroutineScope(Dispatchers.IO)
        mScope.launch {
            delay(delay)
            withContext(Dispatchers.Main) {
                launchPostSplashActivity()
                mScope.cancel(null)
            }
        }
    }

    private fun launchPostSplashActivity() {
        // launch another activity
        val intent = Intent(this@SplashActivity, HomeActivity::class.java)
        startActivity(intent)
        finish() // necessary because we do not want user to come back to this activity
    }
}