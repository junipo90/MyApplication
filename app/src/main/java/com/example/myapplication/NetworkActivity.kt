package com.example.myapplication

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_network.*
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class NetworkActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_network)

        NetworkTask(
            recycler_person,
            LayoutInflater.from(this@NetworkActivity)
        ).execute()

    }
}
// 네트워크를 메인스레드에서 하면 앱이 터진다 -> 메인스테드는 멈추면 안되니까
// 네트워크를 기다리는 동안 메인스레드가 기다릴테니까...
// 그래서 네트워크는 AsyncTask 비동기에서 사용하면서 메인스레드로 돌아오는 onPostExecute 에서 데이터를 받아 그려준다
class NetworkTask(
    val recyclerView: RecyclerView,
    val inflater: LayoutInflater
) : AsyncTask<Any?, Any?, Array<PersonFromServer>>() {
    override fun onPostExecute(result: Array<PersonFromServer>?) {

        val adapter = PersonAdapter(result!!, inflater)
        recyclerView.adapter = adapter
        super.onPostExecute(result)
    }

    override fun doInBackground(vararg params: Any?): Array<PersonFromServer> {
        val urlString = "http://mellowcode.org/json/students/"
        val url = URL(urlString)
        val connection = url.openConnection() as HttpURLConnection

        connection.requestMethod = "GET"
        connection.setRequestProperty("Content-Type", "application/json")

        var buffer = ""
        if (connection.responseCode == HttpURLConnection.HTTP_OK) {
            Log.d("connn", "inputstream : " + connection.inputStream)
            val reader = BufferedReader(
                InputStreamReader(
                    connection.inputStream,
                    "UTF-8"
                )
            )
            buffer = reader.readLine()
            Log.d("connn", "buffer : " + buffer)
        }

        val data = Gson().fromJson(buffer, Array<PersonFromServer>::class.java)
        Log.d("connn", "data : " + data)

        return data
    }
}

class PersonAdapter(
    var personList : Array<PersonFromServer>,
    var inflater: LayoutInflater
): RecyclerView.Adapter<PersonAdapter.ViewHolder>(){
    inner class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        val name : TextView
        val age : TextView
        val intro : TextView

        init {
            name = itemView.findViewById(R.id.person_name)
            age = itemView.findViewById(R.id.person_age)
            intro = itemView.findViewById(R.id.person_ment)
        }
    }

    override fun getItemCount(): Int {
        return personList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = inflater.inflate(R.layout.person_list_item, parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.setText(personList.get(position).name ?: "")
        holder.age.setText(personList.get(position).age.toString())
        holder.intro.setText(personList.get(position).intro ?: "")
    }
}