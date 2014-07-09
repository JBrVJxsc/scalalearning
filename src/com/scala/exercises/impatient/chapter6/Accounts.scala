package com.scala.exercises.impatient.chapter6

/**
 * Created by Who on 14-7-9.
 */

class Accounts(val id: Int, initialBalance: Double) {
  private var balance = initialBalance

  def deposit(amount: Double) {
    balance += amount
  }
}

object Accounts {
  private var number = 0

  def newUniqueNumber() = {
    number += 1;
    number
  }

  def apply(initialBalance: Double) = {
    new Accounts(newUniqueNumber(), initialBalance)
  }
}
