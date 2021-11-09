package com.aldion.jetpackprosubmission1

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.aldion.jetpackprosubmission1.databinding.ActivitySplashBinding
import com.aldion.jetpackprosubmission1.ui.home.HomeActivity
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class SplashActivity : AppCompatActivity() {
    private var binding: ActivitySplashBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        runBlocking {
            launch {
                delay(2000L)
                val intent = Intent(this@SplashActivity, HomeActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}