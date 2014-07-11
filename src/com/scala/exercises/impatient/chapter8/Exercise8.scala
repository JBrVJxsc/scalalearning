package com.scala.exercises.impatient.chapter8

import java.awt.{Rectangle, Point}

import com.scala.exercises.ScalaExercise
import com.scala.interfaces.Exercise

import scala.collection.mutable.ArrayBuffer

/**
 * Created by Who on 14-7-10.
 */
class Exercise8 extends ScalaExercise with Exercise {
  override def getName: String = "Exercise8"

  addT(
    () => {
      val p = new Employee("Xu ZHANG", 26, 1.0)
      if (p.isInstanceOf[Employee]) {
        val np = p.asInstanceOf[Employee]
        print(np)
      }
    }
  )

  addT(
    () => {
      val alien = new Person("Fred", 199) {
        def greeting = "Hello everyone."
      }

      println("\n" + alien.greeting)
    }
  )

  addT(
    () => {
      val ant = new Ant
      val antPlus = new AntPlus
      print(ant.env.length)
      print(antPlus.env.length)
    }
  )

  addQ(
    () => {
      class BankAccount(initialBalance: Double) {
        private var balance = initialBalance

        def deposit(amount: Double) = {
          balance += amount;
          balance
        }

        def withdraw(amount: Double) = {
          balance -= amount;
          balance
        }
      }

      class CheckingAccount(initialBalance: Double) extends BankAccount(initialBalance) {

        override def deposit(amount: Double) = {
          super.deposit(amount - 1)
        }

        override def withdraw(amount: Double) = {
          super.withdraw(amount + 1)
        }
      }
    }
  )

  addQ(
    () => {
      class BankAccount(initialBalance: Double) {
        private var balance = initialBalance

        def deposit(amount: Double) = {
          balance += amount;
          balance
        }

        def withdraw(amount: Double) = {
          balance -= amount;
          balance
        }
      }

      class CheckingAccount(initialBalance: Double) extends BankAccount(initialBalance) {

        override def deposit(amount: Double) = {
          super.deposit(amount - 1)
        }

        override def withdraw(amount: Double) = {
          super.withdraw(amount + 1)
        }
      }

      class SavingAccount(initialBalance: Double) extends CheckingAccount(initialBalance) {
        var freeTimes = 3

        def discount = if (freeTimes > 0) 1 else 0

        override def deposit(amount: Double) = {
          super.deposit(amount + discount)
        }

        override def withdraw(amount: Double) = {
          super.deposit(amount - discount)
        }

        def earnMonthlyInterest() {
          freeTimes = 3
        }
      }
    }
  )

  addQ()

  addQ(
    () => {
      abstract class Item {
        def price: Double

        def description: String

        override def toString = description
      }

      class SimpleItem() extends Item {

        private var itemPrice = 0.0

        private var itemDescription = ""

        def price = itemPrice

        def description = itemDescription

        def this(price: Double, description: String) {
          this()
          itemPrice = price
          itemDescription = description
        }
      }

      class Bundle extends Item {

        private val items = new ArrayBuffer[Item]

        override def price = {
          var priceAll = 0.0
          for (i <- items) {
            priceAll += i.price
          }
          priceAll
        }

        override def description = items.mkString(",")

        def addItem(item: Item) {
          items += item
        }
      }

      val bundle = new Bundle
      bundle.addItem(new SimpleItem(1.0, "A"))
      bundle.addItem(new SimpleItem(2.0, "B"))
      bundle.addItem(new SimpleItem(3.0, "C"))

      println("\n" + bundle.price)
      println(bundle.description)
    }
  )

  addQ(
    () => {
      class Point(x: Int, y: Int) {

      }

      class LabeledPoint(label: String, x: Int, y: Int) extends Point(x, y) {

      }
    }
  )

  addQ(
    () => {
      abstract class Shape {
        def centerPoint: Point
      }

      class Rectangle extends Shape {
        def centerPoint(): Point = {
          null
        }
      }

      class Circle extends Shape {
        def centerPoint(): Point = {
          null
        }
      }
    }
  )

  addQ(
    () => {
      class Square(original: Point = new Point(0, 0), width: Double = 0.0) extends Rectangle {

      }
    }
  )

  addQ()

  addQ()

  addQ()
}
