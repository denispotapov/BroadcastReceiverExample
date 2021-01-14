package com.example.broadcastreceiverexample

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class ExampleBroadcastReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {

        if ("com.example.broadcastreceiverexample.EXAMPLE_ACTION" == intent?.action) {
            val receiverText =
                intent.getStringExtra("com.example.broadcastreceiverexample.EXAMPLE_ACTION")
            Toast.makeText(context, receiverText, Toast.LENGTH_SHORT).show()
        }
    }
}