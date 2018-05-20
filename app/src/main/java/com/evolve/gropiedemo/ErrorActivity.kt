package com.evolve.gropiedemo

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.util.Log
import android.widget.Toast

class ErrorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_error)


    }

    companion object {
        fun start(context: Context){
            context.startActivity(Intent(context,ErrorActivity::class.java))
        }
    }


}
