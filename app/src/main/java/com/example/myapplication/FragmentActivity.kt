package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.FragmentManager
import kotlinx.android.synthetic.main.activity_fragment.*

class FragmentActivity : AppCompatActivity(), FragmentOne.OnDataPasslistener {

    override fun OnDataPass(data: String?) {
        Log.d("pass", data.toString())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)
        Log.d("life_cycle", "onCreate")

        // Fragment 를 만들고..
        val fragmentOne: FragmentOne = FragmentOne()

        // Fragment 에 Data 를 넣어주는 방법
        val bundle: Bundle = Bundle()
        bundle.putString("Hello", "안녕하세요")
        fragmentOne.arguments = bundle

        button.setOnClickListener {
            // Fragment 를 붙이는 방법 -> add/replace
            // Fragment 를 동적으로 작동하는 방법
            val fragmentManager: FragmentManager = supportFragmentManager

            // Transaction
            // 작업의 단위 -> 시작과 끝이 있다
            val fragmentTransaction = fragmentManager.beginTransaction() // 시작
            fragmentTransaction.replace(R.id.container, fragmentOne)
            fragmentTransaction.commit() // 끝
            // 끝내는 방법
            // commit() -> 시간 될 때 해해 (더 안정적)
            // commitNow() -> 지금 당장
        }

        button2.setOnClickListener {
            // Fragment 를 제거 하는 방법 -> detach/remove
            // remove 붙이면 다시 붙고 떼고 가능
            // detach 한번 떼어내면 다시 안붙고 사라짐
            val fragmentManager: FragmentManager = supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.remove(fragmentOne)
            fragmentTransaction.commit()
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("life_cycle", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("life_cycle", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("life_cycle", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("life_cycle", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("life_cycle", "onDestroy")
    }
}
