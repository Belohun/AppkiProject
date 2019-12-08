package com.example.projekt

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.core.view.get
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.events.*
import kotlinx.android.synthetic.main.tasks.*
import kotlinx.android.synthetic.main.tasks.prio
import android.util.Log



class MainActivity : AppCompatActivity() {
    internal lateinit var db:Database
 /*   internal var llstEvent:List<Event> = arrayListOf<Event>(Event("s","s","data","c"),Event("s","f","g","s"),Event("s","f","g","s"))
*/
    internal var llstEvent:List<Event> = ArrayList<Event>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        db= Database(this)
        refreshdata(this)

    }

    override fun onResume() {
        super.onResume()
        refreshdata(this)
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu,menu);
        return true
    }
  /*  fun backtomain() {
        val intent = Intent(this, activity_main::class.java)
        startActivity(intent)
    }*/
    fun createNewEvent(){
        val intent = Intent(this, AddEvent::class.java)
        startActivity(intent)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        val id = item.itemId;
        if (id == R.id.addNewEventButton){
            createNewEvent()

            return true
        }

        return super.onOptionsItemSelected(item)
    }
      fun refreshdata(context: Context){
        llstEvent=db.List
        recyclerView.layoutManager=LinearLayoutManager(context,RecyclerView.VERTICAL,false)
        val adapter =eventAdapter(context,llstEvent)
        recyclerView.adapter = adapter
    }

}
