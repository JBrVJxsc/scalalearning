package com.scala.exercises.impatient.chapter5

import scala.collection.mutable.ArrayBuffer

/**
 * Created by Who on 2014/7/8.
 */
class Network {
  outerT =>

  val testSpliter = 0

  class TestOuter {
    def getTestOuterNumber = outerT.testOuterNumber
  }

  class TestOuterAgain {
    val t = outerT.testOuterNumber
  }

  private val members = new ArrayBuffer[Network.Member]

  val testOuterNumber = 10000


  def join(name: String) = {
    val m = new Network.Member(name)
    members += m
    m
  }

  def getTestOuter = new TestOuter
}

object Network {

  class Member(val name: String) {
    val contacts = new ArrayBuffer[Member]
  }
}
