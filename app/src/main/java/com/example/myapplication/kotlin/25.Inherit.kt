package com.example.myapplication.kotlin

fun main(args: Array<String>) {

    var superCar100 : SuperCar100 = SuperCar100()
    println(superCar100.drive())
    superCar100.stop()

}

//부모 : Car100
//자식 : SuperCar100, Bus100
//class 는 기본 설정이 private -> 상속을 해주려면 open
open class Car100(){
    //오버라이딩 할 메소드도 open 해줘야 자식이 오버라이딩 할 수 있다
    open fun drive():String{
        return "달린다"
    }
    fun stop(){
        println("멈춘다")
    }
}

class SuperCar100(): Car100() {
    override fun drive(): String {
        val run = super.drive()
        return "빨리 $run"
    }
}

class Bus100(): Car100() {

}