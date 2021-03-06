package com.example.broadcastreceiverexample

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class OrderedReceiver1 : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        var resultCode = resultCode
        var resultData = resultData
        var resultExtras = getResultExtras(true)
        var stringExtra = resultExtras.getString("stringExtra")

        resultCode++
        stringExtra += "-> OrderedReceiver1"

        val toastText =
            "\"OrderedReceiver1 \n resultCode: $resultCode \n resultData: $resultData \n stringExtra: $stringExtra"

        Toast.makeText(context, toastText, Toast.LENGTH_LONG).show()

        resultData = "OrderedReceiver1"
        resultExtras.putString("stringExtra", stringExtra)

        setResult(resultCode, resultData, resultExtras)

    }
}