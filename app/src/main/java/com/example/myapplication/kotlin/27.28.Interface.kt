package com.example.myapplication.kotlin

fun main(args: Array<String>) {
    val student : Student = Student()
    student.eat()
    student.sleep()
    student.study()

}
//interface 는 약속이다.
// 구현해야 될 기능을 약속해 놓을 수 있다
// 인터페이스 도 구현이 있는 함수를 만들 수 있다
// 인터페이스 에 구현이 있는 함수는 인터페이스를 구현하는 클래스에서 그 함수를 구현할 필요 없다
interface Person{
    fun eat(){
        println("먹는다")
    }
    fun sleep(){
        println("잔다")
    }
    abstract fun study() // abstract 로 선언 된 함수는 반드시 구현 되어야 한다
}

class Student : Person{
    override fun study() {
    }
}

