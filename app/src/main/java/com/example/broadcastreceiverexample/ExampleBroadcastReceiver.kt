package com.example.broadcastreceiverexample

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.widget.Toast

class ExampleBroadcastReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {

        if(Intent.ACTION_BOOT_COMPLETED == intent?.action) {
            Toast.makeText(context, "Boot completed", Toast.LENGTH_SHORT).show()
        }

        if (ConnectivityManager.CONNECTIVITY_ACTION == intent?.action) {
            Toast.makeText(context, "Connectivity changed", Toast.LENGTH_SHORT).show()
        }
    }
}