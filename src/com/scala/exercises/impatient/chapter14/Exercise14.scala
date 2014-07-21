package com.scala.exercises.impatient.chapter14

import com.scala.exercises.ScalaExercise
import com.scala.interfaces.Exercise

/**
 * Created by Who on 2014/7/20.
 */
class Exercise14 extends ScalaExercise with Exercise {
  override def getName: String = "Chapter14"

  addT(
    () => {
      var sign = ""
      val ch = 'c'

      ch match {
        case '+' => sign = "+"
        case '-' => sign = "-"
        case _ => sign = "All"
      }

      print(sign)
    }
  )


  addT(
    () => {
      val ch = 'c'

      val sign = ch match {
        case '+' => "+"
        case '-' => "-"
        case _ => "All"
      }

      print(sign)
    }
  )

  addT(
    () => {
      val ch = '-'

      val sign = ch match {
        case '+' => "+"
        case _ => "All"
        // If _ is before some cases, then the cases below will not be apply.
        case '-' => "-"
      }

      print(sign)
    }
  )

  addT(
    () => {
      val ch = '8'

      val sign = ch match {
        case '+' => "+"
        case '-' => "-"
        // This is different with normal switch, because the later need more explicit tag such as '+' or '-' or any other chars.
        case _ if (Character.isDigit(ch)) => Character.digit(ch, 10)
        case _ => "All"
      }

      print(sign)
    }
  )

  addT(
    () => {
      val str = "12345, World!"
      var digit = 0

      str(0) match {
        case '+' => "+"
        case '-' => "-"
        case ch => digit = Character.digit(ch, 10)
        case _ => "All"
      }

      print(digit)
    }
  )

  addT(
    () => {
      val str: Any = "Hello"

      val result = str match {
        case i: Int => print("Int")
        case s: String => print("String")
      }

      print(result)
    }
  )

  addT(
    () => {
      val str: Any = "Hello"

      str match {
        case i: Int => print("Int")
        case s: String => print("String")
      }
    }
  )

  addT(
    () => {
      val arr = Array[Int](1, 2, 3, 4, 5);

      arr match {
        case Array(0) => print("0")
        case Array(x, y) => print(x + " " + y)
        case Array(0, _*) => print("0...")
        case _ => print(arr.mkString(","))
      }
    }
  )

  addT(
    () => {
      var list = 0 :: Nil
      for (i <- 1 to 10) {
        list ::= i
      }
      list match {
        case 9 :: t => print("Start from 9.")
        case 10 :: t => print("Start from 10.")
        case _ => print("Something else.")
      }
    }
  )

  addT(
    () => {
      val pair = (1, "2")
      pair match {
        case (i: Int, s: String) => print("Int with String")
      }
    }
  )
  addT(
    () => {
      val pair = (1, "2")
      pair match {
        case (1, s: String) => print(s)
      }
    }
  )

  addT(
    () => {
      val pair = (1, "2")
      pair match {
        case (1, s: String) => print("1 with something.")
      }
    }
  )

  addT(
    () => {
      val (x, y) = (1, 2)
      print(x + " " + y)
    }
  )

  addT(
    () => {
      val (q, r) = BigInt(10) /% 3
      print(q + " " + r)
    }
  )

  addT(
    () => {
      import scala.collection.JavaConversions.propertiesAsScalaMap

      for ((k, v) <- System.getProperties()) {
        print(k + " -> " + v)
      }
    }
  )

  addT(
    () => {
      import scala.collection.JavaConversions.propertiesAsScalaMap

      for ((k, "") <- System.getProperties()) {
        print(k + " -> ")
      }
    }
  )

  addT(
    () => {
      import scala.collection.JavaConversions.propertiesAsScalaMap

      for ((k, v) <- System.getProperties() if v == "") {
        print(k + " -> ")
      }
    }
  )

