package com.scala.exercises.impatient.chapter5

/**
 * Created by Who on 2014/7/8.
 */
class Person(var nameN: String, var ageN: Int = 20) {
  private var name = ""
  private var privateAge = 0

  // Because the class has provided the constructor (behind the class name), so there is no place for the constructors below, unless you got
  // different constructors like with different parameters.
//  def this(name: String) {
//    this()
//    this.name = name
//  }

//  def this(name: String, age: Int) {
//    this(name)
//    this.age = age
//  }

  def age = privateAge

  def age_=(newValue: Int) {
    if (newValue > privateAge) {
      privateAge = newValue
    }
  }

  // This line of code will force the class into infinity loop.
//  var person = new Person("Xu ZHANG")
}
