package com.tutorials180.classprojecte5.ProjectObjects

import java.io.Serializable

class Employee(name:String,id:Int):Serializable
{
    private var eName=name
    private var eId=id

    fun getEName():String
    {
        return eName
    }

    fun getEId():Int
    {
        return eId
    }
}