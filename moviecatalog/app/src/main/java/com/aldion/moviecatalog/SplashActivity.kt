package com.aldion.moviecatalog

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.aldion.moviecatalog.databinding.ActivitySplashBinding
import com.aldion.moviecatalog.ui.home.HomeActivity

class SplashActivity : AppCompatActivity() {
    private var binding: ActivitySplashBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        Thread.sleep(2000)
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)

        finish()
    }
}