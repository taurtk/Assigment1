package com.example.assigment1

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.ActionBarContextView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import java.text.FieldPosition

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dat = arrayOf("ant man", "barton", "black panther", "black widow", "captain america", "captain marvel", "hulk")
        var dat1 = arrayOf("Robert Downey Jr. " , "Chris Evans" , "Chris Hensforth" , "Mark Ruffalow" , "Scarlet johnson" ,"Hawk eye" , "Scott lang" , "Elizabeth")

        val images=arrayOf(R.drawable.ant_man,R.drawable.barton,R.drawable.black_panther,R.drawable.black_widow,R.drawable.captain_america,R.drawable.captain_marvel,R.drawable.hulk)
        val avenger = findViewById<ListView>(R.id.listview)

        avenger.adapter = MyAdapter(this,dat,dat1,images)
        avenger.setOnItemClickListener { parent, view, position, id ->
            Toast.makeText(applicationContext,dat[position],Toast.LENGTH_LONG).show()

            val intent= Intent(applicationContext,Main2Activity::class.java)

            intent.putExtra("index",position)
            startActivity(intent)
        }


    }

    class MyAdapter(context: Context,dat:Array<String>,dat1:Array<String>,images:Array<Int>) : BaseAdapter() {
        private val mContex: Context
        private val dat:Array<String>
        private val dat1:Array<String>
        private val images:Array<Int>

        init {
            mContex =context
            this.dat=dat
            this.dat1=dat1
            this.images=images
        }

        override fun getView(position: Int, contextView: View?, parent: ViewGroup?): View {
            val layout:LayoutInflater=mContex.getSystemService(Context.LAYOUT_INFLATER_SERVICE)as LayoutInflater
            val rootView=layout.inflate(R.layout.album,null,true)
            val im=rootView.findViewById<ImageView>(R.id.icon)
            val txt=rootView.findViewById<TextView>(R.id.title)
            val subtext=rootView.findViewById<TextView>(R.id.subtitle)
            im.setImageResource(images[position])
            txt.text=dat[position]
            subtext.text=dat1[position]
            return rootView
        }

        override fun getItem(position: Int): Any {
            return "Anything"
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            return dat.size
        }
    }
}