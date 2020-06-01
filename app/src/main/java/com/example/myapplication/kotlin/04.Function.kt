package com.example.myapplication.kotlin

//함수 선언 방밥
//fun 함수명 (변수명 : 타입, 변수명 : 타입) : 반환 타입 {
// 함수 내용
// return 반환 값
// }

fun plus(first: Int, second: Int): Int {
    var result = first + second
    return result
}

//디폴트 값이 있는 함수
fun plusFive(first: Int, second: Int = 5): Int {
    var result: Int = first + second
    return result
}

//반환 값이 없는 함수 //여기서 : Unit 은 생략 가능 하다
fun printPlus(first: Int, second: Int): Unit {
    println(first + second)
}

//간단한 함수 선언 방법
fun plusShort(first: Int, second: Int) = first + second
    var abcd:Int = 1
//가변 인자를 받는 함수
fun plusMany(vararg numbers: Int) {
    for (number in numbers) {
        println(number)
    }
}

fun main(args: Array<String>) {
    var result = plus(5, 10)
    println(result)

    //변수를 명시적으로 전달하는 방법 (순서가 바뀌어도 가능 하다)
    var result2 = plus(first = 20, second = 30)
    println(result2)

    //디폴트 값이 있는 함수 호출
    println()
    var result3 = plusFive(10, 20)
    println(result3)
    var result4 = plusFive(10)
    println(result4)

    //반환 값이 없는 함수 호출
    println()
    printPlus(10, 40)

    //간단한 함수 호출
    println()
    var result5 = plusShort(50, 50)
    println(result5)

    //가변 인자를 받는 함수 호출
    println()
    plusMany(1,2,3,4,5)
}