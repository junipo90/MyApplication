package com.example.myapplication

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_shared_preference.*

class SharedPreferenceActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_preference)

        // SharedPreference 에 값을 저장하는 방법
        //   mode
        // - MODE_PRIVATE : 생성한 APP 에서만 사용 가능
        // - MODE_WORLD_READABLE : 다른 APP 에서 읽기전용 가능
        // - MODE_WORLD_WRITABLE : 다른 APP 에서 읽기쓰기 가능
        // - MODE_MULTI_PROCESS : 이미 호출되어 사용중인지 체크
        // - MODE_APPEND : 기존 Preference 에 신규로 추가

        save_Button.setOnClickListener {
        val sharedPreference = getSharedPreferences("sp1", Context.MODE_PRIVATE)
        val editor = sharedPreference.edit()
        editor.putString("hello", "안녕하세요")
        editor.putString("goodbye", "안녕히가세요")
        editor.commit()
        }

        // SharedPreference 에서 값을 불러오는 방법
        load_Button.setOnClickListener {
            val sharedPreference = getSharedPreferences("sp1", Context.MODE_PRIVATE)
            val value1 = sharedPreference.getString("hello", "데이터 없음")
            val value2 = sharedPreference.getString("goodbye", "데이터 없음")
            Log.d("key-value", "value = $value1")
            Log.d("key-value", "value = $value2")

        }

        delete_Button.setOnClickListener {
            val sharedPreference = getSharedPreferences("sp1", Context.MODE_PRIVATE)
            val editor = sharedPreference.edit()
            editor.remove("hello")
            editor.commit()
        }

        delete_all_Button.setOnClickListener {
            val sharedPreference = getSharedPreferences("sp1", Context.MODE_PRIVATE)
            val editor = sharedPreference.edit()
            editor.clear()
            editor.commit()
        }



    }
}
