package com.scala.exercises.impatient.chapter10

/**
 * Created by Who on 14-7-12.
 */
trait ShortLoggerTrait extends Logged{
  val maxLength =15

  override def log(msg: String): Unit = {
    super.log(
      if (msg.length <= maxLength) msg else msg.substring(0, maxLength-3) + "..."
    )
  }
}
