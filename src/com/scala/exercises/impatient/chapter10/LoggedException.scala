package com.scala.exercises.impatient.chapter10

/**
 * Created by Who on 14-7-12.
 */
trait LoggedException extends Logged {
  this: Exception =>
  def log() {
    log(getMessage)
  }
}
