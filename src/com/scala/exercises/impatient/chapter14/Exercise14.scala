package com.scala.exercises.impatient.chapter14

import com.scala.exercises.ScalaExercise
import com.scala.interfaces.Exercise

/**
 * Created by Who on 2014/7/20.
 */
class Exercise14 extends ScalaExercise with Exercise {
  override def getName: String = "Chapter14"

  addT(
    () => {
      var sign = ""
      val ch = 'c'

      ch match {
        case '+' => sign = "+"
        case '-' => sign = "-"
        case _ => sign = "All"
      }

      print(sign)
    }
  )


  addT(
    () => {
      val ch = 'c'

      val sign = ch match {
        case '+' => "+"
        case '-' => "-"
        case _ => "All"
      }

      print(sign)
    }
  )

  addT(
    () => {
      val ch = '-'

      val sign = ch match {
        case '+' => "+"
        case _ => "All"
        // If _ is before some cases, then the cases below will not be apply.
        case '-' => "-"
      }

      print(sign)
    }
  )

  addT(
    () => {
      val ch = '8'

      val sign = ch match {
        case '+' => "+"
        case '-' => "-"
        // This is different with normal switch, because the later need more explicit tag such as '+' or '-' or any other chars.
        case _ if (Character.isDigit(ch)) => Character.digit(ch, 10)
        case _ => "All"
      }

      print(sign)
    }
  )

  addT(
    () => {
      val str = "12345, World!"
      var digit = 0

      str(0) match {
        case '+' => "+"
        case '-' => "-"
        case ch => digit = Character.digit(ch, 10)
        case _ => "All"
      }

      print(digit)
    }
  )

  addT(
    () => {
      val str: Any = "Hello"

      val result = str match {
        case i: Int => print("Int")
        case s: String => print("String")
      }

      print(result)
    }
  )

  addT(
    () => {
      val str: Any = "Hello"

      str match {
        case i: Int => print("Int")
        case s: String => print("String")
      }
    }
  )

  addT(
    () => {
      val arr = Array[Int](1, 2, 3, 4, 5);

      arr match {
        case Array(0) => print("0")
        case Array(x, y) => print(x + " " + y)
        case Array(0, _*) => print("0...")
        case _ => print(arr.mkString(","))
      }
    }
  )

  addT(
    () => {
      var list = 0 :: Nil
      for (i <- 1 to 10) {
        list ::= i
      }
      list match {
        case 9 :: t => print("Start from 9.")
        case 10 :: t => print("Start from 10.")
        case _ => print("Something else.")
      }
    }
  )

  addT(
    () => {
      val pair = (1, "2")
      pair match {
        case (i: Int, s: String) => print("Int with String")
      }
    }
  )
  addT(
    () => {
      val pair = (1, "2")
      pair match {
        case (1, s: String) => print(s)
      }
    }
  )

  addT(
    () => {
      val pair = (1, "2")
      pair match {
        case (1, s: String) => print("1 with something.")
      }
    }
  )


}
