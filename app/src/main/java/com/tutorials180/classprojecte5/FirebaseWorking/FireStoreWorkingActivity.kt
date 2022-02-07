package com.tutorials180.classprojecte5.FirebaseWorking

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import com.tutorials180.classprojecte5.FirebaseWorking.Objects.Employee
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

        //mFireStore = Firebase.firestore

        mFSWBinder.fsWorkingAddSingleDocBtn.setOnClickListener { addSingleDocument() }
        mFSWBinder.fsWorkingAddSingleDocWithModelBtn.setOnClickListener {
            addSingleDocumentWithClassModel()
        }

        mFSWBinder.fsWorkingGetSingleDocWithModelBtn.setOnClickListener {
            getSingleDocumentWithID()
        }

        mFSWBinder.fsWorkingGetDocsWithModelBtn.setOnClickListener {
            getAllDocuments()
        }
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

    private fun addSingleDocumentWithClassModel()
    {
        try
        {
           if(mFSWBinder.fsWorkingEmpNameEt.text.isNotBlank()
               && mFSWBinder.fsWorkingEmpSalaryEt.text.isNotBlank()
               && mFSWBinder.fsWorkingEmpDesEt.text.isNotBlank()
           )
           {
               val currentEmp=Employee(mFSWBinder.fsWorkingEmpNameEt.text.toString(),
               mFSWBinder.fsWorkingEmpSalaryEt.text.toString().toInt(),
                   mFSWBinder.fsWorkingEmpDesEt.text.toString()
                   )

               mFireStore.collection("Employee")
                   .document("newEmploye1")
                   .set(currentEmp)
                   .addOnSuccessListener {_:Void? ->
                       Toast.makeText(applicationContext,"Data Added",Toast.LENGTH_SHORT).show()
                   }
                   .addOnFailureListener { fireStoreEx->
                       Toast.makeText(applicationContext,"Ex:${fireStoreEx.message}",Toast.LENGTH_SHORT).show()
                   }

           }
            else
           {
               Toast.makeText(applicationContext,"Some fields are empty",Toast.LENGTH_SHORT).show()
           }
        }
        catch (ex:Exception)
        {
            Toast.makeText(applicationContext,ex.message,Toast.LENGTH_SHORT).show()
        }
    }

    private fun getSingleDocumentWithID()
    {
        try
        {
            mFireStore.collection("Employee")
                .document("newEmploye")
                .get()
                .addOnSuccessListener { doc->
                    if(doc.exists())
                    {
                        val currentEmp = doc.toObject<Employee>()
                        Toast.makeText(applicationContext, "Name :${currentEmp?.empName}" +
                                ", Salary : ${currentEmp?.empSalary.toString()}," +
                                " Designation : ${currentEmp?.empDesignation} ", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(applicationContext, "No doc with this id exits", Toast.LENGTH_SHORT).show();
                    }
                }
                .addOnFailureListener {ex->
                    Toast.makeText(applicationContext, "Exception while getting data:${ex.message}", Toast.LENGTH_SHORT).show();
                }
        }
        catch(ex:Exception)
        {
            Toast.makeText(applicationContext, "Exception:${ex.message}", Toast.LENGTH_SHORT).show();
        }
    }

    private fun getAllDocuments()
    {
        try
        {
            mFireStore.collection("Employee")
                .get()
                .addOnSuccessListener { docs->
                    if(docs.isEmpty)
                    {
                        Toast.makeText(applicationContext, "DataSet is empty", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        var listOfEmps = ArrayList<Employee>()
                        for (doc in docs)
                        {
                            val currentEmp = doc.toObject<Employee>()
//                            Toast.makeText(applicationContext, "Name :${currentEmp?.empName}" +
//                                    ", Salary : ${currentEmp?.empSalary.toString()}," +
//                                    " Designation : ${currentEmp?.empDesignation} ", Toast.LENGTH_SHORT).show();

                            listOfEmps.add(currentEmp)
                        }

                        mFSWBinder.fbWorkingRv.layoutManager = LinearLayoutManager(applicationContext)
                        mFSWBinder.fbWorkingRv.adapter = CustomRVFBAdapter(listOfEmps)
                    }

                }
                .addOnFailureListener {ex->
                    Toast.makeText(applicationContext, "Exception while getting data:${ex.message}", Toast.LENGTH_SHORT).show();

                }
        }
        catch (ex:Exception)
        {
            Toast.makeText(applicationContext, "Exception:${ex.message}", Toast.LENGTH_SHORT).show();
        }
    }















}