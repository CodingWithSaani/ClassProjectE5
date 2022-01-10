package com.tutorials180.classprojecte5.LocationWorking

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.Geocoder
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telephony.SmsManager
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.tutorials180.classprojecte5.R
import com.tutorials180.classprojecte5.databinding.ActivityLocationWorkingBinding
import java.util.*

class LocationWorkingActivity : AppCompatActivity() , LocationListener
{
    private lateinit var mLocationWorkingActivityBinding:ActivityLocationWorkingBinding  //Declare
    private lateinit var mLocationManager:LocationManager  //Declare

    private lateinit var mGeoCoder:Geocoder     //Declare
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        mLocationWorkingActivityBinding=ActivityLocationWorkingBinding.inflate(layoutInflater)  //Initialize
        setContentView(mLocationWorkingActivityBinding.root)

        mLocationManager=getSystemService(Context.LOCATION_SERVICE) as LocationManager  //Initialize
        mGeoCoder= Geocoder(LocationWorkingActivity@this, Locale.getDefault())
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

        performReverseGeoCoding(location.latitude,location.longitude)
    }

    private fun performReverseGeoCoding(latitude: Double, longitude: Double)
    {
        val addressDetails=mGeoCoder.getFromLocation(latitude,longitude,1)
        var address =addressDetails[0].getAddressLine(0)

        var town=addressDetails[0].subLocality
        var city=addressDetails[0].locality

        var province=addressDetails[0].adminArea
        var zipCode=addressDetails[0].postalCode

        var country=addressDetails[0].countryName
    }

    private fun sendMyOwnMessage()
    {
        val mSmsManager=SmsManager.getDefault()
        mSmsManager.sendTextMessage("00923026711633",
            null,"My Message",null,null)
    }





}