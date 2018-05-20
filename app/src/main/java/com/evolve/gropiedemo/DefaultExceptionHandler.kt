package com.evolve.gropiedemo

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import java.io.IOException

/**
 * Created by krishna on 5/20/18.
 */
class DefaultExceptionHandler(var context: Context): Thread.UncaughtExceptionHandler {
    override fun uncaughtException(t: Thread?, e: Throwable?) {

        try {

            val intent = Intent(context, ErrorActivity::class.java)

            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
                    or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    or Intent.FLAG_ACTIVITY_NEW_TASK)

            val pendingIntent = PendingIntent.getActivity(
                    context.applicationContext, 0, intent, intent.getFlags())

            //Following code will restart your application after 2 seconds
            val mgr = context.applicationContext
                    .getSystemService(Context.ALARM_SERVICE) as AlarmManager
            mgr.set(AlarmManager.RTC, System.currentTimeMillis() + 500,
                    pendingIntent)

            //This will finish your activity manually
            //This will stop your application and take out from it.
            android.os.Process.killProcess(android.os.Process.myPid());

        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
}