package com.tutorials180.classprojecte5.SimpleRoomImplementation

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "StudentNamesTable")
data class Student(@PrimaryKey val id:Int,@ColumnInfo(name = "studentName") val name:String)