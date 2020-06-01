package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class ContextActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_context)

        // Context 의 두 가지 종류
        val context: ContextActivity = this
        val applicationContext = getApplicationContext()
    }
}
