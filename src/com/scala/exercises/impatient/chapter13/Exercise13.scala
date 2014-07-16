package com.scala.exercises.impatient.chapter13

import com.scala.exercises.ScalaExercise
import com.scala.interfaces.Exercise

import scala.collection.mutable

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
      for (i <- 0 to 9999) {}
      print("Done: " + timerOff() + " ms.")
    }
  )

  addT(
    () => {
      print("Concurrent:")
      timerOn()
      for (i <- (0 to 9999).par) {}
      print("Done: " + timerOff() + " ms.")
    }
  )

  addT(
    () => {
      val a = Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 0)
      val an = a.map(_ != 0)
      print(an.mkString(","))
    }
  )

  addT(
    () => {
      val map = mutable.Map("a" -> 1, "b" -> 2)
      for (i <- map) {
        print(i.getClass)
      }
      print(("a" -> 1).getClass)
    }
  )

  addQ(
    () => {
      def indexes(str: String) = {
        var map = Map[Char, Set[Int]]()
        var counter = -1
        // Another way.
        //        for (i <- str) {
        //          if (map.contains(i)) {
        //            map += i -> (map(i) + counter)
        //          } else {
        //            map += i -> Set(counter)
        //          }
        //          counter += 1
        //        }
        str.foreach(x => if (map.contains(x)) map += x -> (map(x) + newCounter) else map += x -> Set(newCounter))
        def newCounter: Int = {
          counter += 1
          counter
        }
        map
      }
      print(indexes("Mississippi"))
    }
  )

  addQ(
    () => {
      var counter = -1
      def newCounter = {
        counter += 1
        counter
      }

      def indexes(str: String) = {
        val map = Map[Char, List[Int]]()
        def loop(i: Iterator[Char], map: Map[Char, List[Int]]): Map[Char, List[Int]] = {
          if (i.hasNext) {
            val next = i.next()
            if (map.contains(next)) {
              loop(i, map + (next -> (map(next) ::: List(newCounter))))
            } else {
              loop(i, map + (next -> List(newCounter)))
            }
          } else {
            map
          }
        }
        loop(str.iterator, map)
      }

      print(indexes("Mississippi"))
    }
  )

  addQ(
    () => {
      def departZero(linkedList: mutable.LinkedList[Int]) = {
        linkedList.filter(_ != 0)
      }
      val linkedList = mutable.LinkedList[Int](-1, 2, 3, 4, 0, 3, 0, 1, 0, 3, 5, 0, 9, 8, 67, 0, 0, 0, 75, 5, 44, 0)
      print(departZero(linkedList))
    }
  )

  addQ(
    () => {
      def pair(strs: Array[String], map: Map[String, Int]) = {
        strs.flatMap(map.get(_))
      }
      print(pair(Array("Tom", "Fred", "Harry"), Map[String, Int]("Tom" -> 3, "Dick" -> 4, "Harry" -> 5)).mkString(","))
    }
  )

  addQ(
    () => {
      def makeString(t: TraversableOnce[Any], sep: String) = {
        t.reduceLeft(_.toString + sep + _.toString)
      }

      def a = Array(1, 2, 3, 4, 5)
      print(makeString(a, ","))
    }
  )

  addQ(
    () => {
      val lst = List(1, 2, 3, 4, 5)
      print((lst :\ List[Int]())((x: Int, y: List[Int]) => y ::: List(x)))
      print((List[Int]() /: lst)(_ :+ _))
    }
  )

  addQ(
    () => {
      val prices = Array[Double](1, 2, 3)
      val quantities = Array[Double](3, 2, 1)
      print(((prices zip quantities) map {
        Function.tupled(_ * _)
      }).mkString(",")
      )
    }
  )

  addQ(
    () => {
      def trans(array: Array[Double], colNum: Int) = {
        array.grouped(colNum)
      }
      val v = trans(Array(1, 2, 3, 4, 5, 6), 3)
      while (v.hasNext) {
        print(v.next().mkString(", "))
      }
    }
  )

  addQ(
    () => {

    }
  )
}
