package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_listener_practice.*

class ListenerPractice : AppCompatActivity() {

    var resultNum = 0
    var tempNum1 = 0
    var tempNum2 = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listener_practice)



        plus.setOnClickListener {
            resultNum = tempNum1 + tempNum2
            tempNum1 = resultNum
            tempNum2 = 0
            result.text = resultNum.toString()
        }

        AC.setOnClickListener {
            resultNum = 0
            tempNum1 = 0
            tempNum2 = 0
            result.setText("0")
        }

        num1.setOnClickListener {
            result.setText(tempNum2.toString() + "1")
            tempNum2 = (tempNum2.toString() + "1").toInt()
        }

        num2.setOnClickListener {
            result.setText(tempNum2.toString() + "2")
            tempNum2 = (tempNum2.toString() + "2").toInt()
        }

        num3.setOnClickListener {
            result.setText(tempNum2.toString() + "3")
            tempNum2 = (tempNum2.toString() + "3").toInt()
        }

        num4.setOnClickListener {
            result.setText(tempNum2.toString() + "4")
            tempNum2 = (tempNum2.toString() + "4").toInt()
        }

        num5.setOnClickListener {
            result.setText(tempNum2.toString() + "5")
            tempNum2 = (tempNum2.toString() + "5").toInt()
        }

        num6.setOnClickListener {
            result.setText(tempNum2.toString() + "6")
            tempNum2 = (tempNum2.toString() + "6").toInt()
        }

        num7.setOnClickListener {
            result.setText(tempNum2.toString() + "7")
            tempNum2 = (tempNum2.toString() + "7").toInt()
        }

        num8.setOnClickListener {
            result.setText(tempNum2.toString() + "8")
            tempNum2 = (tempNum2.toString() + "8").toInt()
        }

        num9.setOnClickListener {
            result.setText(tempNum2.toString() + "9")
            tempNum2 = (tempNum2.toString() + "9").toInt()
        }

        num0.setOnClickListener {
            result.setText(tempNum2.toString() + "0")
            tempNum2 = (tempNum2.toString() + "0").toInt()
        }
    }
}
