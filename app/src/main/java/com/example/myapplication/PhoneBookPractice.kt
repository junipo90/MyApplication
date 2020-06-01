package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView

class PhoneBookPractice : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone_book_practice)

        val phoneBook = createFakePhoneBook(30)
        createPhoneBookList(phoneBook)


    }

    fun createFakePhoneBook(fakeNumber:Int = 10, phoneBook:PhoneBook = PhoneBook()) : PhoneBook{

        for(i in 0 until fakeNumber){
            phoneBook.addPerson(Person("$i 번째 사람", "$i 번째 번호"))
        }

        return phoneBook
    }

    fun createPhoneBookList(phoneBook: PhoneBook){
        val layoutInflater = LayoutInflater.from(this@PhoneBookPractice)
        val container = findViewById<LinearLayout>(R.id.phoneBookContainer)
        for (i in 0 until phoneBook.personList.size){
            val view = layoutInflater.inflate(R.layout.phone_view, null)
            val personViewName = view.findViewById<TextView>(R.id.personName)
            personViewName.setText(phoneBook.personList[i].name)
            addSetOnClickListener(phoneBook.personList[i], view)
            container.addView(view)
        }
    }

    fun addSetOnClickListener(person: Person, view: View){
        view.setOnClickListener {
            val intent = Intent(this@PhoneBookPractice, PhoneBookDetailActivity::class.java)
            intent.putExtra("name", person.name)
            intent.putExtra("number", person.phoneNum)
            startActivity(intent)
        }
    }


}

class PhoneBook(){
    val personList = ArrayList<Person>()
    fun addPerson(person:Person){
        personList.add(person)
    }
}

class Person (val name : String, val phoneNum : String){

}
