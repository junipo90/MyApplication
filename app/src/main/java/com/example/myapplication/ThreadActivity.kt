package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_thread.*

class ThreadActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thread)


        val runnable: Runnable = object : Runnable {
            override fun run() {
                Log.d("thread-1", "thread1 is made")
            }
        }
        val thread: Thread = Thread(runnable)

        button3.setOnClickListener {
            thread.start()
            Log.d("thread-1", "button push")
        }


        // 일반 축약식
        Thread(object : Runnable {
            override fun run() {
                Log.d("thread-1", "thread2 is made")
            }
        }).start()


        // 람다를 이용한 방식
        Thread(Runnable {
            Thread.sleep(2000)
            Log.d("thread-1", "thread3 is made")
            runOnUiThread { // UI를 바꾸는 것은 main thread 에서만 할 수 있다 -> 그래서 runOnUiThread
                button3.setBackgroundColor(R.color.colorPrimary)
            }
        }).start()


    }


}
