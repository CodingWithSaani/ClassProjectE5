package com.tutorials180.classprojecte5.FirebaseWorking.FbAuth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.tutorials180.classprojecte5.R

class FbAuthActivity : AppCompatActivity()
{
    private lateinit var mFirebaseAuth : FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fb_auth)

        mFirebaseAuth = Firebase.auth
    }
}