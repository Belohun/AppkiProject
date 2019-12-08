package com.example.projekt

import android.content.Context
import android.os.Bundle
import android.os.PersistableBundle
import android.view.MotionEvent
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
import kotlinx.android.synthetic.main.tasks.*
import kotlinx.android.synthetic.main.tasks.view.*

class Tasks : OnItemTouchListener{
    override fun onTouchEvent(rv: RecyclerView, e: MotionEvent) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onInterceptTouchEvent(rv: RecyclerView, e: MotionEvent): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onRequestDisallowInterceptTouchEvent(disallowIntercept: Boolean) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
/*    override fun onCreate(savedInstanceState: Bundle?) {
        var db = Database(this)
        lateinit var mn: MainActivity
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tasks)
        BTN_DEL.setOnClickListener{

            db.del_even(idHolder.toString())
            mn.refreshdata()
        }

    }*/
}