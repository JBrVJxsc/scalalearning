package com.scala.exercises.impatient.chapter3

import com.scala.exercises.ScalaExercise
import com.scala.interfaces.Exercise

import scala.collection.mutable.ArrayBuffer

/**
 * Created by Who on 2014/7/6.
 */
class Exercise3 extends ScalaExercise with Exercise {
  override def getName: String = "Chapter3"

  addT(
    () => {
      var nums = new Array[Int](10)
      print(nums)
      nums = Array[Int](10)
      print(nums)

      print()

      var strs = new Array[String](10)
      for (i <- strs) {
        print(i)
      }
      strs = Array[String]("Hello")
      for (i <- strs) {
        print(i)
      }

      print()

      strs = Array("Hello", "World")
      for (i <- strs) {
        print(i)
      }
      print(strs(1))

      print()

      print(for (i <- 1 to 10) yield i * 2)

      var a = Array(2, 3, 5, 7, 11)
      val result = for (elem <- a) yield 2 * elem
      print(result)

      print()

      print(for (elem <- a if elem % 2 == 0) yield 2 * elem)

      print(a.filter(x => x % 2 == 0).map(x => x * 2))

      print(a.filter(_ % 2 == 0).map(_ * 2))

      var aa = new ArrayBuffer[Int]
      aa += 1
      aa += 2
      aa += 3
      aa += 4
      aa += 5
      aa += -1
      aa += -2
      aa += -3
      var first = true
      var n = aa.length
      var i = 0
      while (i < n) {
        if (aa(i) >= 0) {
          i += 1
        }
        else {
          if (first) {
            first = false
            i += 1
          }
          else {
            aa.remove(i)
            n -= 1
          }
        }
      }
      print(aa)

      val dd = new ArrayBuffer[Int]
      dd += 1
      dd += 2
      dd += 3
      dd += -2
      dd += -3
      first = true
      print(for (i <- 0 until dd.length if first || dd(i) >= 0) yield {
        if (dd(i) < 0) first = false; dd(i)
      })

      val b = ArrayBuffer(5, 6, 7, 1, 2, 3, 4)
      print(b.sortWith((x, y) => x < y))
      print(b.mkString(" and "))

      val matrix = Array.ofDim[Double](3, 4)
      print(matrix)
    }
  )
}
