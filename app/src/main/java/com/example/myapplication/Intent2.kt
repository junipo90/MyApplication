package com.example.myapplication

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_intent2.*

class Intent2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent2)


        result.setOnClickListener {
            val intExtra1 = intent.getIntExtra("number1", 0)
            val intExtra2 = intent.getIntExtra("number", 0) //number 가 아니라 number2 -> 디폴트 값이 나

            Log.d("number", intExtra1.toString())
            Log.d("number", intExtra2.toString())

            val result = intExtra1 + intExtra2
            val resultIntent = Intent()
            resultIntent.putExtra("result", result)
            setResult(Activity.RESULT_OK, resultIntent)

            this.finish() // Activity 종료 (여기선 intent2 가 종료, 그럼 밑에 있던 intent1 이 보이게 될 것
        }
    }
}
