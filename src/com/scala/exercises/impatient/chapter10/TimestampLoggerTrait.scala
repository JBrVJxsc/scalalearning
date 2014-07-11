package com.scala.exercises.impatient.chapter10

/**
 * Created by Who on 14-7-12.
 */
trait TimestampLoggerTrait extends Logged {
  override def log(msg: String): Unit = {
    super.log(new java.util.Date() + " " + msg)
  }
}
