package com.example.broadcastreceiverexample

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast
import android.os.Handler
import android.os.SystemClock

class OrderedReceiver2 : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        val handler = Handler()

        val pendingResult = goAsync()

        Thread(object : Runnable {
            override fun run() {

                SystemClock.sleep(10 * 1000)

                var resultCode = pendingResult.resultCode
                var resultData = pendingResult.resultData
                val resultExtras = pendingResult.getResultExtras(true)
                var stringExtra = resultExtras.getString("stringExtra")

                resultCode++
                stringExtra += "-> OrderedReceiver2"

                val toastText =
                    "\"OrderedReceiver2 \n resultCode: $resultCode \n resultData: $resultData \n stringExtra: $stringExtra"

                handler.post(object : Runnable {
                    override fun run() {
                        Toast.makeText(context, toastText, Toast.LENGTH_LONG).show()
                    }
                })

                resultData = "OrderedReceiver2"
                resultExtras.putString("stringExtra", stringExtra)

                pendingResult.setResult(resultCode, resultData, resultExtras)
                pendingResult.finish()
            }
        }).start()


    }
}