package com.meridal.examples.scalaspringboot.model

import javax.persistence._

import scala.beans.BeanProperty

@Entity
class Recording(
    @BeanProperty var artist: String = "", 
    @BeanProperty var title: String = "", 
    @BeanProperty var catalogueNumber: String = "") {

    def this() = this("", "", "")
  
    @Id
    @GeneratedValue
    @BeanProperty
    var id: Long = _

    override def equals(other: Any): Boolean = other match {
      case recording: Recording => this.id == recording.id
      case _ => false
    }

    override def hashCode(): Int = if (id eq null) 0 else id.toInt
}
