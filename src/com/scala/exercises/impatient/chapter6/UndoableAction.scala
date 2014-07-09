package com.scala.exercises.impatient.chapter6

/**
 * Created by Who on 14-7-9.
 */
abstract class UndoableAction {

  def undo(): Unit

  def redo(): Unit
}
