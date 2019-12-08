package com.example.projekt

import java.lang.NullPointerException
import java.util.*

class Event{
    var id: String?=null
    var title: String?=null
    var prio: String?=null
    var date: String?=null
    var status: String?=null
    var desc: String?=null
    var dateeve: String?= null

constructor()
constructor(id: String,title:String,prio:String,/*status:String,*/desc:String,dateeve:String)
{
    this.id = id
    this.dateeve = dateeve
    this.title=title
    this.prio=prio
  /*  this.status=status*/
    this.desc=desc
}


}
