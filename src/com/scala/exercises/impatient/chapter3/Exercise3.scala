package com.scala.exercises.impatient.chapter3

import java.awt.datatransfer.{DataFlavor, SystemFlavorMap}
import java.util.TimeZone

import com.scala.exercises.ScalaExercise
import com.scala.interfaces.Exercise

import scala.collection.mutable.ArrayBuffer
import scala.util.Random

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
      for (i <- 0 until 3; j <- 0 until 4) {
        print(matrix(i)(j))
      }
      for (i <- 0 until 3; j <- 0 until 4) {
        matrix(i)(j) = 1d
      }
      for (i <- 0 until 3; j <- 0 until 4) {
        print(matrix(i)(j))
      }
    }
  )

  addQ(
    () => {
      print(makeArray(20))

      def makeArray(n: Int): Array[Int] = {
        val arrayList: ArrayBuffer[Int] = new ArrayBuffer[Int]
        for (i <- 0 until n) {
          arrayList += Random.nextInt(n)
        }
        arrayList.toArray
      }
    }
  )

  addQ(
    () => {
      val a = Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
      print(a)
      print(trans(a))
      def trans(array: Array[Int]): Array[Int] = {
        val n = array.length / 2
        for (i <- 0 to n if 2 * i + 1 < a.length) {
          val temp = array(i * 2 + 1)
          array(i * 2 + 1) = array(i * 2)
          array(i * 2) = temp
        }
        array
      }
    }
  )

  addQ(
    () => {
      val a = Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
      print(a)
      print(trans(a))

      def trans(array: Array[Int]): Array[Int] = {
        val transed = for (i <- 0 until array.length) yield {
          if (i % 2 == 0) {
            if (i + 1 == array.length) {
              array(i)
            }
            else {
              array(i + 1)
            }
          }
          else {
            array(i - 1)
          }
        }
        transed.toArray
      }
    }
  )

  addQ(
    () => {
      val a = Array[Int](-1, -2, -3, -3, 0, 0, 0, 100, 99, -4, -5, -6, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
      print(a)
      print(make(a))

      def make(array: Array[Int]): Array[Int] = {
        val p = for (i <- array if i > 0) yield i
        val z = for (i <- array if i == 0) yield i
        val n = for (i <- array if i < 0) yield i
        (p.toBuffer ++= z.toBuffer ++= n.toBuffer).toArray
      }
    }
  )

  addQ(
    () => {
      val a = Array[Double](-1, -2, -3, -3, 10)
      print(a.sum / a.length)
    }
  )

  addQ(
    () => {
      val a = Array[Int](-1, -2, -3, -3, 10)
      print(a.reverse)
      print(a.toBuffer.reverse)
    }
  )

  addQ(
    () => {
      val a = Array[Int](-1, -2, -3, -3, 10)
      val aBackUp: ArrayBuffer[Int] = ArrayBuffer[Int]()
      for (i <- a if !aBackUp.contains(i)) {
        aBackUp += i
      }
      print(aBackUp)
    }
  )

  addQ(
    () => {
      val a = ArrayBuffer[Int](-1, -2, -3, -3, 10)
      print(a)
      remove(a)
      print(a)
      def remove(array: ArrayBuffer[Int]): Unit = {
        var ns = for (i <- 0 until array.length if array(i) < 0) yield i
        ns = ns.reverse.dropRight(1)
        for (i <- ns) {
          array.remove(i)
        }
      }
    }
  )

  addQ(
    () => {
      val list = TimeZone.getAvailableIDs.toBuffer;
      val usaList = list.filter(_.contains("America/"))
      var usaListNew = for (i <- usaList) yield i.replace("America/", "")
      usaListNew = usaListNew.sortWith((x, y) => x < y)
      print(usaListNew)
    }
  )

  addQ(
    () => {
      val flavors = SystemFlavorMap.getDefaultFlavorMap.asInstanceOf[SystemFlavorMap]
      val value = flavors.getNativesForFlavor(DataFlavor.imageFlavor)
      print(value)
    }
  )
}
