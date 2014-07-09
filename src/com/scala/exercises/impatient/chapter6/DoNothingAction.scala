package com.scala.exercises.impatient.chapter6

/**
 * Created by Who on 14-7-9.
 */
object DoNothingAction extends UndoableAction{
  override def undo(): Unit = ???

  override def redo(): Unit = ???
}
