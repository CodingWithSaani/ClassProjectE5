package com.tutorials180.classprojecte5.CustomListView

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import com.tutorials180.classprojecte5.R

class CustomListPage : AppCompatActivity() {

    private lateinit var customArrayListViwe:ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_list_page)

        customArrayListViwe=findViewById(R.id.ca_list_view)
        var obj1=UserInfo("Test1",R.drawable.red_image)
        var obj2=UserInfo("Test1",R.drawable.red_image)

        var obj3=UserInfo("Test1",R.drawable.red_image)
        var obj4=UserInfo("Test1",R.drawable.red_image)

        var obj5=UserInfo("Test1",R.drawable.red_image)
        var obj6=UserInfo("Test1",R.drawable.red_image)

        var collectionOfUserInfo=arrayOf(obj1,obj2,obj3,obj4,obj5,obj6)
        customArrayListViwe.adapter=CustomArrayAdapter(CustomListPage@this,
        collectionOfUserInfo)


    }
}