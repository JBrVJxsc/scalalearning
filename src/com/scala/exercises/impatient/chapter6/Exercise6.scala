package com.scala.exercises.impatient.chapter6

import java.awt.{Color, Point}

import com.scala.exercises.ScalaExercise
import com.scala.interfaces.Exercise

/**
 * Created by Who on 14-7-9.
 */
class Exercise6 extends ScalaExercise with Exercise {
  override def getName: String = "Chapter6"

  addT(
    () => {
      val accounts1 = new Accounts(1, 1.0)
      val accounts2 = new Accounts(2, 2.0)
      print(accounts1.id)
      print(accounts2.id)
    }
  )

  addT(
    () => {
      val actions = Map("open" -> DoNothingAction, "save" -> DoNothingAction)
      val acct = Accounts(1000.0)
    }
  )

  addT(
    () => {
      print(TrafficLightColor.Yellow)
      print(TrafficLightColor.Red.id)
      print(1)
      print(TrafficLightColor(0))
      print(TrafficLightColor(1).id)
    }
  )

  addQ(
    () => {
      object Conversions {
        def inchesToCentimeters(inches: Double): Double = {
          inches * 30.48
        }

        def gallonsToLiters(gallons: Double): Double = {
          gallons * 3.79
        }

        def milesToKilometers(miles: Double): Double = {
          miles * 1.61
        }
      }

      println("\n" + Conversions.inchesToCentimeters(1))
      println(Conversions.gallonsToLiters(1.0))
      println(Conversions.milesToKilometers(1.0))
    }
  )

  addQ(
    () => {
      abstract class UnitConversion {
        val rate: Double

        def apply(value: Double): Double = {
          convert(value)
        }

        def convert(value: Double): Double = {
          value * rate
        }
      }

      object InchesToCentimeters extends UnitConversion {
        override val rate: Double = 30.48
      }

      object GallonsToLiters extends UnitConversion {
        override val rate: Double = 3.79
      }

      object MilesToKilometers extends UnitConversion {
        override val rate: Double = 1.61
      }

      println("\n" + InchesToCentimeters(2))
      println(GallonsToLiters(2.0))
      println(MilesToKilometers(2.0))
      println("\n" + InchesToCentimeters.convert(2))
      println(GallonsToLiters.convert(2.0))
      println(MilesToKilometers.convert(2.0))
    }
  )

  addQ(
    () => {
      object Origin extends Point {

      }
    }
  )

  addQ(
    () => {
      class Point(x: Int, y: Int) {

      }

      object Point {
        def apply(x: Int, y: Int) = {
          new Point(x, y)
        }
      }
    }
  )

  addQ(
    () => {
      object Reverse extends App {
        for (i <- 0 until args.length reverse) {
          println(i)
        }
      }
    }
  )

  addQ(
    () => {
      object Poker extends Enumeration {
        val Club = Value("Club")
        val Diamond = Value("Diamond")
        val Heart = Value("Heart")
        val Spade = Value("Spade")
      }

      for (i <- Poker.values) {
        print(i)
      }
    }
  )

  addQ(
    () => {
      object Poker extends Enumeration {
        val Club = Value("Club")
        val Diamond = Value("Diamond")
        val Heart = Value("Heart")
        val Spade = Value("Spade")
      }

      val pokers = Array[Poker.Value](Poker.Club,Poker.Diamond,Poker.Heart,Poker.Spade)

      for (i <- pokers) {
        if (i == Poker.Heart || i == Poker.Diamond) {
          print("I found Red!")
        }
      }
    }
  )

  addQ(
    () => {
      object Cube extends Enumeration {
        val c1 = Value(Color.RED.getRGB)
        val c2 = Value(Color.GREEN.getRGB)
        val c3 = Value(Color.BLUE.getRGB)
        val c4 = Value(Color.GRAY.getRGB)
        val c5 = Value(Color.ORANGE.getRGB)
        val c6 = Value(Color.PINK.getRGB)
        val c7 = Value(Color.WHITE.getRGB)
        val c8 = Value(Color.YELLOW.getRGB)
      }

      for (i <- Cube.values) {
        print(i.id)
     }
    }
  )
}
