package com.scala.exercises.impatient

import com.scala.exercises.BaseExercise
import com.scala.interfaces.Exercise

/**
 * Created by Who on 2014/7/5.
 */
class chapter2 extends BaseExercise with Exercise {
  override def getName: String = "Chapter2"

  override def getSummary: String = "Chapter2"

  override def run(): Unit = {
    show("Hello!")
    timerOn();
    print(timerOff());
  }
}
