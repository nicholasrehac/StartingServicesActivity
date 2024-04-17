package edu.temple.startingservicesactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    val timerEditText: EditText by lazy {
        findViewById(R.id.timerEditText)
    }
    val startButton: Button by lazy {
        findViewById(R.id.startButton)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startButton.setOnClickListener {
            startService(
                Intent(this, TimerService::class.java).apply {
                    putExtra(TimerService.COUNTDOWN_KEY, timerEditText.text.toString().toInt())
                }
            )
        }
    }
}