package com.example.projekt

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.tasks.view.*
import androidx.core.content.ContextCompat.startActivity
import android.content.Intent



class eventAdapter(context: Context, var llstEvent: ArrayList<Event>): RecyclerView.Adapter<eventAdapter.ViewHolder>() {

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
        db.del_even(events.id.toString(
        ))
          /*  val intent = Intent(it.context, MainActivity::class.java)
            it.context.startActivity(intent)*/
            llstEvent.removeAt(position)
            notifyItemRemoved(position)


        }

        holder.itemView.setOnClickListener{
           /* val intent = Intent(this.context, EditEvent::class.java)
            startActivity(this.context, intent,null ) */
            val intent = Intent(it.context, EditEvent::class.java)
            intent.putExtra("id",events.id)
            intent.putExtra("title",events.title)
            intent.putExtra("desc",events.desc)
            intent.putExtra("status",events.status)
            intent.putExtra("prio",events.prio)
            intent.putExtra("dateeve",events.dateeve)
            it.context.startActivity(intent)

        }

    }
}