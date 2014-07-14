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
      result = a.corresponds(d)(_ == _)
      print(result)
    }
  )

  addT(
    () => {
      def runInThread(block: () => Unit) {
        new Thread {
          override def run() {
            block()
          }
        }.start()
      }

      runInThread {
        () => print("Hi"); Thread.sleep(1000); print("Bye")
      }
    }
  )

  addT(
    () => {
      def runInThread(block: => Unit) {
        new Thread {
          override def run() {
            block
          }
        }.start()
      }

      runInThread({
        print("Hi");
        Thread.sleep(1000);
        print("Bye")
      }
      )
    }
  )

  addT(
    () => {
      def until(condition: => Boolean)(block: => Unit) {
        if (!condition) {
          block
          until(condition)(block)
        }
      }

      var x = 10
      until(x == 0) {
        x -= 1
        print(x)
      }
    }
  )

  addQ(
    () => {
      def values(fun: Int => Int, low: Int, high: Int) = {
        for (i <- low to high) yield (i, fun(i))
      }

      print(values(x => x * x, -5, 5))
    }
  )

  addQ(
    () => {
      val array = Array[Int](1, 2, 3, 4, 5)
      var max = array.reduceLeft(_.max(_))
      max = array.reduceLeft(_ max _)
      print(max)
    }
  )

  addQ(
    () => {
      val array = Array[Int](1, 2, 3, 4, 5)
      print(array.reduceLeft(_ * _))
    }
  )

  addQ(
    () => {
      val array = Array[Int](1, 2, 3, 4, 5)
      val result = array.foldLeft(1)(_ * _)
      print(result)
    }
  )

  addQ(
    () => {
      def largest(fun: Int => Int, inputs: Seq[Int]) = {
        fun(inputs.reduceLeft((x, y) => if (fun(x) > fun(y)) x else y))
      }

      val result = largest(x => 10 * x - x * x, 1 to 10)
      print(result)
    }
  )

  addQ(
    () => {
      def largest(fun: Int => Int, inputs: Seq[Int]) = {
        inputs.reduceLeft((x, y) => if (fun(x) > fun(y)) x else y)
      }

      val result = largest(x => 10 * x - x * x, 1 to 10)
      print(result)
    }
  )

  addQ(
    () => {
      val pairs = (1 to 10) zip (11 to 20)
      print(pairs)

      def adjustToPairOld(fun: (Int, Int) => Int) = {
        def opPair(pair: Tuple2[Int, Int]): Int = {
          fun(pair._1, pair._2)
        }

        opPair _
      }

      def adjustToPair(fun: (Int, Int) => Int)(pair: Tuple2[Int, Int]) = {
        fun(pair._1, pair._2)
      }

      print(adjustToPair(_ * _)((6, 7)))
      var mapped = pairs.map(adjustToPair(_ + _))
      print(mapped)
      // Another easier way to do this.
      mapped = pairs.map((x: Tuple2[Int, Int]) => x._1 + x._2)
      print(mapped)
    }
  )

  addQ(
    () => {
      val strArray = Array[String]("a", "bc", "def", "ghij", "klmno")
      val intArray = Array[Int](1, 2, 3, 4, 5)
      print(strArray.corresponds(intArray)(_.length == _))
    }
  )

  addQ()

  addQ(
    () => {
      def unless(condition: => Boolean)(block: => Unit) {
        if (!condition) {
          block
          unless(condition)(block)
        }
      }

      var count = 10
      unless(count == 0) {
        print(count)
        count -= 1
      }
    }
  )
}
