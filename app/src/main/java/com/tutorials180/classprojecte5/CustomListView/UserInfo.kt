package com.tutorials180.classprojecte5.CustomListView

class UserInfo (name:String,image:Int) {

    private var userName=name
    private var userImage=image

    fun getUserName():String
    {
        return userName
    }

    fun getUserImage():Int
    {
        return userImage
    }
}