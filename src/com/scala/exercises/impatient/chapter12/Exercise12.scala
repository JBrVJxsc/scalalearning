package com.scala.exercises.impatient.chapter12

import com.scala.exercises.ScalaExercise
import com.scala.interfaces.Exercise

/**
 * Created by Who on 14-7-13.
 */
class Exercise12 extends ScalaExercise with Exercise {
  override def getName: String = "Exercise12"

  addT(
    () => {
      import scala.math._
      val num = 3.14
      val fun = ceil _
    }
  )

  addT(
    () => {
      val fun: Double => Double = 3 * _

      print
      (1 to 9).map("*" * _).foreach(print _)
    }
  )

  addT(
    () => {
      print
      (1 to 9).map("*" * _).foreach(print _)
      print((1 to 9).map(_.toString))
    }
  )

  addT(
    println((1 to 19).map(_.toString))
  )

  addT(
    () => {
      print((1 to 9).reduceLeft(_ * _))
    }
  )

  addT(
    () => {
      print("Mary has a little lamb".split(" ").sortWith(_.length < _.length))
    }
  )

  addT(
    () => {
      def mul(x: Int, y: Int) = {
        x * y
      }

      def mulOneAtATime(x: Int) = {
        (y: Int) => x * y
      }

      print(mul(2, 3))

      print(mulOneAtATime(2)(3))
    }
  )

  addT(
    () => {
      def mulOneAtATime(x: Int)(y: Int) = {
        x * y
      }
    }
  )

  addT(
    () => {
      val a = Array("1", "2")
      val b = Array("hello", "world")
      val c = Array(1, "2", true)
      val d = Array(1, 2)
      var result = a.corresponds(b)(_.equalsIgnoreCase(_))
      print(result)
      result = a.corresponds(d)(_==_)
      print(result)
    }
  )


}
