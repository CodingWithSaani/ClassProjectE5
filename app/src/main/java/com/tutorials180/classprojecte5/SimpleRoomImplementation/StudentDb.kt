package com.tutorials180.classprojecte5.SimpleRoomImplementation

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Student::class,Teacher::class], version = 1)
abstract class StudentDb : RoomDatabase()
{
    abstract fun getStudentDaoObject():StudentDAO
}