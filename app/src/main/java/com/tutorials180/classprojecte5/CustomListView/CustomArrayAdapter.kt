package com.tutorials180.classprojecte5.CustomListView

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.tutorials180.classprojecte5.R

class CustomArrayAdapter (context: Context,userInfoCol:Array<UserInfo>)
    :ArrayAdapter<UserInfo>(context, R.layout.single_row,userInfoCol)
{
    private var uInfoArray=userInfoCol
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var singleRow=LayoutInflater.from(context).inflate(R.layout.single_row,null,true)

        var nameTV=singleRow.findViewById(R.id.sr_tv) as TextView
        var userIV=singleRow.findViewById(R.id.sr_iv) as ImageView

        nameTV.text=uInfoArray[position].getUserName()
        userIV.setImageResource(uInfoArray[position].getUserImage())

        return singleRow
    }
}