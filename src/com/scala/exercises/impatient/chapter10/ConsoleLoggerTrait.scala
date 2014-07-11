package com.scala.exercises.impatient.chapter10

/**
 * Created by Who on 14-7-12.
 */
trait ConsoleLoggerTrait extends Logged{
  override def log(msg: String): Unit = {
    println("\n" + msg)
  }
}
