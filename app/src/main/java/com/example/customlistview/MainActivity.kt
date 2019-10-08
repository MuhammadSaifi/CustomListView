package com.example.customlistview

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.custom_list.view.*

class MainActivity : AppCompatActivity() {
    val language=arrayOf<String>("C","C++","Kotlin","Java","Android","Python","Php")
    val description=arrayOf<String>("C language","C++ Language","Koltin Landuage","Java Language","Android Language"
    ,"Python Language","Php Language")
    val image=arrayOf<Int>(R.drawable.ic_launcher_background,R.drawable.ic_launcher_background,R.drawable.ic_launcher_background
    ,R.drawable.ic_launcher_background,R.drawable.ic_launcher_background,R.drawable.ic_launcher_background,R.drawable.ic_launcher_background)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        listView.adapter=MyListAdapter(this,language,description,image)
        listView.setOnItemClickListener(){adapterView, view, position, id ->
            val itemAtPos = adapterView.getItemAtPosition(position)
            val itemIdAtPos = adapterView.getItemIdAtPosition(position)
            Toast.makeText(this, "Click on item at $itemAtPos its item id $itemIdAtPos", Toast.LENGTH_LONG).show()
        }
    }
    class MyListAdapter(private val context:Activity,private val t:Array<String>,private val d:Array<String>,val img:Array<Int>):
            ArrayAdapter<String>(context,R.layout.custom_list,t){
        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
            val inflater = context.layoutInflater
            val rowView = inflater.inflate(R.layout.custom_list, null, true)

         //   val titleText = row.findViewById(R.id.title) as TextView
           // val imageView = row.findViewById(R.id.icon) as ImageView
            //val subtitleText = row.findViewById(R.id.desc) as TextView

            rowView.textView.text=t[position]
            rowView.desc.text=d[position]
            rowView.imageView.setImageResource(img[position])
            return rowView
        }

    }
}
