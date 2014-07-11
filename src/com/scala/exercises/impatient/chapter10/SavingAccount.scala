package com.scala.exercises.impatient.chapter10

/**
 * Created by Who on 14-7-12.
 */
class SavingAccount extends Account with Logged{

  def withdraw(amount: Double) {
    if (amount > balance) {
      log("Insufficient funds")
    }
  }

  override def log(msg: String): Unit = {}

}
