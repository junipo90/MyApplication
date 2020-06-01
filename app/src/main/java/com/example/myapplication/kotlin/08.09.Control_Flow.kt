package com.example.myapplication.kotlin

fun main(args: Array<String>) {

    val a:Int? = null
    val b:Int = 10
    val c:Int = 100

    if(a == null){
        println("a is null")
    }else{
        println("a is not null")
    }

    //값을 리턴 하는 if
    val max = if(b > c){
        b
    }else{
        c
    }
    println(max)

    //엘비스 연산비 ?:
    var number: Int? = null
    // 대입 하는 값이 null 이면  ?: 뒤의 값을 넣고, null 아니면 그 값을 넣는다
    var number2: Int = number ?: 20
    println(number)
    println(number2)
}