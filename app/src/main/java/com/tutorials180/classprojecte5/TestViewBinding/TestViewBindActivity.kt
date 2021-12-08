package com.tutorials180.classprojecte5.TestViewBinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tutorials180.classprojecte5.R
import com.tutorials180.classprojecte5.databinding.ActivityTestViewBindBinding

class TestViewBindActivity : AppCompatActivity() {

    private lateinit var objTestViewBindActivity: ActivityTestViewBindBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        objTestViewBindActivity= ActivityTestViewBindBinding.inflate(layoutInflater)
        setContentView(objTestViewBindActivity.root)

        objTestViewBindActivity.testBtn.setOnClickListener {  }
    }
}