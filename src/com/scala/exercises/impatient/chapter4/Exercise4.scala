package com.scala.exercises.impatient.chapter4

import java.util

import com.scala.exercises.ScalaExercise
import com.scala.interfaces.Exercise

import scala.collection.mutable

/**
 * Created by Who on 2014/7/6.
 */
class Exercise4 extends ScalaExercise with Exercise {
  override def getName: String = "Chapter4"

  addT(
    () => {
      var scores = Map("Alice" -> 10, "Bob" -> 3, "Cindy" -> 8)
      scores = Map(("Alice()", 10), ("Bob()", 3), ("Cindy()", 8))
      print(scores)

      var scoresNew = scala.collection.mutable.Map("Alice" -> "10", "Bob" -> "3", "Cindy" -> "8")
      print(scoresNew)
      scoresNew("Alice") = "11"
      scoresNew("Alice2") = "12"
      print(scoresNew)
      print(scores.getOrElse("Alice2", 2))
      for (i <- scoresNew) {
        print(i._1 + " " + i._2)
      }

      for ((k, v) <- scoresNew) {
        print(k + " " + v)
      }

      val v = (
        "1", "2", "3"
        )
      print(v)
    }
  )

  addQ(
    () => {
      val prices = Map("A" -> 1, "B" -> 2, "C" -> 3, "D" -> 4, "E" -> 5)
      print(prices)
      val pricesNew = for ((k, v) <- prices) yield k -> v * 0.9
      print(pricesNew)
    }
  )

  addQ(
    () => {
      import scala.collection.mutable.Map
      val strs = Array[String]("A", "B", "A", "B", "A", "B", "C", "B", "C", "B", "D", "B", "D", "B")
      val map = Map[String, Int]()
      for (i <- strs) {
        if (map.contains(i)) {
          map(i) += 1
        }
        else {
          map += i -> 1
        }
      }
      print(map)
    }
  )

  addQ(
    () => {
      val strs = Array[String]("A", "B", "A", "B", "A", "B", "C", "B", "C", "B", "D", "B", "D", "B")
      var map = Map[String, Int]()
      for (i <- strs) {
        if (map.contains(i)) {
          map = map + (i -> (map(i) + 1))
        }
        else {
          map = map + (i -> 1)
        }
      }
      print(map)
    }
  )

  addQ(
    () => {
      val strs = Array[String]("A", "B", "A", "B", "A", "B", "C", "B", "C", "B", "D", "B", "D", "B")
      var map = scala.collection.immutable.SortedMap[String, Int]()
      for (i <- strs) {
        if (map.contains(i)) {
          map = map + (i -> (map(i) + 1))
        }
        else {
          map = map + (i -> 1)
        }
      }
      print(map)
    }
  )

  addQ(
    () => {
      val strs = Array[String]("A", "B", "A", "B", "A", "B", "C", "B", "C", "B", "D", "B", "D", "B")
      val map = new util.TreeMap[String, Int]
      for (i <- strs) {
        if (map.containsKey(i)) {
          map.put(i, map.get(i) + 1)
        }
        else {
          map.put(i, 1)
        }
      }
      print(map)
    }
  )

  addQ(
    () => {
      val strs = Array[String]("A", "B", "A", "B", "A", "B", "C", "B", "C", "B", "D", "B", "D", "B")
      val map = new mutable.LinkedHashMap[String, Int]
      map.put("Monday", java.util.Calendar.MONDAY)
      map.put("Tuesday", java.util.Calendar.TUESDAY)
      map.put("Wednesday", java.util.Calendar.WEDNESDAY)
      map.put("Thursday", java.util.Calendar.THURSDAY)
      map.put("Friday", java.util.Calendar.FRIDAY)
      map.put("Saturday", java.util.Calendar.SATURDAY)
      map.put("Sunday", java.util.Calendar.SUNDAY)
      print(map)
    }
  )

  addQ(
    () => {
      val map = new mutable.LinkedHashMap[String, String]
      map.put("java.rutime.name", "Java (TM) SE Runtime Environment")
      map.put("sun.boot.library.path", "/home/apps/jdk1.6.0_21/jre/lib/i386")
      map.put("java.vm.version", "17.0-b16")
      map.put("java.vm.vendor", "Sun Microsystems Inc.")
      map.put("java.vendor.url", "http://java.sun.com/")
      map.put("path.separator", ":")
      map.put("java.vm.name", "Java HotSpot (TM) Server VM")
      var max = 0
      for ((k, v) <- map) {
        if (k.length > max) {
          max = k.length
        }
      }
      max += 5
      for ((k, v) <- map) {
        print(fix(k) + " | " + v)
      }

      def fix(s: String): String = {
        s + " " * (max - s.length)
      }
    }
  )

  addQ(
    () => {
      val a = Array[Int](1, 2, -3, 4, 50, 6)
      print(minmax(a))

      def minmax(values: Array[Int]): Tuple2[Int, Int] = {
        (values.min, values.max)
      }
    }
  )

  addQ(
    () => {
      val a = Array[Int](1, 2, -3, 4, 50, 6)
      print(lteqgt(a,2))

      def lteqgt(values: Array[Int], v: Int) = {
        var less = 0
        var eq = 0
        var big = 0
        for (i <- values) {
          if (i < v) {
            less += 1
          }
          else if (i == v) {
            eq += 1
          }
          else {
            big += 1
          }
        }
        (less, eq, big)
      }
    }
  )

  addQ(
    () => {
      print("Hello".zip("World"))
    }
  )
}
