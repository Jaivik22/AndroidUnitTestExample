package com.example.unittestingexample

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class usingExpresso : AppCompatActivity() {
    lateinit var incrementBtn:Button;
    lateinit var shareBtn:Button;
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_using_expresso)

        incrementBtn = findViewById(R.id.incrementBtn);
        shareBtn = findViewById(R.id.shareBtn)

        var counter = 0

        incrementBtn.setOnClickListener {
            counter++
            incrementBtn.text = counter.toString()
        }

        shareBtn.setOnClickListener {
            val shareIntent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "This is the text to share.")
                type = "text/plain"
            }
            startActivity(Intent.createChooser(shareIntent, "Share via"))
        }
    }
}