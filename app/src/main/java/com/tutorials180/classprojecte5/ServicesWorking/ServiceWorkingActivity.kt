package com.tutorials180.classprojecte5.ServicesWorking

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tutorials180.classprojecte5.R
import com.tutorials180.classprojecte5.databinding.ActivityServiceWorkingBinding

class ServiceWorkingActivity : AppCompatActivity() {

    private lateinit var mSWBinder: ActivityServiceWorkingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mSWBinder = ActivityServiceWorkingBinding.inflate(layoutInflater)

        setContentView(mSWBinder.root)
        mSWBinder.swStartBtn.setOnClickListener {
            startService(Intent(this,MyMediaService::class.java))
        }

        mSWBinder.swStopBtn.setOnClickListener {
            stopService(Intent(this,MyMediaService::class.java))
        }
    }

}