package com.example.broadcastreceiverexample

import android.content.IntentFilter
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    private val exampleBroadcastReceiver = ExampleBroadcastReceiver()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        val filter = IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION)
        registerReceiver(exampleBroadcastReceiver, filter)
    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(exampleBroadcastReceiver)
    }
}