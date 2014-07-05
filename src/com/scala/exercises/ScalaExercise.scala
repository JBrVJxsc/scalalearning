package com.scala.exercises

import scala.collection.mutable.ArrayBuffer

/**
 * Created by Who on 2014/7/5.
 */
abstract class ScalaExercise extends BaseExercise {

  val questionList: ArrayBuffer[Question] = ArrayBuffer[Question]()

  override def run(): Unit = {
    runQuestions()
  }

  def runQuestions(): Unit = {
    for (question <- questionList) {
      print(question.asInstanceOf[Question].name)
      question.asInstanceOf[Question].answer()
      print()
    }
  }

  protected def addQ(name: String, answer: () => Unit) {
    questionList += new Question(name, answer)
  }
}

class Question(val name: String, val answer: () => Unit) {

}