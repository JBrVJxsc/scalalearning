package com.scala.exercises.impatient.chapter8

/**
 * Created by Who on 14-7-10.
 */
class Ant extends Creature {
//  override val range = 2
  // If I use the def, there is no need to use the second define style like AntPlus.
  override def range = 2
}

class AntPlus extends {
  override val range = 2
} with Creature