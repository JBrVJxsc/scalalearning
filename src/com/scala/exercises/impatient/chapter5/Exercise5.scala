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
        private var balance = 0d

        def deposit(value: Double): Double = {
          if (value > 0) {
            balance += value
          }
          balance
        }

        def withdraw(value: Double): Double = {
          if (value <= balance) {
            balance -= value
          }

          balance
        }
      }

      val bankAccount = new BankAccount
      println(bankAccount.deposit(1000))
      println(bankAccount.withdraw(499))
    }
  )

  addQ(
    () => {

      class Time {
        private var hours = 0
        private var minutes = 0


        def this(hours: Int, minutes: Int) {
          this()
          if (hours < 0 || hours > 23 || minutes < 0 || minutes > 59) {
            throw new Exception("Wrong format of the Time.")
          }
          this.hours = hours
          this.minutes = minutes
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
      println(time1.before(time2))
      println(time1.before(time3))
      println(time2.before(time1))
      println(time3.before(time1))
      println(time2.before(time3))
    }
  )
}
