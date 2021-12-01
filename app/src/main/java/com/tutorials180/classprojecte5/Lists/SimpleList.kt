package com.tutorials180.classprojecte5.Lists

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import com.tutorials180.classprojecte5.R

class SimpleList : AppCompatActivity() {

    var ourNameList=arrayOf("Safi","Safi","Safi","Safi","Safi","Safi","Safi","Safi",
        "Safi","Safi","Safi","Safi","Safi",
        "Safi","Safi","Safi","Safi","Safi",
        "Safi","Safi","Safi","Safi",
        "Safi")

    lateinit var nameListView:ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple_list)

        nameListView=findViewById(R.id.name_list_view)
        var ourArrayAdapter=ArrayAdapter<String>(this,
        android.R.layout.simple_list_item_1,ourNameList)

        nameListView.adapter=ourArrayAdapter
    }
}