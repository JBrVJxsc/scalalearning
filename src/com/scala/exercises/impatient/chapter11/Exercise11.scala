package com.scala.exercises.impatient.chapter11

import com.scala.exercises.ScalaExercise
import com.scala.interfaces.Exercise

/**
 * Created by Who on 14-7-13.
 */
class Exercise11 extends ScalaExercise with Exercise {
  override def getName: String = "Chapter11"

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

  addT(
    () => {
      val fraction = Fraction(3, 4) * Fraction(2, 5)
      val fraction(a, b) = Fraction(3, 4) * Fraction(2, 5)
      print(a + " " + b)
    }
  )

  addQ()

  addQ()

  addQ()

  addQ(
    () => {
      class Money(var d: Int, var c: Double) {

        if (c > 100) {
          d += (c / 100).asInstanceOf[Int]
          c = c % 100
        }

        def +(money: Money) = {
          Money(d + money.d, c + money.c)
        }

        def -(money: Money) = {
          val newD = ((d * 100 + c - money.d * 100 - money.c) / 100).asInstanceOf[Int]
          val newC = (d * 100 + c - money.d * 100 - money.c) % 100
          Money(newD, newC)
        }

        def ==(money: Money) = {
          d * 100 + c == money.d * 100 + money.c
        }

        def unary_- = {
          Money(-d, -c)
        }

        override def toString: String = {
          var value = d + c / 100
          value.toString
        }
      }

      object Money {
        def apply(d: Int, c: Double) = {
          new Money(d, c)
        }
      }

      val m1 = Money(1, 75)
      println("\n" + m1)
      val m2 = Money(0, 50)
      println(m2)
      val m3 = Money(2, 25)
      println(m3)
      println(m1 + m2)
      println(m1 + m2 == m3)
      println(m2 - m1)
      println(m1 - m2)
      println(-m1)
    }
  )

  addQ()

  addQ()

  addQ(
    () => {
      class BigSequence {
        var seq = 0l

        def apply(index: Int) = {

        }

        def update(index: Int, value: Int) = {

        }
      }
    }
  )

  addQ(
    () => {
      class Matrix(val row: Int = 2, val col: Int = 2) {

        if (row <= 0 || col <= 0) {
          throw new Exception("Wrong parameter.")
        }

        val mat = Array.ofDim[Int](row, col)

        def set(value: Int) = {
          for (i <- 0 until row; j <- 0 until col) {
            mat(i)(j) = value
          }
        }

        def print() = {
          println("")
          for (i <- 0 until row) {
            var str = ""
            for (j <- 0 until col) {
              str += mat(i)(j).toString + " "
            }
            println(str)
          }
        }

        def apply(row: Int)(col: Int) = {
          mat(row)(col)
        }

        def update(row: Int, col: Int, value: Int) = {
          mat(row)(col) = value
        }

        def +(other: Matrix) = {

          if (mat.length != other.mat.length || mat(0).length != other.mat(0).length) {
            throw new Exception("Wrong operand.")
          }

          val row = mat.length
          val col = mat(0).length
          val newMat = new Matrix(row, col)

          for (i <- 0 until row; j <- 0 until col) {
            newMat(i, j) = mat(i)(j) + other(i)(j)
          }
          newMat
        }

        def *(other: Matrix) = {
          if (mat(0).length != other.mat.length) {
            throw new Exception("Wrong operation.")
          }

          val row = mat.length
          val oldRow = mat(0).length
          val col = other.mat(0).length
          val newMat = new Matrix(row, col)

          for (i <- 0 until row; j <- 0 until col) {
            var sum = 0
            for (c <- 0 until oldRow) {
              sum += mat(i)(c) * other.mat(c)(j)
            }

            newMat(i, j) = sum
          }
          newMat
        }
      }

      val mat1 = new Matrix
      mat1.set(3)
      mat1.print
      val mat2 = new Matrix(2, 2)
      val mat3 = mat1 + mat2
      println("\n" + mat1(0)(0))
      println(mat3(0)(0))

      val mat4 = new Matrix(2, 5)
      mat4.set(5)
      val mat5 = mat1 * mat4
      mat5.print
    }
  )

  addQ(
    () => {
      class RichFile {

      }

      object RichFile {

        def unapply(filePath: String) = {
          if (!filePath.contains(".") || !filePath.contains("/")) {
            None
          }
          else {
            val path = filePath.substring(0, filePath.lastIndexOf("/"))
            val name = filePath.substring(filePath.lastIndexOf("/") + 1, filePath.lastIndexOf("."))
            val extend = filePath.substring(filePath.lastIndexOf("."), filePath.length)
            Some((path, name, extend))
          }
        }
      }

      val RichFile(path, name, extend) = "/home/cay/readme.txt"
      println()
      println(path)
      println(name)
      println(extend)
    }
  )

  addQ(
    () => {
      class RichFile {

      }

      object RichFile {
        def unapplySeq(filePath: String): Option[Seq[String]] = {
          Some(filePath.split("/"))
        }
      }

      val RichFile(nil, path, name, extend) = "/home/cay/readme.txt"
      println()
      println(nil)
      println(path)
      println(name)
      println(extend)
    }
  )
}
