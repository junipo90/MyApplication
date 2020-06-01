package com.example.myapplication

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_one.*

class FragmentOne : Fragment() {

    interface OnDataPasslistener {
        fun OnDataPass(data: String?)
    }

    lateinit var dataPassListener : OnDataPasslistener


    override fun onAttach(context: Context) {
        Log.d("life_cycle", "F onAttach")
        super.onAttach(context)
        dataPassListener = context as OnDataPasslistener
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("life_cycle", "F onCreate")
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Log.d("life_cycle", "F onCreateView")

        // Fragment 가 인터페이스를 처음으로 그릴 때 호출된다
        // inflater -> 뷰를 그리는 역할
        // container -> 부모뷰
        return inflater.inflate(R.layout.fragment_one, container, false)

//        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.d("life_cycle", "F onViewCreated")
        super.onViewCreated(view, savedInstanceState)

        // Activity 의 OnCreate 에서 했던 작업들을 Fragment 는 여기서 한
        pass.setOnClickListener {
            dataPassListener.OnDataPass("Good Bye")
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        Log.d("life_cycle", "F onActivityCreated")

        // Fragment 의 data 가져오는 방법
        val data = arguments?.getString("Hello")
        Log.d("data", data)
        super.onActivityCreated(savedInstanceState)
    }

    override fun onStart() {
        Log.d("life_cycle", "F onStart")
        super.onStart()
    }

    override fun onResume() {
        Log.d("life_cycle", "F onResume")
        super.onResume()
    }

    override fun onPause() {
        Log.d("life_cycle", "F onPause")
        super.onPause()
    }

    override fun onStop() {
        Log.d("life_cycle", "F onStop")
        super.onStop()
    }

    override fun onDestroyView() {
        Log.d("life_cycle", "F onDestroyView")
        super.onDestroyView()
    }

    override fun onDetach() {
        Log.d("life_cycle", "F onDetach")
        super.onDetach()
    }
}