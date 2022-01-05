package com.tutorials180.classprojecte5.LocationWorking

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.tutorials180.classprojecte5.R
import com.tutorials180.classprojecte5.databinding.ActivityLocationWorkingBinding

class LocationWorkingActivity : AppCompatActivity() , LocationListener
{
    private lateinit var mLocationWorkingActivityBinding:ActivityLocationWorkingBinding  //Declare
    private lateinit var mLocationManager:LocationManager  //Declare

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        mLocationWorkingActivityBinding=ActivityLocationWorkingBinding.inflate(layoutInflater)  //Initialize
        setContentView(mLocationWorkingActivityBinding.root)

        mLocationManager=getSystemService(Context.LOCATION_SERVICE) as LocationManager  //Initialize
        mLocationWorkingActivityBinding.lwGetLatLngBtn.setOnClickListener { getDeviceLocation() }
    }

    private fun getDeviceLocation()
    {
        try
        {
            if (ActivityCompat.checkSelfPermission(this,Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                &&
                ActivityCompat.checkSelfPermission(this,Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED)
                {
                    ActivityCompat.requestPermissions(LocationWorkingActivity@this,arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),100)
                }
            else
            {
                mLocationManager.requestLocationUpdates(
                    LocationManager.GPS_PROVIDER,
                    5000,
                    5.0f,
                    this
                )
            }
        }
        catch (ex:Exception)
        {
            Toast.makeText(applicationContext,ex.message,Toast.LENGTH_LONG).show()
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int,permissions: Array<out String>,grantResults: IntArray)
    {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode==100)
        {
            if(grantResults.isNotEmpty() && grantResults[0]==PackageManager.PERMISSION_GRANTED)
            {
                Toast.makeText(applicationContext,"Permission Granted",Toast.LENGTH_LONG).show()
            }
            else
            {
                Toast.makeText(applicationContext,"Permission Not Granted",Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onLocationChanged(location: Location)
    {
        mLocationWorkingActivityBinding.lwLatTv.text="Latitude:"+location.latitude.toString()
        mLocationWorkingActivityBinding.lwLngTv.text="Longtitud:"+location.longitude.toString()
    }














}