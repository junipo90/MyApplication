package com.example.myapplication.kotlin

//변수의 접근 가능 범위
// 1. 전역 변수
// 2. 지역 변수
// -> 변수를 만들 때 최대한 작은 범위로 만들어라

var number100 :Int = 10 //전역 변수

fun main(args: Array<String>) {
    println(number100)
    number100 = 20
    println(number100)
    val test01:Test = Test(111)
    println(test01.num)
    test01.test()
    println(number100)
    println(test01.num)

}

class Test(var num:Int){
    fun test(){
        var name:String = "lee"
        num = 333
        number100 = 500
//        num222 -> 에러
        println("Test class -> test method")
        fun testIn(){
            var num222:Int = 999
        }
    }
}