  addT(
    () => {
      case class Currency(name: String, price: Double = 1.0) {

      }

      val c = Currency("CNY", 6.2)
      val d = Currency("Dollar")
      println()
      println(c.name + " " + c.price)
      println(d.name + " " + d.price)
      val cc = c.copy()
      println(cc.toString)

      cc match {
        case Currency("CNY", y) => println("CNY!")
      }

      cc match {
        case Currency(x, y) => println(x + " " + y)
      }
    }
  )

  addT(
    () => {
      // Do not know why there is a wrong line under the List[E].
      //      case class ::[E](head: E, tail: List[E]) extends List[E]
    }
  )

  addT(
    () => {
      case object +: {
        def upapply[T](input: List[T]) = {
          if (input.isEmpty) None else Some((input.head, input.tail))
        }
      }

      println()
      println(2 +: 1 +: Nil)

      //      1 +: 7 +: 2 +: 9 +: Nil match {
      //        case first +: second +: rest => println(first + ", " + second + ", " + rest)
      //      }
    }
  )

  addT(
    () => {
      println()
      abstract class Item
      case class Article(description: String, price: Double) extends Item
      case class Bundle(description: String, discount: Double, items: Item*) extends Item

      val bundle = Bundle("ThisYear", 20.0, Article("1", 15.0), Article("2", 15.0), Article("3", 15.0), Article("4", 15.0))
      val item: Item = Article("5", 10.0)

      bundle match {
        case Bundle(_, _, Article(descr, _), _*) => println(descr)
      }

      bundle match {
        case Bundle(_, _, first@Article(_, _), _*) => println(first.description)
      }

      bundle match {
        case Bundle(_, _, first@Article(_, _)) => println(first.description)
        case _ => println("None")
      }

      // My implementation.
      //      def price(item: Item): Double = item match {
      //        case article: Article => article.price
      //        case bundle: Bundle => bundle.items.map(price(_)).sum - bundle.discount
      //      }

      // Book's implementation.
      def price(item: Item): Double = item match {
        case Article(_, p) => p
        case Bundle(_, dis@_, list@_*) => list.map(price _).sum - dis
      }

      println("The bundle's price is " + price(bundle) + ".")

      val isArticle = item match {
        case _: Article => true
        case _ => false
      }

      println()
      println("item is an Article is " + isArticle.toString + ".")
    }
  )

  addT(
    () => {
      val amount = new Dollar(100.0)

      amount match {
        case Dollar(_) =>
      }
    }
  )

  addT(
    () => {
      Some("String")
    }
  )

  addT(
    () => {
      val f: PartialFunction[Char, Int] = {
        case '+' => 1
        case '-' => -1
      }

      println()
      println(f('+'))
      println(f('-'))
      println(f.isDefinedAt('0'))
      // There will be an exception.
      //      println(f('0'))
    }
  )

  addQ()

  addQ(
    () => {
      def swap[T1, T2](t: Tuple2[T1, T2]): Tuple2[T2, T1] = t match {
        case (x, y) => (y, x)
      }

      print(swap((1, 2)))
    }
  )

  addQ(
    () => {
      def swap(a: Array[Any]) = a match {
        case Array(x, y) => throw new Exception
        case Array(x, y, _*) => {
          var an: Array[Any] = Array()
          for (i <- a.drop(2) reverse) {
            an +:= i
          }
          an +:= x
          an +:= y
          an
        }
      }

      val a: Array[Any] = Array(1, 2, 3, 4, 5)
      print(swap(a).mkString(","))
      val b: Array[Any] = Array(1, 2)
      // This line will throw an exception.
      //      print(swap(b).mkString(","))
    }
  )

