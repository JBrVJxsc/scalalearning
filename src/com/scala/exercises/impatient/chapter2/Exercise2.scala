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

  addT(
    () => {
      for (i <- 1 to 20) {
        print(i)
      }
    }
  )

  addT(
    () => {
      val str: String = "Hello, World!"
      for (i <- 0 until str.length) {
        print(str(i).toString)
      }
    }
  )

  addT(
    () => {
      val str: String = "Hello, World!"
      for (i <- str) {
        print(i.toString)
      }
    }
  )

  addT(
    () => {
      for (i <- 0 to 100) {
        if (i % 2 == 0) {
          print(i)
        }
      }
    }
  )

  addT(
    () => {
      for (i <- 0 to 100) {
        pt(i)
      }

      def pt(i: Int) {
        if (i % 2 != 0) {
          return
        }
        print(i)
      }
    }
  )

  addT(
    () => {
      for (i <- 1 to 3; j <- 1 to 3) {
        print((10 * i + j) + " ")
      }

      print()

      for (i <- 1 to 3; j <- 1 to 3 if i != j) {
        print((10 * i + j) + " ")
      }

      print()

      for (i <- 1 to 3; from = 4 - i if i == 3 || i == 2; j <- from to 3) {
        print((10 * i + j) + " ")
      }

      print()

      print(for (i <- 1 to 10) yield i % 3)

      print()
    }
  )

  addT(
    () => {
      print(for (c <- "Hello"; i <- 0 to 1) yield (c + i).toChar)

      print()

      print(for (i <- 0 to 1; c <- "Hello") yield (c + i).toChar)
    }
  )

  addT(
    () => {
      sum(1, 2, 3, 4)
      sum(1 to 4: _*)

      def sum(args: Int*): Unit = {
        var sum = 0
        for (arg <- args) {
          sum += arg
        }
        print(sum)
      }
    }
  )

  addT(
    () => {
      print(recursiveSum(1, 2, 3, 4))

      def recursiveSum(args: Int*): Int = {
        if (args.length == 0)
          0
        else
          args.head + recursiveSum(args.tail: _*)
      }
    }
  )

  addT(
    () => {
      print(100)
    }
  )

  addQ(
    () => {

      print(signum(100))

      def signum(n: Int): Int = {
        if (n > 0)
          1
        else if (n < 0)
          -1
        else
          0
      }
    }
  )

  addQ(
    () => {
      print({})
    }
  )

  addQ(
    () => {
      var x: Unit = null
      var y: Int = 0
      x = y = 1
    }
  )

  addQ(
    () => {
      for (i <- 0 to 10 reverse) {
        print(i)
      }
    }
  )

  addQ(
    () => {
      countdown(10)

      def countdown(n: Int) {
        for (i <- 0 to n reverse) {
          print(i)
        }
      }
    }
  )
}
