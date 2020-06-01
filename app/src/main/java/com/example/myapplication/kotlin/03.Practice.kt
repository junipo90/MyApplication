package com.example.myapplication.kotlin


var a = 1 + 2 + 3 + 4 + 5
var b = "1"
var c = b.toInt()
var d = b.toFloat()

var e = "Lee"
var f = "My name is $e, Nice to meet you"

//Null
//var abc: Int = null // 자료형에 null 넣으면 에러 (kotlin 은 null safety 언어)
var abc: Int? = null //자료형 뒤에 ? 를 넣어 주면 변수에 null을 넣을 수 있다


fun main(args: Array<String>) {

    println(a)
    println(b)
    println(c)
    println(d)
    println(e)
    println(f)

    println(abc)

}