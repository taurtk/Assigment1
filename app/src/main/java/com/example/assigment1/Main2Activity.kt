package com.example.assigment1

import android.content.Intent
import android.media.Image
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main2.view.*

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val name = arrayOf("ant man", "barton", "black panther", "black widow", "captain america", "captain marvel", "hulk")
        val real = arrayOf("Robert Downey Jr. " , "Chris Evans" , "Chris Hensforth" , "Mark Ruffalow" , "Scarlet johnson" ,"Hawk eye" , "Scott lang" , "Elizabeth")
        val images=arrayOf(R.drawable.ant_man,R.drawable.barton,R.drawable.black_panther,R.drawable.black_widow,R.drawable.captain_america,R.drawable.captain_marvel,R.drawable.hulk)
        val desc = arrayOf("Baby", "janu", "sona", "okay","Baby", "janu", "sona", "okay")

        val img = findViewById<ImageView>(R.id.image)
        val nm = findViewById<TextView>(R.id.name)
        val rl = findViewById<TextView>(R.id.real)
        val ds = findViewById<TextView>(R.id.desc)
        val btn = findViewById<Button>(R.id.button)
        val i = intent
        val index: Int = i.getIntExtra("index", 0)



        img.setImageResource(images[index])
        nm.text = name[index]
        rl.text = real[index]
        ds.text = desc[index]




        btn.setOnClickListener {
            val intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
        }


    }
}

