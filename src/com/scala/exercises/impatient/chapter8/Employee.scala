package com.scala.exercises.impatient.chapter8

/**
 * Created by Who on 14-7-10.
 */
class Employee(name: String, age: Int, val salary: Double) extends Person(name, age) {

  override def toString(): String = {
    super.toString() + " " + salary
  }
}
