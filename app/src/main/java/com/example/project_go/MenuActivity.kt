package com.example.project_go

import android.os.Bundle
import android.view.View
import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.widget.Button
import android.widget.TextView

class MenuActivity :  AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)


        val topaymentbtn = findViewById<Button>(R.id.buttonToPayment)//create find of button

        topaymentbtn.setOnClickListener {//use of the clicker with listener
            val paymentIntent = Intent(this, PaymentActivity::class.java)
            startActivity(paymentIntent)
        }

    }



}