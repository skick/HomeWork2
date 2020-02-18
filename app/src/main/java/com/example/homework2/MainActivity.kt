package com.example.homework2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        time_button.setOnClickListener {
            startActivity(Intent(applicationContext, TimeActivity::class.java))
        }

        map_button.setOnClickListener {
            startActivity(Intent(applicationContext, MapActivity::class.java))
        }

        test_button.setOnClickListener {
            startActivity(Intent(applicationContext, TestActivity::class.java))
        }

        val data = arrayOf("Oulu", "Helsinki", "Tampere", "Rovaniemi")
        val reminderAdapter = ReminderAdapter(applicationContext, data)
        list.adapter = reminderAdapter
    }
}
