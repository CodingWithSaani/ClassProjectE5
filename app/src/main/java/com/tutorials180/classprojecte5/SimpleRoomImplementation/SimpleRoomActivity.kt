package com.tutorials180.classprojecte5.SimpleRoomImplementation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.tutorials180.classprojecte5.R
import com.tutorials180.classprojecte5.databinding.ActivitySimpleRoomBinding
import java.lang.Exception

class SimpleRoomActivity : AppCompatActivity()
{
    private lateinit var objSimpleRoomBinding:ActivitySimpleRoomBinding
    private lateinit var objStudentDb:StudentDb

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        objSimpleRoomBinding= ActivitySimpleRoomBinding.inflate(layoutInflater)
        setContentView(objSimpleRoomBinding.root)

        createStudentDb()
        objSimpleRoomBinding.stdSaveBtn.setOnClickListener { addStudent() }

        objSimpleRoomBinding.stdGetBtn.setOnClickListener { getAllStudents() }
    }

    private fun getAllStudents()
    {
        try
        {
            val studentsList=objStudentDb.getStudentDaoObject().getAllStudents()

            if(studentsList.isNotEmpty()) {
                val objCustomRVAdapter = CustomRVAdapter(studentsList)
                objSimpleRoomBinding.studentRoomRv.layoutManager=LinearLayoutManager(this)

                objSimpleRoomBinding.studentRoomRv.adapter=objCustomRVAdapter
            }
            else
            {
                Toast.makeText(applicationContext,"No student record found",Toast.LENGTH_LONG).show()
            }


        }
        catch (ex:Exception)
        {
            Toast.makeText(applicationContext,ex.message,Toast.LENGTH_LONG).show()
        }
    }

    private fun addStudent()
    {
        try
        {
            if(objSimpleRoomBinding.stdNameEt.text.toString().isNotBlank()
                && objSimpleRoomBinding.stdIdEt.text.toString().isNotBlank())
            {
                val singleStudent=Student(objSimpleRoomBinding.stdIdEt.text.toString().toInt(),
                objSimpleRoomBinding.stdNameEt.text.toString())

                val checkQuery=objStudentDb.getStudentDaoObject().addStudent(singleStudent)
                if(checkQuery!=0L)
                {
                    Toast.makeText(applicationContext,"Student Added",Toast.LENGTH_LONG).show()
                }
                else
                {
                    Toast.makeText(applicationContext,"Student Not Added",Toast.LENGTH_LONG).show()
                }
            }
            else
            {
                Toast.makeText(applicationContext,"Some fileds are left empty",Toast.LENGTH_LONG).show()
            }
        }
        catch (ex:Exception)
        {
            Toast.makeText(applicationContext,ex.message,Toast.LENGTH_LONG).show()
        }
    }

    private fun createStudentDb()
    {
        try
        {
            objStudentDb= Room.databaseBuilder(applicationContext,StudentDb::class.java,"StudentDb")
                .allowMainThreadQueries().build()
        }
        catch (ex:Exception)
        {
            Toast.makeText(applicationContext,ex.message,Toast.LENGTH_LONG).show()
        }
    }
}