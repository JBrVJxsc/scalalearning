package com.scala.exercises.impatient.chapter17

import com.scala.exercises.ScalaExercise
import com.scala.interfaces.Exercise

/**
 * Created by Who on 2014/7/22.
 */
class Exercise17 extends ScalaExercise with Exercise {
  override def getName: String = "Chapter17"

  addT(
    () => {
      class Pair[T, S](val first: T, val second: S) {
        override def toString: String = first.toString + ", " + second.toString
      }

      val p = new Pair(42, "String")
      println()
      println(p.toString)

      val p1 = new Pair[Int, String](1, "String")
      println(p1)
    }
  )

  addT(
    () => {
      def getMiddle[T](a: Array[T]) = a(a.length / 2)

      print(getMiddle(Array(1, 2, 3, 4, 5)))

      val f = getMiddle[String] _
      print(f(Array("1", "2", "3", "4", "5")))
    }
  )

  addT(
    () => {
      class Pair[T <: Comparable[T]](val first: T, val second: T) {
        def smaller = if (first.compareTo(second) < 0) first else second
      }

      // This line of code will not be accepted by compiler, because Int is not subclass of Comparable[Int].
      //      val p = new Pair(1, 2)

      class PairPlus[T <% Comparable[T]](val first: T, val second: T) {
        def smaller = if (first.compareTo(second) < 0) first else second
      }

      val p = new PairPlus(1, 2)
      println()
      println(p.smaller)
    }
  )

  addT(
    () => {
      class Pair[T](val first: T, val second: T) {
        def replaceFirst(newFirst: T) = new Pair(newFirst, second)

        def replaceFirstPlus[R >: T](newFirst: R) = new Pair(newFirst, second)

        override def toString: String = first + ", " + second
      }

      val p = new Pair(1, 2)
      println()
      println(p.replaceFirst(2))
      println(p.replaceFirstPlus("String"))
    }
  )
}
