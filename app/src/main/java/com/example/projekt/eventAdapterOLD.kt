/*
package com.example.projekt

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.icu.text.CaseMap
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import kotlinx.android.synthetic.main.events.view.*
import kotlinx.android.synthetic.main.tasks.view.*

class eventAdapterOLD (internal var activity: Activity,
                                internal var llstEvent: List<Event>,
                                internal var prio: RadioGroup,
 internal var status: EditText,

 internal var data: TextView,

                                internal var title: EditText,
                                internal var eventDescription: EditText):BaseAdapter() {

    internal var inflater:LayoutInflater
    init {
        inflater = activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val rowView: View
        rowView = inflater.inflate(R.layout.tasks,null)
       // rowView.id.text = llstEvent[position].id.toString()
        rowView.prio.text = llstEvent[position].prio.toString()
        rowView.status.text = llstEvent[position].status.toString()
        rowView.title.text=llstEvent[position].title.toString()
rowView.eventDescription.text=llstEvent[position].desc.toString(
)
        rowView.data.text=llstEvent[position].date.toString()
        rowView.setOnClickListener{
        prio.setText(rowView.prio.text.toString())

      prio.checkedRadioButtonId.and()

 status.setText(rowView.status.text.toString())

            title.setText(rowView.title.text.toString())
            */
/*prio.setText(rowView.prio.toString())*//*

 eventDescription.setText(rowView.title.text.toString())

     data.setText(rowView.data.text.toString())

        }
        return rowView
    }

    override fun getItem(position: Int): Any {
        return llstEvent[position]
    }

    override fun getItemId(position: Int): Long {
        return llstEvent[position].id!!.toLong()
    }

    override fun getCount(): Int {
        return llstEvent.size
    }
}
*/
