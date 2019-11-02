package com.example.appfaculdade

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat.getSystemService
import android.content.Intent
import android.app.PendingIntent
import android.app.Notification


object Notificacao {
    fun mostrarNotificacao(context: Context, title: String, msg: String) {
        val not = NotificationCompat.Builder(context, "projetoapp")
            .setSmallIcon(R.drawable.ic_action_add_produto)
            .setContentTitle("projetoapp")
            .setContentText(msg)
            .setStyle(NotificationCompat.BigTextStyle().bigText(msg))
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setAutoCancel(true)

        val manager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel("projetoapp", "projetoapp", NotificationManager.IMPORTANCE_DEFAULT)
            manager.createNotificationChannel(channel)
        }

        manager.notify(535, not.build())
    }
}