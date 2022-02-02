package com.tutorials180.classprojecte5.BroadCastReceivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.wifi.WifiManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tutorials180.classprojecte5.R
import com.tutorials180.classprojecte5.databinding.ActivityBroadCastWorkingBinding

class BroadCastWorkingActivity : AppCompatActivity()
{
    private lateinit var mBCRBinder : ActivityBroadCastWorkingBinding
//    private lateinit var mWifiManager: WifiManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBCRBinder = ActivityBroadCastWorkingBinding.inflate(layoutInflater)

//        mWifiManager = applicationContext.getSystemService(Context.WIFI_SERVICE) as WifiManager
//        mWifiManager.isWifiEnabled = false
        setContentView(mBCRBinder.root)
    }

    private val wifiStateReceiver = object : BroadcastReceiver() {
        override fun onReceive(p0: Context?, intent: Intent?) {
            when (intent?.getIntExtra(WifiManager.EXTRA_WIFI_STATE,WifiManager.WIFI_STATE_UNKNOWN))
            {
                WifiManager.WIFI_STATE_ENABLED ->
                {
                    mBCRBinder.swWifiStatusTv.text = "Wifi Enabled"
                }
                WifiManager.WIFI_STATE_DISABLED ->
                {
                    mBCRBinder.swWifiStatusTv.text = "Wifi Disabled"
                }
                else ->
                {
                    mBCRBinder.swWifiStatusTv.text = "Wifi State Unknown"
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        registerReceiver(wifiStateReceiver, IntentFilter(WifiManager.WIFI_STATE_CHANGED_ACTION))
    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(wifiStateReceiver)
    }
}








