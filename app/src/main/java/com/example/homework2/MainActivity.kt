package com.example.homework2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread

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
    }

    override fun onResume() {
        super.onResume()
        refreshlist()
    }

    private fun refreshlist() {
        doAsync {
            val db = Room.databaseBuilder(applicationContext, AppDatabase::class.java, "reminders").build()
            val reminders = db.reminderDao().getReminders()
            db.close()

            uiThread {

                if(reminders.isNotEmpty()) {
                    val adapter = ReminderAdapter(applicationContext, reminders)
                    list.adapter = adapter

                } else {
                    toast("No reminders yet")
                }
            }
        }
    }
}
