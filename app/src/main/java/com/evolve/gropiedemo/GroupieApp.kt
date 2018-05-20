package com.evolve.gropiedemo

import android.app.AlarmManager
import android.app.Application
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import java.io.IOException


/**
 * Created by krishna on 5/10/18.
 */
class GroupieApp : Application() {
    override fun onCreate() {
        super.onCreate()
        Thread.setDefaultUncaughtExceptionHandler(DefaultExceptionHandler(this));



    }
}