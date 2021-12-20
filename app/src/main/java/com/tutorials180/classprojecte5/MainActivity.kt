package com.tutorials180.classprojecte5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.tutorials180.classprojecte5.CustomListView.CustomListPage
import com.tutorials180.classprojecte5.ProjectObjects.Employee
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    lateinit var moveBtn:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        connector()
    }

    private fun connector()
    {
        try
        {
           moveBtn=findViewById(R.id.move_btn)
           moveBtn.setOnClickListener {
               //moveToSecondScreen()
               moveToCustomListPage()
           }

        }
        catch(exObject:Exception)
        {
            Toast.makeText(this,"Logical Error:${exObject.message}"
            ,Toast.LENGTH_LONG).show()
        }
    }

    private fun moveToSecondScreen() {
        var objectIntent=Intent(this,SecondPage::class.java)
        //Name=Hamza, RollNo=27

        //objectIntent.putExtra("n-1","Hamza")
        //objectIntent.putExtra("rollNo",27)

        //Employee objEmp=new Employee("Ali",27);
        var objEmp=Employee("Ali",27)

        objectIntent.putExtra("employeeAli",objEmp)
        startActivity(objectIntent)
    }


    private fun moveToCustomListPage()
    {
        startActivity(Intent(MainActivity@this,CustomListPage::class.java))
    }

}