package com.example.projekt

import android.app.DatePickerDialog
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_add_event.*
import kotlinx.android.synthetic.main.edit.*
import android.content.Intent
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.widget.DatePicker
import android.widget.Toast
import kotlinx.android.synthetic.main.edit.dateevent
import kotlinx.android.synthetic.main.edit.eventDescription
import kotlinx.android.synthetic.main.edit.eventTitle
import kotlinx.android.synthetic.main.edit.event_prio
import kotlinx.android.synthetic.main.events.*
import kotlinx.android.synthetic.main.tasks.*
import java.util.*


class EditEvent : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        lateinit var db:Database
        db = Database(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.edit)
        val intent = intent
        val id = intent.getStringExtra("id")
        val title = intent.getStringExtra("title")
        val desc = intent.getStringExtra("desc")
        val prio = intent.getStringExtra("prio")
        val dateeve = intent.getStringExtra("dateeve")
        val status = intent.getStringExtra("status")
        when(prio){
            "Niski"-> event_prio.check(R.id.chkLow)
            "Średni"-> event_prio.check(R.id.chkMedium)
            else -> event_prio.check(R.id.chkHigh)
        }
        when(status){
            "Rozpoczęte"-> eventStat.check(R.id.chkstart)
            else ->eventStat.check(R.id.chkehd)
        }
        eventTitle.setText(title)
        eventDescription.setText(desc)
      dateevent.setText(dateeve)
        BTN_EDYT.setOnClickListener{
            val event = Event(
                "",
                eventTitle.text.toString(),
                (when(event_prio.checkedRadioButtonId){

                    R.id.chkLow -> "Niski"
                    R.id.chkMedium -> "Średni"
                    R.id.chkHigh -> "Wysoki"
                    else -> "brak priorytetu"
                }),
                eventDescription.text.toString(),
                dateevent.text.toString(),when(eventStat.checkedRadioButtonId){
                    R.id.chkstart -> "Rozpoczęte"
                    R.id.chkehd -> "Skończone"
                    else -> "Brak statusu"
                }

            )
            if (event.desc == null  || event.title == null ||event.dateeve== null ){
                Toast.makeText(applicationContext,"Proszę uzupełnić wszystkie pola", Toast.LENGTH_SHORT).show()
            }
            else {
                db.update_event(event,id)
                finish()
            }
        }

        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)
       calendaredit.setOnClickListener{
            val dpd = DatePickerDialog(this,DatePickerDialog.OnDateSetListener{ _: DatePicker?, Myear: Int, Mmonth: Int, dayOfMonth: Int ->
                dateevent.setText(""+Myear+"-"+""+ (Mmonth+1) +"-"+ dayOfMonth)}, year, month , day)
            dpd.show()
        }


    }}