  addQ(
    () => {
      sealed abstract class Item
      case class Article(description: String, val price: Double) extends Item
      case class Bundle(description: String, discount: Double, items: Item*) extends Item
      case class Multiple(number: Int, item: Item) extends Item

      def price(item: Item): Double = item match {
        case Article(_, p) => p
        case Bundle(_, discount, items@_*) => items.map(price _).sum - discount
        case Multiple(n, i) => n * (price(i))
      }

      val a1 = Article("a1", 10.0)
      val a2 = Article("a2", 20.0)
      val m1 = Multiple(2, a1)
      val m2 = Multiple(2, a2)
      val b1 = Bundle("b1", 15.0, a1, a2, m1, m2)
      println()
      println(price(b1))
    }
  )

  addQ()

  addQ(
    () => {
      sealed abstract class BinaryTree
      case class Leaf(value: Int) extends BinaryTree
      case class Node(left: BinaryTree, right: BinaryTree) extends BinaryTree

      def sum(tree: BinaryTree): Int = tree match {
        case Leaf(value) => value
        case Node(left, right) => sum(left) + sum(right)
      }

      val root = Node(Node(Leaf(10), Node(Node(Leaf(5), Node(Leaf(2), Leaf(3))), Leaf(7))), Node(Leaf(10), Node(Node(Leaf(5), Node(Leaf(2), Leaf(3))), Leaf(7))))
      println()
      println(sum(root))
    }
  )

  addQ(
    () => {
      sealed abstract class BinaryTree
      case class Leaf(value: Int) extends BinaryTree
      case class Node(nodes: BinaryTree*) extends BinaryTree

      def sum(tree: BinaryTree): Int = tree match {
        case Leaf(value) => value
        case Node(nodes@_*) => nodes.map(sum _).sum
      }

      val root = Node(Node(Leaf(10), Node(Node(Leaf(5), Node(Leaf(2), Leaf(3))), Leaf(7))), Node(Leaf(10), Node(Node(Leaf(5), Node(Leaf(2), Leaf(3))), Leaf(7))))
      println()
      println(sum(root))

      val t = Node(Node(Leaf(3), Leaf(8)), Leaf(2), Node(Leaf(5)))
      println(sum(t))
    }
  )
  addQ(
    () => {
      sealed abstract class BinaryTree
      case class Leaf(value: Int) extends BinaryTree
      case class Node(operator: Char, nodes: BinaryTree*) extends BinaryTree

      def sum(tree: BinaryTree): Int = tree match {
        case Leaf(value) => value
        case Node(o, nodes@_*) => o match {
          case '+' => nodes.map(sum _).sum
          case '-' => -nodes.map(sum _).sum
          case '*' => nodes.map(sum _).reduceLeft(_ * _)
        }
      }

      val t = Node('+', Node('*', Leaf(3), Leaf(8)), Leaf(2), Node('-', Leaf(5)))
      println()
      println(sum(t))
    }
  )

  addQ(
    () => {
      def sum(list: List[Option[Int]]) = {
        var result = 0
        for (o <- list) {
          if (!o.getClass.equals(None)) {
            result += o.sum
          }
        }
        result
      }

      val list = List(Some(1), Some(1), Some(1), Some(1), None, Some(3), None)
      print(sum(list))
    }
  )

  addQ(
    () => {
      def compose(fun1: Double => Option[Double], fun2: Double => Option[Double]): Double => Option[Double] = {
        // Another way to implement.
        //        def composed(value: Double): Option[Double] = {
        //          val result1 = fun1(value)
        //          val result2 = fun2(value)
        //          if (result1.equals(None)) None
        //          else {
        //            if (result2.sum < 0) None
        //            else result2
        //          }
        //        }
        //
        //        composed _

        (value: Double) => {
          val result1 = fun1(value)
          val result2 = fun2(value)
          if (result1.equals(None)) None
          else {
            if (result2.sum < 0) None
            else result2
          }
        }
      }

      def f(x: Double): Option[Double] = {
        if (x >= 0) Some(math.sqrt(x)) else None
      }

      def g(x: Double): Option[Double] = {
        if (x != 1) Some(1 / (x - 1)) else None
      }

      val h = compose(f, g)
      print(h(2))
      print(h(1))
      print(h(0))
    }
  )
}
