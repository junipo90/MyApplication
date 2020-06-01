package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class NullSafety : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_null_safety)

//      ?.null 이 아니면 뒤에 구문을 실행해라
//      !! -> 개발자가 null 이 아님을 보장한다
        val num = 10
        val num2: Int? = null

        val num3 = num2?.plus(num) //num3 에는 null 이 들어간다

//      삼항 연산자 -> 엘비스 연산자 (?:)
        val num4 = num2 ?: 10   // num2 가 null 이면 10, null 이 아니면 num2 대입

    }

    fun plus(a: Int, b: Int?): Int {
        if (b != null) {
            return a + b
        } else {
            return a
        }
    }

    fun plus2(a: Int, b: Int?): Int? {
        return b?.plus(a)
    }
}
