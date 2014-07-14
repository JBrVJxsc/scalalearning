package com.scala.exercises.impatient.chapter10

import java.awt.geom.Ellipse2D
import java.io.InputStream
import java.util.regex.Pattern

import com.scala.exercises.ScalaExercise
import com.scala.interfaces.Exercise

/**
 * Created by Who on 14-7-11.
 */
class Exercise10 extends ScalaExercise with Exercise {
  override def getName: String = "Chapter10"

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

  addT(
    () => {
      trait WithMe {
        def p = {
          println("\nWith Me.")
        }
      }

      val account = new Account with WithMe
      account.p
    }
  )

  addQ(
    () => {
      trait RectangleLike {
        this: Ellipse2D =>

        def translate(dx: Double, dy: Double) = {
          var oldv: Double = this.getX
          var newv: Double = oldv + dx
          if (dx < 0) {
            if (newv > oldv) {
              if (getWidth >= 0) {
                updateWidth(getWidth + newv - Double.MinValue)
              }
              newv = Double.MinValue
            }
          }
          else {
            if (newv < oldv) {
              if (getWidth >= 0) {
                updateWidth(getWidth + newv - Double.MaxValue)
                if (getWidth < 0) updateWidth(Double.MaxValue)
              }
              newv = Double.MaxValue
            }
          }
          updateX(newv)
          oldv = getY
          newv = oldv + dy
          if (dy < 0) {
            if (newv > oldv) {
              if (getHeight >= 0) {
                updateHeight(getHeight + newv - Double.MinValue)
              }
              newv = Double.MinValue
            }
          }
          else {
            if (newv < oldv) {
              if (getHeight >= 0) {
                updateHeight(getHeight + newv - Double.MaxValue)
                if (getHeight < 0) updateHeight(Double.MaxValue)
              }
              newv = Double.MaxValue
            }
          }
          updateY(newv)
        }

        def grow(h: Double, v: Double) {
          var x0: Double = getX
          var y0: Double = getY
          var x1: Double = getWidth
          var y1: Double = getHeight
          x1 += x0
          y1 += y0
          x0 -= h
          y0 -= v
          x1 += h
          y1 += v
          if (x1 < x0) {
            x1 -= x0
            if (x1 < Double.MinValue) x1 = Double.MinValue
            if (x0 < Double.MinValue) x0 = Double.MinValue
            else if (x0 > Double.MaxValue) x0 = Double.MaxValue
          }
          else {
            if (x0 < Double.MinValue) x0 = Double.MinValue
            else if (x0 > Double.MaxValue) x0 = Double.MaxValue
            x1 -= x0
            if (x1 < Double.MinValue) x1 = Double.MinValue
            else if (x1 > Double.MaxValue) x1 = Double.MaxValue
          }
          if (y1 < y0) {
            y1 -= y0
            if (y1 < Double.MinValue) y1 = Double.MinValue
            if (y0 < Double.MinValue) y0 = Double.MinValue
            else if (y0 > Double.MaxValue) y0 = Double.MaxValue
          }
          else {
            if (y0 < Double.MinValue) y0 = Double.MinValue
            else if (y0 > Double.MaxValue) y0 = Double.MaxValue
            y1 -= y0
            if (y1 < Double.MinValue) y1 = Double.MinValue
            else if (y1 > Double.MaxValue) y1 = Double.MaxValue
          }
          setFrame(x0, y0, x1, y1)
        }

        def updateX(x: Double) = {
          setFrame(x, getY, getWidth, getHeight)
        }

        def updateY(y: Double) = {
          setFrame(getX, y, getWidth, getHeight)
        }

        def updateWidth(width: Double) = {
          setFrame(getX, getY, width, getHeight)
        }

        def updateHeight(height: Double) = {
          setFrame(getX, getY, getWidth, height)
        }
      }

      val egg = new Ellipse2D.Double(5, 10, 20, 30) with RectangleLike
      egg.translate(1, 1)
      println("\n" + egg.x + " " + egg.y + " " + egg.width + " " + egg.height)
      egg.grow(1, 1)
      println(egg.x + " " + egg.y + " " + egg.width + " " + egg.height)
    }
  )

  addQ()

  addQ()

  addQ(
    () => {
      class CrypoLogger {
        def log(msg: String) = {
          val e = Caesar.caesarEncryption(msg)
          println("\n" + e)
          println(Caesar.caesarDecryption(e))
        }
      }

      (new CrypoLogger).log("Hello")
    }
  )

  addQ()

  addQ()

  addQ()

  addQ()

  addQ()

  addQ(
    () => {
      class IterableInputStream extends InputStream with Iterable[Byte]{
        override def read(): Int = ???

        override def iterator: Iterator[Byte] = ???
      }
    }
  )
}
