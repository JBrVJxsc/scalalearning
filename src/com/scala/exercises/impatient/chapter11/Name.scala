package com.scala.exercises.impatient.chapter11

/**
 * Created by Who on 14-7-13.
 */
object Name {
//  def unapply(str: String) = {
//    val strs = str.split(" ")
//    if (strs.length == 1) None else Some((strs(0), strs(1)))
//  }

  def unapplySeq(str: String): Option[Seq[String]] = {
    if (str.trim == "") None else Some(str.trim.split(" "))
  }
}
