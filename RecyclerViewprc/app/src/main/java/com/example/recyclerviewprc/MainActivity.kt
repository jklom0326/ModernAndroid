package com.example.recyclerviewprc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

//    private val dataArray : ArrayList<Pet> = ArrayList()
    private val petList = arrayListOf<Pet>(
        Pet("British Shorthair", "Male", "4", "british_shorthair"),
        Pet("Persian Cat", "Male", "3", "persian_cat"),
        Pet("Siamese Cat", "Female", "7", "siamese_cat"),
        Pet("Maine Coon", "Male", "13", "maine_coon"),
        Pet("Ragdoll", "Male", "45", "ragdoll"),
        Pet("Abyssinian", "Male", "16", "abyssinian"),
        Pet("Sphynx Cat", "Female", "3", "sphynx_cat")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv_data_list.layoutManager = LinearLayoutManager(this)
        rv_data_list.setHasFixedSize(true)
        rv_data_list.adapter = DataAdapter(petList, this){
            Toast.makeText(
                this,"Breed  ${it.breed}, Age : ${it.age}",
                Toast.LENGTH_LONG
            )
        }
    }

}

