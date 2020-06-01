package com.example.myapplication

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_intent.*

class Intent1 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent)

        change_activity.setOnClickListener {
//            val intent = Intent(this@Intent1, Intent2::class.java)
//            // key, value 방 -> key 와 value 를 쌍으로 만들어 저장한다 -> Dictionary
//            intent.putExtra("number1", 1)
//            intent.putExtra("number2", 2)
//            startActivity(intent)


            // 위 코드와 완전히 똑같이 기능한다 -> apply 를 사용하는 습관을 갖자 -> 유지보수에 더 좋음
//            val intent2 = Intent(this@Intent1, Intent2::class.java)
//            intent2.apply {
//                this.putExtra("number1", 1)
//                this.putExtra("number2", 2)
//            }
//            startActivityForResult(intent2, 200)

            // 암시적 인텐트 (행동을 요청하면, 수행 가능한 대상이 해당 요청을 수행 -> 수행 가능한 대상이 여러개 라면 선택 창이 나옴)
            val intent3 = Intent(Intent.ACTION_VIEW, Uri.parse("http://m.naver.com"))
            startActivity(intent3)

        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if(requestCode == 200){
            Log.d("number", requestCode.toString())
            Log.d("number", resultCode.toString())
            val result = data?.getIntExtra("result", 0)
            Log.d("number", result.toString())
        }
        super.onActivityResult(requestCode, resultCode, data)
    }


}
