package com.example.broadcastreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class CustomReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        val intentAction = intent.action

        if (intentAction != null) {
            var toastMessage = "unknown intent action"
            when (intentAction) {
                Intent.ACTION_POWER_CONNECTED -> toastMessage = "Power connected!"
                Intent.ACTION_POWER_DISCONNECTED -> toastMessage = "Power disconnected!"
                ACTION_CUSTOM_BROADCAST -> toastMessage = "Custom Broadcast Received"
            }
            val number = intent.extras?.get("number") as Int?
            if(number != null) {
                val squaredNumber = number?.times(number)
                val numberText = "\nSquare of the Random number: ${squaredNumber!!}"
                toastMessage += numberText
            }
            Toast.makeText(context, toastMessage, Toast.LENGTH_SHORT).show()
        }
    }
}