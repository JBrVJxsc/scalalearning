package com.scala.exercises.impatient.chapter1

import com.scala.exercises.ScalaExercise
import com.scala.interfaces.Exercise

/**
 * Created by Who on 2014/7/5.
 */
class Exercise1 extends ScalaExercise with Exercise {
  override def getName: String = "Chapter1"

  override def getSummary: String = "Chapter1"

  addQ("q1", () => print(100))
  addQ("q2", () => print(101))
  addQ("q3", () => print(102))
  addQ("q4", () => print(103))
  addQ("q5", () => print(104))
}
