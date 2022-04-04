package com.example.bmi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d( "MainActivity", "onCreate:")
        b_help.setOnClickListener {
            AlertDialog.Builder( this)
                .setTitle("BMI說明")
                .setMessage("體重(kg)/身高平方(m)")
                .setPositiveButton( "OK", null )
                .show()
        }
        val app:String = getString(R.string.app_name)
    }

    override fun onStart() {
        super.onStart()
        Log.d("MainActivity", "onStart:")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("MainActivity", "onRestart:")
    }

    override fun onResume() {
        super.onResume()
        Log.d("MainActivity", "onResume:")
    }

    override fun onPause() {
        super.onPause()
        Log.d("MainActivity", "onPause:")
    }

    override fun onStop() {
        super.onStop()
        Log.d("MainActivity", "onStop:")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("MainActivity", "onDestroy:")
    }

    fun bmi(view: View) {
        val weight = ed_weight.text.toString().toFloat()
        val height = ed_height.text.toString().toFloat()
        val bmi = weight / ( height * height )
        Log.d("BMI" , bmi.toString() )
        Intent(this, ResultActivity::class.java).apply {
            putExtra(getString(R.string.bmi_extra), bmi)
            startActivity(this)
        }

        /* or
        val intent = Intent(this, ResultActivity::class.java )
        startActivity(intent)
         */



        /*
        Toast.makeText(this, bmi.toString(), Toast.LENGTH_LONG ).show()
        AlertDialog.Builder(this)
            .setMessage(bmi.toString())
            .setTitle("Your BMI")
            .setPositiveButton("ok", null)
            .setNeutralButton("Cancel", null)
            .show()
         */
    }
}
