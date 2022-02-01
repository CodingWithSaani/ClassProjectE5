package com.tutorials180.classprojecte5.FirebaseWorking.FbAuth

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.tutorials180.classprojecte5.R
import com.tutorials180.classprojecte5.databinding.ActivityFbAuthBinding
import java.lang.Exception

class FbAuthActivity : AppCompatActivity()
{
    private lateinit var mFirebaseAuth : FirebaseAuth
    private lateinit var mFbAuthBinder : ActivityFbAuthBinding

    private lateinit var mProgressDialog: ProgressDialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mFbAuthBinder = ActivityFbAuthBinding.inflate(layoutInflater)
        setContentView(mFbAuthBinder.root)

        mFirebaseAuth = Firebase.auth
        mProgressDialog = ProgressDialog(this)

        mProgressDialog.setTitle("Network Call")
        mProgressDialog.setMessage("Please wait..")

        mProgressDialog.setCancelable(false)

        mFbAuthBinder.fbAuthSignUpBtn.setOnClickListener {
            signUpUser()
        }

        mFbAuthBinder.fbAuthSignInBtn.setOnClickListener {
            signInUser()
        }

        mFbAuthBinder.fbAuthSignOutBtn.setOnClickListener {
            signOutUser()
        }
    }

    private fun signOutUser() {
        try
        {
            val currentUser = FirebaseAuth.getInstance().currentUser
            if(currentUser!=null)
            {
                FirebaseAuth.getInstance().signOut()
                Toast.makeText(applicationContext, "User is logged out", Toast.LENGTH_SHORT).show();
            }
            else
            {
                Toast.makeText(applicationContext, "No User is logged in yet", Toast.LENGTH_SHORT).show();
            }
        }
        catch (ex:Exception)
        {
            Toast.makeText(applicationContext, "${ex.message}", Toast.LENGTH_SHORT).show();
        }
    }

    private fun signInUser() {
        try
        {
            if(
                mFbAuthBinder.fbAuthEmailEt.text.isNotBlank()
                && mFbAuthBinder.fbAuthPasswordEt.text.isNotBlank()
            )
            {
                mProgressDialog.show()
                mFirebaseAuth.signInWithEmailAndPassword(
                    mFbAuthBinder.fbAuthEmailEt.text.toString(),
                    mFbAuthBinder.fbAuthPasswordEt.text.toString()
                )
                    .addOnCompleteListener {
                        mProgressDialog.dismiss()
                        if(it.isSuccessful)
                        {
                            Toast.makeText(applicationContext, "User is logged in", Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            Toast.makeText(applicationContext, "${it.exception?.message}", Toast.LENGTH_SHORT).show();
                        }
                    }
            }
            else
            {
                Toast.makeText(applicationContext, "Please fill the empty fields", Toast.LENGTH_SHORT).show();
            }
        }
        catch (ex:Exception)
        {
            mProgressDialog.dismiss()
            Toast.makeText(applicationContext, "${ex.message}", Toast.LENGTH_SHORT).show();
        }
    }

    private fun signUpUser() {
        try
        {
            if(mFbAuthBinder.fbAuthEmailEt.text.isNotBlank()
                && mFbAuthBinder.fbAuthPasswordEt.text.isNotBlank())
            {
                mProgressDialog.show()
                mFirebaseAuth.createUserWithEmailAndPassword(
                    mFbAuthBinder.fbAuthEmailEt.text.toString(),
                    mFbAuthBinder.fbAuthPasswordEt.text.toString()
                )
                    .addOnCompleteListener {
                        mProgressDialog.dismiss()
                        if(it.isSuccessful)
                        {
                            Toast.makeText(applicationContext, "User is registered", Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            Toast.makeText(applicationContext, "${it.exception?.message}", Toast.LENGTH_SHORT).show();
                        }
                    }
            }
            else
            {
                Toast.makeText(applicationContext, "Some fields are empty", Toast.LENGTH_SHORT).show();
            }
        }
        catch (ex:Exception)
        {
            mProgressDialog.dismiss()
            Toast.makeText(applicationContext, "${ex.message}", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onStop() {
        super.onStop()
        val currentUser = FirebaseAuth.getInstance().currentUser
        if(currentUser!=null)
        {
            FirebaseAuth.getInstance().signOut()
            Toast.makeText(applicationContext, "User is logged out", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(applicationContext, "No User is logged in yet", Toast.LENGTH_SHORT).show();
        }
    }

}