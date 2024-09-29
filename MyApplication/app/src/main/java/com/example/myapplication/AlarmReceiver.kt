package com.example.myapplication

import android.Manifest
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.pm.PackageManager
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat
import java.time.LocalDateTime

class AlarmReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val message = intent?.getStringExtra("EXTRA_MESSAGE") ?: return
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()


        // Create the notification channel and send the notification
        createNotificationChannel(context)
        sendNotification(context, message)

        // Get the interval from the intent extras or set a default value
        val intervalSeconds = intent.getLongExtra("INTERVAL_SECONDS", 0L)
        var time = LocalDateTime.now().plusSeconds(intervalSeconds)
        while(true){
            time = time.plusSeconds(intervalSeconds)
        }
        // Reschedule the alarm

    }

    private fun createNotificationChannel(context: Context?) {
        // Implementation of creating a notification channel
    }

    private fun sendNotification(context: Context?, message: String) {
        // Implementation of sending a notification
    }
}


    private fun createNotificationChannel(context: Context?) {
        // Implementation of creating a notification channel
    }

    private fun sendNotification(context: Context?, message: String) {
        // Implementation of sending a notification
    }

