package com.example.damsharasgame

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.damsharasgame.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityResultBinding.inflate(layoutInflater)
        val globalVariable: GlobalVariable = GlobalVariable.instance
        super.onCreate(savedInstanceState)
        binding.tvResult.text = globalVariable.totalCount.toString()
        binding.btnPlayAgain.setOnClickListener{
            val intent = Intent(this,GameActivity::class.java)
            startActivity(intent)
        }
        setContentView(binding.root)
    }
}