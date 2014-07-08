package com.scala.exercises.impatient.chapter5

import com.scala.exercises.ScalaExercise
import com.scala.interfaces.Exercise

/**
 * Created by Who on 2014/7/7.
 */
class Exercise5 extends ScalaExercise with Exercise {
  override def getName: String = "Chapter5"

  addT(
    () => {
      val myCounter = new Counter
      myCounter.increment()
      print(myCounter.current)
    }
  )

  addT(
    () => {
      val person = new Person("Xu ZHANG")
      person.age = 100
      print(person.age)
    }
  )

  addT(
    () => {
      val chatter = new Network
      val myFace = new Network
      val fred = chatter.join("Fred")
      val wilma = chatter.join("Wilma")
      fred.contacts += wilma
      val barney = myFace.join("Barney")
      fred.contacts += barney
    }
  )

  addT(
    () => {
      val testOuter = (new Network).getTestOuter.getTestOuterNumber
      print(testOuter)
    }
  )
}
