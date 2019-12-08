package com.example.projekt

import android.content.Context
import android.content.Intent
import android.icu.text.CaseMap
import android.os.Parcel
import android.os.Parcelable
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.annotation.MainThread
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.tasks.view.*

class eventAdapter(context: Context, var llstEvent: List<Event>): RecyclerView.Adapter<eventAdapter.ViewHolder>() {

    val context = context
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title = itemView.title
        val status = itemView.status
        val prio = itemView.prio
        val data = itemView.data
        val id = itemView.idHolder
        val dateeve = itemView.dateev
        val button = itemView.BTN_DEL

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.tasks,parent,false)
        return ViewHolder(v)

    }

    override fun getItemCount(): Int {
        return llstEvent.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        lateinit var db: Database
        lateinit var mn: MainActivity
        db = Database(context)
        var events : Event = llstEvent[position]
        holder.title.text = events.title
        holder.status.text = events.status
        holder.prio.text= events.prio
        holder.data.text = events.date
        holder.id.text=events.id + "."
        holder.dateeve.text = events.dateeve
        holder.button.setOnClickListener{
          /* Toast.makeText(context,"TESCIK ${events.id}",Toast.LENGTH_SHORT).show()*/
        db.del_even(events.id.toString())
            notifyItemRemoved(position)

        }

        holder.itemView.setOnClickListener{

        }

    }
}