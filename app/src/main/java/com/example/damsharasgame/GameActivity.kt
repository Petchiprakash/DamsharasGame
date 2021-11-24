package com.example.damsharasgame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.TextView
import com.example.damsharasgame.databinding.ActivityGamrBinding
import java.util.*
import java.util.concurrent.TimeUnit
import kotlin.concurrent.timerTask

class GameActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGamrBinding
    private val movieList: MutableList<String> =
        mutableListOf("PETTA", "MASTER", "VISWASAM", "SOORARAI POOTRU", "KARNAN")
    private var count = 0
    private var tvTimer: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityGamrBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        binding.btnGotIt.setOnClickListener {
            val random: Int = (0 until (movieList.size)).random()
            count++
            binding.textViewGuess.text = movieList[random]
            binding.tvCount.text = count.toString()
        }
        binding.btnSkip.setOnClickListener {
            val random: Int = (0 until (movieList.size)).random()
            binding.textViewGuess.text = movieList[random]
        }
        tvTimer = binding.tvTimer
        startTimer()
        resultActivity()
        setContentView(binding.root)
    }
    private var countDownTimer = object : CountDownTimer(1000 * 30, 1000) {
        override fun onTick(millisUntilFinished: Long) {
            tvTimer?.text = getString(
                R.string.formatted_time,
                TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished) % 60,
                TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) % 60
            )
        }

        override fun onFinish() {
        }
    }

    private fun startTimer() {
        countDownTimer.start()
    }

    private fun resultActivity() {
        val intent = Intent(this, ResultActivity::class.java)
        val tmtask = timerTask {
            if (!isDestroyed) {
                startActivity(intent)
                finish()
            }
        }
        val timer = Timer()
        timer.schedule(tmtask, 1000 * 30)
    }

    override fun onDestroy() {
        super.onDestroy()
        countDownTimer.cancel()
    }

}