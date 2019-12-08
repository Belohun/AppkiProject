package com.example.projekt
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast
import java.time.LocalDate

class Database(val context:Context): SQLiteOpenHelper(context,DATABASE_NAME,null,DATABES_VER) {
    companion object {
        private val DATABES_VER = 2
        private val DATABASE_NAME = "events.db"

        private val TABLE_NAME = "EVENTS"
        private val COL_TITLE = "EVENT_TITLE"
        private val COL_ID = "ID"
        private val COL_PRIO = "PRIORITY"
        private val COL_DATE = "DATE"
        private val COL_STATUS = "STATUS"
        private val COL_DESC = "DESCRIPTION"
        private val COL_DATE_EVENT = "DATE_OF_EVENT"


    }
    internal lateinit var mn: MainActivity

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db!!)
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val CREATE_TABLE_QUERY: String =
            ("CREATE TABLE $TABLE_NAME ($COL_ID  INTEGER  PRIMARY KEY AUTOINCREMENT,$COL_TITLE TEXT,$COL_PRIO TEXT,$COL_DATE TEXT,$COL_DATE_EVENT TEXT,$COL_STATUS TEXT, $COL_DESC TEXT)")
        db!!.execSQL(CREATE_TABLE_QUERY);
    }
/*
    fun findMaxId(): Int? {
        val db = this.writableDatabase
        val maxId = "select max(id)+1 FROM $TABLE_NAME "
        val id=db.rawQuery(maxId,null)
        var finid=id.getInt(id.getColumnIndex(COL_ID))
        if(finid == null)
        {
            finid=1
        }
    return finid

    }
*/

    val List: List<Event>
        get() {

            val lstEvent = ArrayList<Event>()
            val selectQuery = "SELECT * FROM $TABLE_NAME"
            val db = this.readableDatabase
            val cursor = db.rawQuery(selectQuery, null)
            if (cursor.moveToFirst()) {
                do {
                    val event = Event()
                    event.id = cursor.getString(cursor.getColumnIndex(COL_ID))
                    event.title = cursor.getString(cursor.getColumnIndex(COL_TITLE))
                    event.prio = cursor.getString(cursor.getColumnIndex(COL_PRIO))
                    event.desc = cursor.getString(cursor.getColumnIndex(COL_DESC))
                    event.status = cursor.getString(cursor.getColumnIndex(COL_STATUS))
                    event.date = cursor.getString(cursor.getColumnIndex(COL_DATE))
                    event.dateeve= cursor.getString(cursor.getColumnIndex(COL_DATE_EVENT))
                    lstEvent.add(event)
                } while (cursor.moveToNext())
            }
            return lstEvent
            db.close()

        }

fun saveInfo( context: Context) { Toast.makeText(context,"pomyslnie dodano wydarzenie ",Toast.LENGTH_SHORT).show()}
   fun add_event (event: Event){

       val db=writableDatabase
       val values = ContentValues()
       values.put(COL_DATE,LocalDate.now().toString())
       values.put(COL_STATUS,"Rozpoczęte")
       values.put(COL_DESC,event.desc)
       values.put(COL_TITLE,event.title)
       values.put(COL_PRIO,event.prio)
       values.put(COL_DATE_EVENT,event.dateeve)

      db.insertOrThrow(TABLE_NAME,null,values)
       saveInfo(context)
       db.close()

   }

  fun del_even(id: String){

      val db=writableDatabase

     db.delete(TABLE_NAME,"$COL_ID=?", arrayOf(id))
      Toast.makeText(context,"Pomyślnie usunięto wydarzenie",Toast.LENGTH_SHORT).show()
      db.close()


  }


        }