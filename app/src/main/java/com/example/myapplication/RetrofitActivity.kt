package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retrofit)


        // http://mellowcode.org/json/students/
        // http://mellowcode.org/test/code/

        val retrofit = Retrofit.Builder()
            .baseUrl("http://mellowcode.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(RetrofitService::class.java)

        // GET 요청
        service.getStudentList().enqueue(object : Callback<ArrayList<PersonFromServer>> {
            override fun onFailure(call: Call<ArrayList<PersonFromServer>>, t: Throwable) {
                Log.d("retrofitt", "ERROR")
            }

            override fun onResponse(
                call: Call<ArrayList<PersonFromServer>>,
                response: Response<ArrayList<PersonFromServer>>
            ) {
                if (response.isSuccessful) {
                    val personList = response.body()
                    Log.d("retrofitt", "res : " + personList?.get(0)?.age)

                    val code = response.code()
                    Log.d("retrofitt", "code : " + code)

                    //val error = response.errorBody()
                    val header = response.headers()
                    Log.d("retrofitt", "header : " + header)
                }
            }
        })
        // POST 요청 (1)
//        val params = HashMap<String, Any>()
//        params.put("name", "무비월드")
//        params.put("age", 900)
//        params.put("intro", "이 영화 제목이 뭐지?")
//        service.createStudent(params).enqueue(object : Callback<PersonFromServer> {
//            override fun onFailure(call: Call<PersonFromServer>, t: Throwable) {
//                Log.d("retorofitt", "ERROR")
//            }
//
//            override fun onResponse(call: Call<PersonFromServer>, response: Response<PersonFromServer>) {
//                if (response.isSuccessful) {
//                    val person = response.body()
//                    Log.d("retrofitt", "name : " + person?.name)
//                }
//            }
//        })
        // POST 요청 (2)
        val person = PersonFromServer(name = "접속무비월드", age = 333, intro = "눈여겨 볼 만하다")
        service.createStudentEasy(person).enqueue(object :Callback<PersonFromServer>{
            override fun onFailure(call: Call<PersonFromServer>, t: Throwable) {
                Log.d("retorofitt", "ERROR")
            }

            override fun onResponse(call: Call<PersonFromServer>, response: Response<PersonFromServer>) {
                if (response.isSuccessful) {
                    val person = response.body()
                    Log.d("retrofitt", "name : " + person?.name)
                }
            }
        })
    }
}
