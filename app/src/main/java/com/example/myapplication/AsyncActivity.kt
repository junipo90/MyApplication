package com.example.myapplication

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ProgressBar
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_async.*
import java.lang.Exception

class AsyncActivity : AppCompatActivity() {

    var task: BackgroundAsyncTask? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_async)

        start.setOnClickListener {
            task = BackgroundAsyncTask(progressbar, ment)
            task?.execute()
        }
        stop.setOnClickListener {
            task?.cancel(true)
        }
    }

    override fun onPause() {
        task?.cancel(true)
        super.onPause()
    }
}

class BackgroundAsyncTask(
    val progressBar: ProgressBar,
    val progressTextView: TextView
) : AsyncTask<Int,Int,Int>(){
    // Params -> doInBackground 에서 사용 할 타입
    // Progress -> onProgressUpdate 에서 사용 할 타입
    // Result -> onPostExecute 에서 사용 할 타입

    var percent:Int = 0

    override fun onPreExecute() {
        percent = 0
        progressBar.setProgress(percent)
    }

    override fun doInBackground(vararg params: Int?): Int {
        while (isCancelled == false){
            percent++
            if(percent > 100){
                break
            }else{
                publishProgress(percent)
            }
            try {
                Thread.sleep(10)
            }catch (e: Exception){
                e.printStackTrace()
            }
        }
        return percent
    }

    override fun onProgressUpdate(vararg values: Int?) {
        progressBar.setProgress(values[0] ?: 0)
        progressTextView.setText("퍼센트 : ${values[0]}")
        super.onProgressUpdate(*values)
    }

    override fun onPostExecute(result: Int?) {
        progressTextView.setText("작업이 완료 되었습니다")
    }

    override fun onCancelled() {
        progressBar.setProgress(0)
        progressTextView.setText("작업이 취소 되었습니다")
    }
}
