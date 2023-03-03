package com.example.project_go

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mcPic = findViewById<ImageView>(R.id.macdonalds_image)//finding an image
        val enterbtn = findViewById<Button>(R.id.buttonENTER)//create find of button
        val rotateMacImage = AnimationUtils.loadAnimation(applicationContext,R.anim.rotate)//the method of rotating
        mcPic.startAnimation(rotateMacImage)//activating

        enterbtn.setOnClickListener {//use of the clicker with listener
            val newIntent = Intent(this, MenuActivity::class.java)
            startActivity(newIntent)
        }
    }


}