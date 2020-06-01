package com.example.myapplication

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_out_stagram_upload.*
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.File

class OutStagramUploadActivity : AppCompatActivity() {

    lateinit var filePath: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_out_stagram_upload)

        view_pictures.setOnClickListener {
            getPicture()
        }

        upload_post.setOnClickListener {
            uploadPost()
        }

        all_list.setOnClickListener { startActivity(Intent(this, OutStagramPostListActivity::class.java)) }
        my_list.setOnClickListener { startActivity(Intent(this, OutStagramMyPostActivity::class.java)) }
        user_info.setOnClickListener { startActivity(Intent(this, OutStagramUserInfo::class.java)) }
    }

    fun getPicture() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        intent.setType("image/*")
        startActivityForResult(intent, 1000)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        val carmraCheckSelfPermission = ContextCompat.checkSelfPermission(
            this@OutStagramUploadActivity,
            android.Manifest.permission.READ_EXTERNAL_STORAGE
        )

        if (carmraCheckSelfPermission != PackageManager.PERMISSION_GRANTED) {
            // 권한이 없는 경우
            ActivityCompat.requestPermissions(
                this,
                arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE),
                1000
            )
        } else {
            // 권한이 있는 경우
            Log.d("pathh", "권한이 이미 있습니다")
            if (requestCode === 1000) {
                val uri: Uri = data!!.data!!
                Log.d("pathh", "path : $uri")
                filePath = getImageFilePath(uri)
                Log.d("pathh", "path : $filePath")
            }
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 1000) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // 승낙
                Log.d("pathh", "승낙")
            } else {
                // 거부
                Log.d("pathh", "거부")
            }
        }
    }

    fun getImageFilePath(contentUri: Uri): String {
        var columnIndex = 0
        val projection = arrayOf(MediaStore.Images.Media.DATA)
        val cursor = contentResolver.query(contentUri, projection, null, null, null)
        if (cursor!!.moveToFirst()) {
            columnIndex = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA)
        }
        return cursor.getString(columnIndex)
    }

    fun uploadPost(){
        val file = File(filePath)
        val fileRequestBody = RequestBody.create(MediaType.parse("image/*"), file)
        val part = MultipartBody.Part.createFormData("image", file.name, fileRequestBody)
        val content = RequestBody.create(MediaType.parse("text/plain"),getContent())

        (application as MasterApplication).service.uploadPost(
            part, content
        ).enqueue(object : Callback<Post>{
            override fun onFailure(call: Call<Post>, t: Throwable) {

            }

            override fun onResponse(call: Call<Post>, response: Response<Post>) {
                if(response.isSuccessful){
                    val post = response.body()
                    Log.d("pathh", post!!.content)
                    startActivity(Intent(this@OutStagramUploadActivity, OutStagramMyPostActivity::class.java))

                }
            }
        })
    }

    fun getContent():String{
        return content_input.text.toString()
    }


}
