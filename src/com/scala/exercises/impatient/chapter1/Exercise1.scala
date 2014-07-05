package com.scala.exercises.impatient.chapter1

import com.scala.exercises.ScalaExercise
import com.scala.interfaces.Exercise

/**
 * Created by Who on 2014/7/5.
 */
class Exercise1 extends ScalaExercise with Exercise {
  override def getName: String = "Chapter1"

  override def getSummary: String = "Chapter1"

  addQ(() => print(100))
  addQ(() => print(101))
  addQ(() => print(102))
  addQ(() => print(103))
  addQ(() => print(104))
}
