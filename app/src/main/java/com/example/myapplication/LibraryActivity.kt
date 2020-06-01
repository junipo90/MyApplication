package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_library.*

class LibraryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_library)

//        manifests 에서  <uses-permission android:name="android.permission.INTERNET" />
//        이 앱에서 인터넷에 접속 할 수 있도록 권한을 줘야한다
        Glide.with(this@LibraryActivity).load("https://www.sciencemag.org/sites/default/files/styles/article_main_image_-_1280w__no_aspect_/public/dogs_1280p_0.jpg?itok=6jQzdNB8").into(glide)
    }
}
