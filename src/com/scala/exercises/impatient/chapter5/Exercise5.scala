package com.scala.exercises.impatient.chapter5

import com.scala.exercises.ScalaExercise
import com.scala.interfaces.Exercise

/**
 * Created by Who on 2014/7/7.
 */
class Exercise5 extends ScalaExercise with Exercise {
  override def getName: String = "Chapter5"

  addT(
    () => {
      val myCounter = new Counter
      myCounter.increment()
      print(myCounter.current)
    }
  )

  addT(
    () => {
      val person = new Person("Xu ZHANG")
      person.age = 100
      print(person.age)
    }
  )

  addT(
    () => {
      val chatter = new Network
      val myFace = new Network
      val fred = chatter.join("Fred")
      val wilma = chatter.join("Wilma")
      fred.contacts += wilma
      val barney = myFace.join("Barney")
      fred.contacts += barney
    }
  )

  addT(
    () => {
      val testOuter = (new Network).getTestOuter.getTestOuterNumber
      print(testOuter)
    }
  )

  addQ(
    () => {
      class Counter {
        private var value = 0

        def increment() =
          if (value != Int.MaxValue) {
            value += 1
          }

        def getValue = value
      }
    }
  )

  addQ(
    () => {

      class BankAccount {
        private var balanceValue = 0d

        def balance = balanceValue

        def deposit(value: Double) = {
          if (value > 0) {
            balanceValue += value
          }
        }

        def withdraw(value: Double) = {
          if (value <= balanceValue) {
            balanceValue -= value
          }
        }
      }

      val bankAccount = new BankAccount
      bankAccount.deposit(1000)
      println("\n" + bankAccount.balance)
      bankAccount.withdraw(499)
      println(bankAccount.balance)
    }
  )

  addQ(
    () => {

      class Time(val hours: Int, val minutes: Int) {

        if (hours < 0 || hours > 23 || minutes < 0 || minutes > 59) {
          throw new Exception("Wrong format of the Time.")
        }

        def before(other: Time): Boolean = {
          if (hours < other.hours) {
            true
          }
          else if (hours > other.hours) {
            false
          }
          else {
            if (minutes < other.minutes) {
              true
            }
            else {
              false
            }
          }
        }
      }


      val time1 = new Time(22, 22)
      val time2 = new Time(21, 22)
      val time3 = new Time(22, 21)
      println("\n" + time1.before(time2))
      println(time1.before(time3))
      println(time2.before(time1))
      println(time3.before(time1))
      println(time2.before(time3))
    }
  )

  addQ(
    () => {
      class Time(val hours: Int, val minutes: Int) {
        private var minutesFormat = 0

        if (hours < 0 || hours > 23 || minutes < 0 || minutes > 59) {
          throw new Exception("Wrong format of the Time.")
        }
        minutesFormat = hours * 60 + minutes - 1

        def before(other: Time): Boolean = {
          minutesFormat < other.minutesFormat
        }
      }

      val time1 = new Time(22, 22)
      val time2 = new Time(21, 22)
      val time3 = new Time(22, 21)
      println("\n" + time1.before(time2))
      println(time1.before(time3))
      println(time2.before(time1))
      println(time3.before(time1))
      println(time2.before(time3))
    }
  )

  addQ()

  addQ(
    () => {
      class Person(private var age: Int) {
        if (age < 0) {
          age = 0
        }

        def getAge = age
      }

      val p = new Person(-10)
      println("\n" + p.getAge)
    }
  )

  addQ(
    () => {
      class Person(name: String) {
        println("\n" + "My name is " + name.split(" ")(0) + " " + name.split(" ")(1))
      }

      val p = new Person("Xu ZHANG")
    }
  )

  addQ(
    () => {

      class Car {
        def this(producer: String, model: String) {
          this()
        }

        def this(producer: String, model: String, year: Int) {
          this(producer, model)
        }

        def this(producer: String, model: String, year: Int = -1, number: String = "") {
          this(producer, model, year)
        }
      }
    }
  )

  addQ()

  addQ(
    () => {
      class Employee {
        val name = "John Q. Public"
        var salary = 0.0

        def this(name: String, salary: Double) {
          this()
        }
      }
    }
  )
}
