package com.aldion.moviecatalog

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.aldion.moviecatalog.databinding.ActivitySplashBinding
import com.aldion.moviecatalog.ui.home.HomeActivity
import kotlinx.coroutines.*

class SplashActivity : AppCompatActivity() {
    private var binding: ActivitySplashBinding? = null
    val time = 2000L
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        withCoroutine(time)
    }

    private fun withCoroutine(time: Long) {
        val mScope = CoroutineScope(Dispatchers.IO)
        mScope.launch {
            delay(time)
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