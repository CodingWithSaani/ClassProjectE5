package com.tutorials180.classprojecte5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tutorials180.classprojecte5.ProjectObjects.Employee

class SecondPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_page)

//        var nameOfReceiver=intent.getStringExtra("n-1")
//        var rollNoOfReceiver=intent.getIntExtra("rollNo",0);

        var aliObject=intent.getSerializableExtra("employeeAli") as Employee
        var nameOfSender=aliObject.getEName()

        var idOfSender=aliObject.getEId()
    }









}