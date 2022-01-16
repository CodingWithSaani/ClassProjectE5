package com.tutorials180.classprojecte5.FirebaseWorking

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore
import com.tutorials180.classprojecte5.R
import com.tutorials180.classprojecte5.databinding.ActivityFireStoreWorkingBinding

class FireStoreWorkingActivity : AppCompatActivity()
{
    private lateinit var mFSWBinder:ActivityFireStoreWorkingBinding
    private lateinit var mFireStore:FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mFSWBinder=ActivityFireStoreWorkingBinding.inflate(layoutInflater)

        setContentView(mFSWBinder.root)
        mFireStore= FirebaseFirestore.getInstance()

        mFSWBinder.fsWorkingAddSingleDocBtn.setOnClickListener { addSingleDocument() }
    }

    private fun addSingleDocument()
    {
        try
        {
           var currentStudent=HashMap<String,Any>()
            currentStudent["name"] = "Hamza Ali Rahat"

            currentStudent["age"] = 20
            currentStudent["address"] = "Lahore"

           mFireStore.collection("Student")
               .add(currentStudent)
               .addOnSuccessListener {
                   Toast.makeText(applicationContext,"Data Added",Toast.LENGTH_SHORT).show()

               }
               .addOnFailureListener {
                   Toast.makeText(applicationContext,"Data Not Added",Toast.LENGTH_SHORT).show()
               }
        }
        catch (ex:Exception)
        {
            Toast.makeText(applicationContext,ex.message,Toast.LENGTH_SHORT).show()
        }
    }



















}