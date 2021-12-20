package com.tutorials180.classprojecte5.SimpleRoomImplementation

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Teacher(@PrimaryKey(autoGenerate = true) val id:Int, val teacherName:String){

    constructor(n:String):this(0,n)
}
