package com.scala.exercises.impatient.chapter13

import com.scala.exercises.ScalaExercise
import com.scala.interfaces.Exercise

/**
 * Created by Who on 14-7-14.
 */
class Exercise13 extends ScalaExercise with Exercise {
  override def getName: String = "Chapter13"

  addT(
    () => {
      val digits = List(4, 2)
      print(digits)
      print("Head: " + digits.head)
      print("Tail: " + digits.tail)
      print("Last: " + digits.last)
      print("Init: " + digits.init)
      val n = 9 :: digits
      print(n)
      print("Head: " + n.head)
      print("Tail: " + n.tail)
      print("Last: " + n.last)
      print("Init: " + n.init)

      val n1 = n.::(1)
      print(n1)

      val n2 = 2 :: n1
      print(n2)
    }
  )

  addT(
    () => {
      val s = Set(1, 2, 3)
      print(s + 4)

      val digits = Set(1, 7, 2, 9)
      print(digits.contains(0))
      print(Set(1, 7).subsetOf(digits))
    }
  )

  addT(
    () => {
      val s = Set(1, 2)
      val s2 = Set(2, 3, 4)
      print(s | s2)
      print(s & s2)
    }
  )
}
