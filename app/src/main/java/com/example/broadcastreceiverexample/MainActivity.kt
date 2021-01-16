package com.example.broadcastreceiverexample

import android.Manifest
import android.content.IntentFilter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private val orderedReceiver1 = OrderedReceiver1()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val filter = IntentFilter("com.example.broadcastreceiverexample.ACTION_EXAMPLE")
        filter.priority = 1
        registerReceiver(orderedReceiver1, filter, Manifest.permission.VIBRATE, null)
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(orderedReceiver1)
    }
}