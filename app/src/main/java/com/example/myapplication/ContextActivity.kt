package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_context.*

class ContextActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_context)

        // Context 의 두 가지 종류
        val context: ContextActivity = this
        val applicationContext = getApplicationContext()

        photoView.setOnClickListener(object : View.OnClickListener{
            var isDefault = true
            override fun onClick(v: View?) {
                isDefault = !isDefault
                if(isDefault){
                    photoView.setImageResource(R.drawable.dog)
                }else{
                    photoView.setImageResource(R.drawable.gradient)
                }
            }
        })

        scaleTypeButton.setOnClickListener(object :View.OnClickListener{
            var isDefault = true
            override fun onClick(v: View?) {
                isDefault = !isDefault
                if(isDefault){
                    photoView.scaleType = ImageView.ScaleType.CENTER_CROP
                }else{
                    photoView.scaleType = ImageView.ScaleType.FIT_XY
                }
            }
        })
    }
    ///////
}
