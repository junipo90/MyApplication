package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class Resource : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resource)

        val ment = resources.getString(R.string.temp_string)
        Log.d("mentt", "ment : " + ment)

        val ment2 = getString(R.string.temp_string)
        Log.d("mentt", "ment2 : "+ ment2)

        val color = getColor(R.color.tempColor1)
        Log.d("mentt", "color : $color")
    }
}
