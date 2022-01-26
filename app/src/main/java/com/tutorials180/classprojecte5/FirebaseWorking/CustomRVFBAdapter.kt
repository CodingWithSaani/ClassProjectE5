package com.tutorials180.classprojecte5.FirebaseWorking

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tutorials180.classprojecte5.FirebaseWorking.Objects.Employee
import com.tutorials180.classprojecte5.R

class CustomRVFBAdapter(val listOfEmps:ArrayList<Employee>):RecyclerView.Adapter<CustomRVFBAdapter.RVFBViewHolder>()
{

    class RVFBViewHolder(singleRow:View):RecyclerView.ViewHolder(singleRow)
    {
        var nameOfEmpTV:TextView = singleRow.findViewById(R.id.crv_fb_name_tv)
        var salaryOfEmpTV:TextView = singleRow.findViewById(R.id.crv_fb_salary_tv)

        var desOfEmpTV:TextView = singleRow.findViewById(R.id.crv_fb_des_tv)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RVFBViewHolder {
        val simpleView = LayoutInflater.from(parent.context).inflate(
            R.layout.custom_rv_fb_single_row,parent,false
        )

        return RVFBViewHolder(simpleView)
    }

    override fun onBindViewHolder(holder: RVFBViewHolder, position: Int) {
        holder.nameOfEmpTV.text = listOfEmps[position].empName
        holder.salaryOfEmpTV.text = listOfEmps[position].empSalary.toString()

        holder.desOfEmpTV.text = listOfEmps[position].empDesignation
    }

    override fun getItemCount(): Int {
        return listOfEmps.size
    }
}