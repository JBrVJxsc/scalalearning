package com.scala.exercises.impatient.chapter1

import com.scala.exercises.ScalaExercise
import com.scala.interfaces.Exercise

import scala.util.Random

/**
 * Created by Who on 2014/7/5.
 */
class Exercise1 extends ScalaExercise with Exercise {
  override def getName: String = "Chapter1"

  override def getSummary: String = "Chapter1"

  addQ()

  addQ(
    () => {
      val sqrt = math.sqrt(3)
      val power = math.pow(sqrt, 2)
      print(sqrt)
      print(power)
    }
  )

  addQ()

  addQ(
    () => {
      print("crazy" * 3)
    }
  )

  addQ(
    () => {
      print(10 max 2)
    }
  )

  addQ(
    () => {
      val bigInt: BigInt = 2
      print(bigInt.pow(1024))
    }
  )

  addQ(
    () => {
      print(BigInt.probablePrime(100, Random))
    }
  )

  addQ(
    () => {
      val bigInt: BigInt = Random.nextInt()
      print(bigInt.toString(32))
    }
  )

  addQ(
    () => {
      print("Hello, World!".head)
      print("Hello, World!".last)
    }
  )

  addQ(
    () => {
      print("Hello, World!".take(2))
      print("Hello, World!".takeRight(2))
      print("Hello, World!".drop(2))
      print("Hello, World!".dropRight(2))
    }
  )
}
