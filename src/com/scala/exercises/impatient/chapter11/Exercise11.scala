package com.scala.exercises.impatient.chapter11

import com.scala.exercises.ScalaExercise
import com.scala.interfaces.Exercise

/**
 * Created by Who on 14-7-13.
 */
class Exercise11 extends ScalaExercise with Exercise {
  override def getName: String = "Exercise11"

  addT(
    () => {
      object T {

        var name = "OldName"

        def apply(i: Int): Array[Int] = {
          val v = new Array[Int](i)
          println("\n" + v)
          println(i)
          v
        }

        def apply(i: Int, j: Int): Array[Int] = {
          val v = new Array[Int](i * j)
          println("\n" + v)
          println(v.length)
          v
        }

        def update(key: String, value: String) = {
          if (key == "name") {
            name = value
          }
        }
      }

      T(1)
      T(1, 3)
      println(T.name)
      T("name") = "NewName"
      println(T.name)
    }
  )

  addT(
    () => {
      class T {
        var name = "OldName"

        def update(key: String, value: String) = {
          if (key == "name") {
            name = value
          }
        }
      }

      val t = new T
      println("\n" + t.name)
      t("name") = "NewName"
      println(t.name)
    }
  )

  addT(
    () => {
      var Fraction(a, b) = Fraction(3, 4) * Fraction(2, 5)
      print(a)
      print(b)
      a += 2
      b *= 2
      print(a)
      print(b)
    }
  )

  addT(
    () => {
      val Name(first, last) = "Xu ZHANG"
      print("First name: " + first)
      print("Second name: " + last)
    }
  )

  addT(
    () => {
      val Number(num) = "1000"
      print(num)
    }
  )

  addT(
    () => {
      "aa bb cc dd" match {
        case Name(a, b, c, d) => print(a + b + c + d)
      }

      val Name(a, b, c, d) = "aa bb cc dd"
      print(a + b + c + d)
    }
  )

  addQ()

  addQ()

  addQ()

  addQ(
    () => {

    }
  )


}
