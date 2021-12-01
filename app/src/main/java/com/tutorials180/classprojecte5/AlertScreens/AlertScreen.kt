package com.tutorials180.classprojecte5.AlertScreens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.tutorials180.classprojecte5.R
import java.lang.Exception

class AlertScreen : AppCompatActivity() {

    private lateinit var alertDialogBuilder:AlertDialog.Builder
    private lateinit var alertDialog:AlertDialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alert_screen)

        createAlertDialog()
    }

    private fun createAlertDialog()
    {
        try
        {
            alertDialogBuilder=AlertDialog.Builder(AlertScreen@this)
            alertDialogBuilder.setTitle("Test Title")

            alertDialogBuilder.setMessage("Test Alert Dialog Message")
            alertDialogBuilder.setPositiveButton("Close")
            {d,id->
                alertDialog.dismiss()
            }

            alertDialog=alertDialogBuilder.create()
            alertDialog.show()


        }
        catch (ex:Exception)
        {
            Toast.makeText(AlertScreen@this,ex.message,Toast.LENGTH_LONG).show()
        }
    }












}