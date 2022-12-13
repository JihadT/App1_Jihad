package com.example.combination

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val list1= arrayOf("Select State of Matter", "Solid", "Liquid", "Gas")
    private val list2= arrayOf("Select Temperature", "High Temp", "Low Temp")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter= object : ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list1) {
            override fun isEnabled(position: Int): Boolean
            {
                return position != 0
            }
            override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View
            {
                val view: TextView = super.getDropDownView(position, convertView, parent) as TextView
                if(position == 0)
                {
                    view.setTextColor(Color.GRAY)
                } else
                {
                    view.setTextColor(Color.BLACK)
                }
                return view
            }
        }
        val adapter2=object : ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list2){
            override fun isEnabled(position: Int): Boolean
            {
                return position != 0
            }
            override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View
            {
                val view: TextView = super.getDropDownView(position, convertView, parent) as TextView
                if(position == 0)
                {
                    view.setTextColor(Color.GRAY)
                } else
                {
                    view.setTextColor(Color.BLACK)
                }
                return view
            }
        }
        val b1 = findViewById<Button>(R.id.button)

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item)
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_item)

        spinner1.adapter=adapter
        spinner2.adapter=adapter2
        spinner1.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val value = parent!!.getItemAtPosition(position).toString()
                if(value == list1[0]){
                    (view as TextView).setTextColor(Color.GRAY)
                }
            }

        }
        spinner2.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val value = parent!!.getItemAtPosition(position).toString()
                if(value == list2[0]){
                    (view as TextView).setTextColor(Color.GRAY)
                }
            }

        }
        b1.setOnClickListener {
            if(spinner1.selectedItemPosition==1 && spinner2.selectedItemPosition==1)
            {
                textView.setText("||Melting||Solid-->Liquid||")
            }
            if(spinner1.selectedItemPosition==2 && spinner2.selectedItemPosition==1)
            {
                textView.setText("||Evaporating||Liquid-->Gas||")
            }
            if(spinner1.selectedItemPosition==3 && spinner2.selectedItemPosition==1)
            {
                textView.setText("||Rapid Gas Particles||")
            }
            if(spinner1.selectedItemPosition==1 && spinner2.selectedItemPosition==2)
            {
                textView.setText("||Frozen Solid||")
            }
            if(spinner1.selectedItemPosition==2 && spinner2.selectedItemPosition==2)
            {
                textView.setText("||Freezing||Liquid-->Solid||")
            }
            if(spinner1.selectedItemPosition==3 && spinner2.selectedItemPosition==2)
            {
                textView.setText("||Slow Gas Particles||")
            }
        }
    }
}