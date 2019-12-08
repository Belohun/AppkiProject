package com.example.projekt

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*


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
        menuInflater.inflate(R.menu.menu,menu)
        return true
    }

    fun createNewEvent() {
        val intent = Intent(this@MainActivity, AddEvent::class.java)
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
        val adapter =eventAdapter(context, llstEvent as ArrayList<Event>)
        recyclerView.adapter = adapter
    }
}
