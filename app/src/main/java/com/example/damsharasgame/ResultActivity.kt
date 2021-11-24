package com.example.damsharasgame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.damsharasgame.databinding.ActivityMainBinding
import com.example.damsharasgame.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityResultBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        val intent = Intent(this,GameActivity::class.java)
        setContentView(R.layout.activity_result)
    }
}