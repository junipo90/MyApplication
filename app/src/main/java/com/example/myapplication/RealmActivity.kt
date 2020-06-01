package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import io.realm.Realm
import io.realm.RealmConfiguration
import kotlinx.android.synthetic.main.activity_realm.*

class RealmActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_realm)

        Realm.init(this@RealmActivity)
        val config = RealmConfiguration.Builder()
            .deleteRealmIfMigrationNeeded()
            .build()
        Realm.setDefaultConfiguration(config)
        val realm = Realm.getDefaultInstance()

        button_save.setOnClickListener {
            realm.executeTransaction {
                with(it.createObject(School::class.java)) {
                    this.name = "어떤 학교"
                    this.location = "서울"
                }
            }
        }
        button_load.setOnClickListener {
            realm.executeTransaction {
                val data1 = it.where(School::class.java).findFirst()
                Log.d("realmData", "data1 : $data1")

            }

        }
        button_delete.setOnClickListener {
            realm.executeTransaction {
                it.where(School::class.java).findAll().deleteAllFromRealm() // 싹다 지워
//                it.where(School::class.java).findFirst().deleteFromRealm() // 첫 번째꺼 하나 지워
            }

        }
    }
}

