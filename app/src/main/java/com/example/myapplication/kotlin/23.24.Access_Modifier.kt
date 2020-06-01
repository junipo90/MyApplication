package com.example.myapplication.kotlin

fun main(args: Array<String>) {

    val night:Night = Night(20, 4)
    val monster:Monster = Monster(15,5)

    night.attack(monster)
    monster.attack(night)

//    이런 식으로 클래스의 멤버 변수에 직접 접근 하면 안됨
//    night.hp = 100,
//    monster.power = 200

//    아무때나 클래스 메소드에 접근하면 안되는 기능 일때도 메소드에 private
//    night.heal()

}

class Night(private var hp:Int, private var power:Int){

    fun attack(monster: Monster){
        monster.defense(power)
    }

    fun defense(power: Int){
        hp -= power
        if(hp > 0){
            heal()
            println("기사의 현재 체력은 $hp 입니다")
        }else{
            println("기사의 죽었습니다")
        }
    }

    private fun heal(){
        hp += 3
    }

}

class Monster(private var hp:Int, private var power:Int){

    fun attack(night: Night){
        night.defense(power)
    }

    fun defense(power: Int) {
        hp -= power
        if(hp > 0){
            println("몬스터 의 현재 체력은 $hp 입니다")
        }else{
            println("몬스터가 죽었습니다")
        }
    }

}