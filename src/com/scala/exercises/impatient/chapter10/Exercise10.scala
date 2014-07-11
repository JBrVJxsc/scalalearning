package com.scala.exercises.impatient.chapter10

import com.scala.exercises.ScalaExercise
import com.scala.interfaces.Exercise

/**
 * Created by Who on 14-7-11.
 */
class Exercise10 extends ScalaExercise with Exercise{
  override def getName: String = "Exercise10"

  addT(
    () => {
      val acct = new SavingAccount
      acct.withdraw(100.0)
    }
  )

  addT(
    () => {
      val acct = new SavingAccount with ConsoleLoggerTrait
      acct.withdraw(100.0)
    }
  )

  addT(
    () => {
      val acct = new SavingAccount with ConsoleLoggerTrait with TimestampLoggerTrait with ShortLoggerTrait
      acct.withdraw(100.0)
    }
  )

  addT(
    () => {
      val acct = new SavingAccount with ConsoleLoggerTrait with ShortLoggerTrait with TimestampLoggerTrait
      acct.withdraw(100.0)
    }
  )
}
