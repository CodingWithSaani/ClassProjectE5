package com.tutorials180.classprojecte5.SimpleRoomImplementation

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface StudentDAO
{
    @Insert
    fun addStudent(currentStudent:Student):Long

    @Query("select * from StudentNamesTable")
    fun getAllStudents():List<Student>

    /*
    val currentStudent=Student(1,"Farrukh Ehsan")
    addStudent(currentStudent)
     */
}