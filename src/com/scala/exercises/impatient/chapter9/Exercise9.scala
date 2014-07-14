package com.scala.exercises.impatient.chapter9

import java.io.File

import com.scala.exercises.ScalaExercise
import com.scala.interfaces.Exercise

import scala.io.Source

/**
 * Created by Who on 14-7-11.
 */
class Exercise9 extends ScalaExercise with Exercise {
  override def getName: String = "Chapter9"

  addT(
    () => {
      val fileName = getClass.getResource("myfile.txt").getPath
      val source = Source.fromFile(fileName)
      val lineIterator = source.getLines()
      for (i <- lineIterator) {
        print(i)
      }

      val lines = source.getLines().toArray
      print(lines)

      val contents = source.mkString
      print(contents)

      source.close()
    }
  )

  addT(
    () => {
      val fileName = getClass.getResource("myfile.txt").getPath
      val source = Source.fromFile(fileName)

      val lines = source.getLines().toArray
      print(lines)

      source.close()
    }
  )

  addT(
    () => {
      val fileName = getClass.getResource("myfile.txt").getPath
      val source = Source.fromFile(fileName)

      val contents = source.mkString
      print(contents)

      source.close()
    }
  )

  addT(
    () => {
      val source = Source.fromURL("http://baidu.com")
      print(source.mkString)
      source.close()
    }
  )

  addT(
    () => {
      import scala.sys.process._
      // This line of code will print to the console directly.
      //"ls -al .." !
      print("ls -al .." !!)

      "ls -al .." #> new File("output.txt") !
    }
  )

  addQ(
    () => {
      val fileName = getClass.getResource("myfile.txt").getPath
      val source = Source.fromFile(fileName)
      var content = ""
      for (i <- source.getLines) {
        content = i + "\n" + content
      }
      print(content)
    }
  )

  addQ()

  addQ()

  addQ()

  addQ(
    () => {
      for (i <- 0 to 20) {
        print(math.pow(2, i), 1 / math.pow(2, i))
      }
    }
  )

  addQ()

  addQ()

  addQ()

  addQ()

  addQ()
}
