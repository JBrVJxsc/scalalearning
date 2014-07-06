package com.scala.exercises.impatient.chapter4

import com.scala.exercises.ScalaExercise
import com.scala.interfaces.Exercise

/**
 * Created by Who on 2014/7/6.
 */
class Exercise4 extends ScalaExercise with Exercise {
  override def getName: String = "Chapter4"

  addT(
    () => {
      var scores = Map("Alice" -> 10, "Bob" -> 3, "Cindy" -> 8)
      scores = Map(("Alice()", 10), ("Bob()", 3), ("Cindy()", 8))
      print(scores)

      var scoresNew = scala.collection.mutable.Map("Alice" -> "10", "Bob" -> "3", "Cindy" -> "8")
      print(scoresNew)
      scoresNew("Alice") = "11"
      scoresNew("Alice2") = "12"
      print(scoresNew)
      print(scores.getOrElse("Alice2", 2))
      for (i <- scoresNew) {
        print(i._1 + " " + i._2)
      }

      for ((k, v) <- scoresNew) {
        print(k + " " + v)
      }

      val v = (
        "1", "2", "3"
        )
      print(v)
    }
  )

  addQ(
    () => {
      val prices = Map("A" -> 1, "B" -> 2, "C" -> 3, "D" -> 4, "E" -> 5)
      print(prices)
      val pricesNew = for ((k, v) <- prices) yield k -> v * 0.9
      print(pricesNew)
    }
  )

  addQ(
    () => {
      import scala.collection.mutable.Map
      val strs = Array[String]("A", "B", "A", "B", "A", "B", "C", "B", "C", "B", "D", "B", "D", "B")
      val map = Map[String, Int]()
      for (i <- strs) {
        if (map.contains(i)) {
          map(i) += 1
        }
        else {
          map += i -> 1
        }
      }
      print(map)
    }
  )

  addQ(
    () => {

    }
  )
}
