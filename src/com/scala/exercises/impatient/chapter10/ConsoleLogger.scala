package com.scala.exercises.impatient.chapter10

/**
 * Created by Who on 14-7-11.
 */
class ConsoleLogger extends Logger with Cloneable with Serializable{
  def log(msg: String): Unit = {
    println(msg)
  }
}
