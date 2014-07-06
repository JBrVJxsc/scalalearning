package com.scala.exercises.impatient.chapter2

import com.scala.exercises.ScalaExercise
import com.scala.interfaces.Exercise

/**
 * Created by Who on 2014/7/6.
 */
class Exercise2 extends ScalaExercise with Exercise {
  override def getName: String = "Chapter2"

  override def getSummary: String = "Chapter2"

  addT(
    () => {
      print((if (true) "Hello" else 1).getClass)
    }
  )
}
