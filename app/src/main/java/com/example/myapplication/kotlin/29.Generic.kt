package com.example.myapplication.kotlin

fun main(args: Array<String>) {

    // 제네릭을 사용 하지 않는 경우
    // 형 변환을 해줘야 한다
    val list1 = listOf(1,2,3,"가")
    val a:String = list1[2].toString() //명시적 형 변환

    // 제네릭을 사용 하는 경우 -> 타입이 안전하다
    val list2 = listOf<String>("A", "B", "C")
    val b:String = list2[1] //String 이라는 것을 보장 받는다

    // 강한 타입 체크
    val list3 = listOf(1, 2, 3, "가", "나") // -> <Any> = int string float 의 조상 클래스
    val list4 = listOf<Int>(1, 2, 3) // 강한 타입 체크
}