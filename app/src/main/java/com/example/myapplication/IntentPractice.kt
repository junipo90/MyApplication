package com.example.myapplication

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import kotlinx.android.synthetic.main.activity_intent_practice.*

class IntentPractice : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_practice)

        url_button.setOnClickListener {
            val urlText = url_text.text.toString()
            var intent = Intent(Intent.ACTION_VIEW, Uri.parse(urlText))
            startActivity(intent)
        }

        url_text.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                if(s.toString() == "abc"){
                    Log.d("edit", "text is abc")
                }
                Log.d("edit", s.toString())
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                Log.d("edit", s.toString())
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                Log.d("edit", s.toString())
            }
        })
    }
}
