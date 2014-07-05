package com.scala.exercises

/**
 * Created by Who on 2014/7/5.
 */
abstract class ScalaExercise extends BaseExercise {

  override def run(): Unit = {
    runQuestions()
  }

  def runQuestions(): Unit = {
    val questions = questionArrayList.toArray()
    for (question <- questions) {
      print(question.asInstanceOf[Question].name)
      question.asInstanceOf[Question].answer()
      print()
    }
  }

  protected def addQ(name: String, answer: () => Unit) {
    questionArrayList.add(new Question(name, answer))
  }
}

class Question(val name: String, val answer: () => Unit) {

}
