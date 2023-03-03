package com.example.project_go

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SwitchCompat
import java.util.Calendar
import java.util.Date

class PaymentActivity : AppCompatActivity() {

    var amountOfSits = 0
    var selectedDate = ""
    var vegeMenu = ""
    var selectedTime = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)
        val plusBtn = findViewById<Button>(R.id.plusSit) // date picker ----
        val minusBtn = findViewById<Button>(R.id.minusSit) // date picker ----
        val amountOfSitsTxt = findViewById<TextView>(R.id.txtNumSit)
        val switcher: SwitchCompat = findViewById(R.id.switchVegeterian)

        
        
        switcher.setOnCheckedChangeListener { _, b ->
            if(b){
                vegeMenu=  getString(R.string.vegeterian_menu)
            }
            else {
                vegeMenu = getString(R.string.regular_menu)

            }
        }
        
        //////////////////////////////////////////
        
        plusBtn.setOnClickListener {
            amountOfSits+=1
            amountOfSitsTxt.text = amountOfSits.toString()
        }

        minusBtn.setOnClickListener {
            if(amountOfSits>0) {
                amountOfSits -= 1
                amountOfSitsTxt.text = amountOfSits.toString()
            }
        }

        val timeBtn = findViewById<Button>(R.id.time_picker_actions) // date picker ----
        timeBtn.setOnClickListener {
            val calender = Calendar.getInstance()
            val listener = TimePickerDialog.OnTimeSetListener { timePicker, hour, minute ->
                selectedTime = "$hour : $minute "
                Toast.makeText(this, selectedTime, Toast.LENGTH_SHORT).show()

            }

            val timePicked = TimePickerDialog(
                this,
                listener,
                calender.get(Calendar.HOUR),
                calender.get(Calendar.MINUTE),
                false
            )

            timePicked.show()

        }


        /////////////////////
        val dateBtn = findViewById<Button>(R.id.date_picker_actions) // date picker

        dateBtn.setOnClickListener {
            val calender = Calendar.getInstance()
            val listener = DatePickerDialog.OnDateSetListener { datePicker, year, month, day ->
                selectedDate = "$day / $month / $year"
                Toast.makeText(this, selectedDate, Toast.LENGTH_SHORT).show()

            }

            val datePicked = DatePickerDialog(
                this,
                listener,
                calender.get(Calendar.YEAR),
                calender.get(Calendar.MONTH),
                calender.get(Calendar.DAY_OF_MONTH)
            )

            datePicked.datePicker.minDate = System.currentTimeMillis() - 1000 // block invalid date

            datePicked.show()

        }


        /////////////
        val reserveBtn = findViewById<Button>(R.id.reserveSits) // reserve sits button

        reserveBtn.setOnClickListener {
            val builder = AlertDialog.Builder(this)

            val dialog = builder.create()

            if(amountOfSits > 0 && selectedDate != "" && selectedTime != ""){
                dialog.setMessage(getString(R.string.print_reservation_set_date)+selectedDate+"\n"+getString(
                                    R.string.at_about_message_print)+
                selectedTime+"\n"+getString(R.string.number_of_seats_message)+amountOfSits+"\n"+getString(
                                    R.string.you_have_chosen_menu_message)+vegeMenu)//note to self - add proper dialog
            } else {
                dialog.setTitle(getString(R.string.error_message))
                dialog.setMessage(getString(R.string.missing_info_message))
            }

            dialog.show()
        }


    }


}