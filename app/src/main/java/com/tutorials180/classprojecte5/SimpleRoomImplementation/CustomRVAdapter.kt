package com.tutorials180.classprojecte5.SimpleRoomImplementation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tutorials180.classprojecte5.R

class CustomRVAdapter(val listOfStudents:List<Student>)
    :RecyclerView.Adapter<CustomRVAdapter.CustomRVViewHolder>()
{
    class CustomRVViewHolder(studentSingleRow: View):RecyclerView.ViewHolder(studentSingleRow)
    {
        var idTV:TextView=studentSingleRow.findViewById(R.id.std_sr_id_tv)
        var nameTV:TextView=studentSingleRow.findViewById(R.id.std_sr_name_tv)
    }

    //Method 1
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomRVViewHolder
    {
        //val studentSingleRow= LayoutInflater.from(parent.context).inflate(R.layout.student_sinlge_row,parent,false)
        //val objCustomRVViewHolder=CustomRVViewHolder(studentSingleRow)
        //return objCustomRVViewHolder

        //return CustomRVViewHolder(studentSingleRow)
        return CustomRVViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.student_sinlge_row,parent,false))
    }

    //Method 2
    override fun onBindViewHolder(holder: CustomRVViewHolder, position: Int) {
        holder.idTV.text=listOfStudents[position].id.toString()
        holder.nameTV.text=listOfStudents[position].name
    }

    //Method 3
    override fun getItemCount(): Int {
        return listOfStudents.size
    }
}