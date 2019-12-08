package com.example.projekt

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.View
import android.widget.DatePicker
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import kotlinx.android.synthetic.main.activity_add_event.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.events.*
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.*

class AddEvent : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
         lateinit var db:Database
        super.onCreate(savedInstanceState)
        setContentView(R.layout.events)
        setSupportActionBar(toolbar)
        db = Database(this)
        BTN_ADD.setOnClickListener{
            val event = Event(
                "",
                eventTitle.text.toString(),/*getText(event_prio.checkedRadioButtonId).toString()*/
                (when(event_prio.checkedRadioButtonId){

                    R.id.chkLow -> "Niski"
                   R.id.chkMedium -> "Średni"
                    R.id.chkHigh -> "Wysoki"
                    else -> "brak priorytetu"
                }),
                 eventDescription.text.toString(),
                dateevent.text.toString()
            )
            if (event.desc == null  || event.title == null ||event.dateeve== null ){
                Toast.makeText(applicationContext,"Proszę uzupełnić wszystkie pola",Toast.LENGTH_SHORT).show()
            }
            else {

                db.add_event(event)
                finish()
            }

        }
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)
calendar.setOnClickListener{
    val dpd = DatePickerDialog(this,DatePickerDialog.OnDateSetListener{ _: DatePicker?, Myear: Int, Mmonth: Int, dayOfMonth: Int ->
       dateevent.setText(""+dayOfMonth+"/"+""+ (Mmonth+1) +"/"+ Myear)}, year, month , day)
    dpd.show()
}
//        fab.setOnClickListener { view ->
//            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                    .setAction("Action", null).show()
//        }
    }

}
