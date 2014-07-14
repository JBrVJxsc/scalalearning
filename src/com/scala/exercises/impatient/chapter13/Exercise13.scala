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

      var n1 = n.::(1)
      var n3 = n.:::(n1)

      n1 = 1 :: n
      n3 = n1 ::: n

      print(n1)
      print(n3)

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

  addT(
    () => {
      val s = Set(1, 2)
      val s2 = Set(2, 3, 4)
      print(s | s2 + 5)
      print(s & s2 + 5)
    }
  )

  addT(
    () => {
      val array = Array[Int](1, 2, 3, 4, 5)
      val result = array.foldLeft(1)(_ * _)
      print(result)
      val result1 = (1 /: array)(_ * _)
      print(result1)
      val result2 = (array :\ 1)(_ * _)
      print(result2)
    }
  )

  addT(
    () => {
      val freq = scala.collection.mutable.Map[Char, Int]()
      for (i <- "Hello, everyone, my name is Xu ZHANG.") freq(i) = freq.getOrElse(i, 0) + 1
      print(freq)
    }
  )

  addT(
    () => {
      val result = (Map[Char, Int]() /: "Mississippi")(
        (m, c) => m + (c -> (m.getOrElse(c, 0) + 1))
      )

      print(result)
    }
  )

  addT(
    () => {
      val s1 = List(1, 2, 3, 4, 5)
      val s2 = List(6, 7, 8, 9, 10, 11)
      print(s1.zipAll(s2, -1, -2))
    }
  )

  addT(
    () => {
      val s1 = List(1, 2, 3, 4, 5)
      val s2 = List(6, 7, 8, 9)
      print(s1.zipAll(s2, -1, -2))
    }
  )

  addT(
    () => {
      def numsFrom(n: BigInt): Stream[BigInt] = n #:: numsFrom(n + 1)
      print(numsFrom(10).head)
      print(numsFrom(10).tail.head)
      print(numsFrom(10).take(5).force)
      // Do not do this.
//      print(numsFrom(10).force)
    }
  )

  addT(
    () => {
      val powers = (0 until 10).view.map(math.pow(10, _))
      print(powers(0))
      print(powers(1))
      print(powers(2))
      print(powers(3))
      print(powers(4))
    }
  )

  addT(
    () => {
      val v1 = (0 to 10).map(math.pow(10, _)).map(1 / _)
      print(v1)
      val v2 = (0 to 10).view.map(math.pow(10, _)).map(1 / _)
      print(v2)
      val v3 = (0 to 10).view.map(math.pow(10, _)).map(1 / _).force
      print(v3)
    }
  )

  addT(
    () => {
      for (i <- (0 until 100).par) print(i)
      print()
      print(for (i <- (0 until 100).par) yield i + " ")
    }
  )

  addT(
    () => {
      print("Non_concurrent:")
      timerOn()
      for (i <- 0 to 999999999) {}
      print("Done: " + timerOff() + " ms.")
    }
  )

  addT(
    () => {
      print("Concurrent:")
      timerOn()
      for (i <- (0 to 999999999).par) {}
      print("Done: " + timerOff() + " ms.")
    }
  )
}
