/*
The goal for the first exercise is to prepare two traits that will be used to add
additional info to printed messages.
• TimeStamp will prefix the printed message with the time stamp:
• val today = Calendar.getInstance().getTime() (from java.util.Calendar can be
used to obtain current time)
• The Quote trait that will wrap printed text in "".
• val logger = Loger with Quote with TimeStamp
• logger.pprint("Hello there")
• Tue Dec 01 14:13:23 CET 2017 "Hello world"
• The structure of classes should contain:
• abstract Base class - having an abstract pprint
• Quote trait - reimplementing pprint and calling base class pprint
• TimeStamp trait - -||-
• Logger class - reimplementing pprint
• Remember that "abstract override" needs to prefix pprint function in traits.
*/


import java.util.Calendar

abstract class Base {
  def pprint(string: String): Unit
}

trait TimeStamp extends Base {
  abstract override def pprint(string: String): Unit = {
    val today = Calendar.getInstance().getTime()
    super.pprint(s"$today $string")
  }
}

trait Quote extends Base {
  abstract override def pprint(string: String): Unit = {
    super.pprint(s"$string")
  }
}

class Logger extends Base {
  def pprint(string: String): Unit = {
    println(string)
  }
}

object Main extends App {
  val l = new Logger with Quote with TimeStamp
  l.pprint("Hello world")
  println("")
  val ql = new Logger with Quote
  ql.pprint("No date, just quote")
  println("")
  val tl = new Logger with TimeStamp
  tl.pprint("Some time stamped message")
  println("")
  val plain = new Logger
  plain.pprint("Just he text")
  println("")
}


// class A {
//   override def toString: String = "A"
// }

// class B(val x: Int) extends A {
//   override def toString: String = s"B:$x"
// }

// class C(x: Int) extends B(x) {
//   override def toString: String = s"C:$x"
// }

// class TwistedMonoPair[+T](val first: T, val second: T) {
//   override def toString: String = s"TwistedMonoPair($first, $second)"

//   def apply(index: Int): T = if (index == 0) first else if (index == 1) second else throw new IndexOutOfBoundsException

//   def replace[R >: T](index: Int)(newElem: R): TwistedMonoPair[R] =
//     if (index == 0) new TwistedMonoPair[R](newElem, second)
//     else if (index == 1) new TwistedMonoPair[R](first, newElem)
//     else throw new IndexOutOfBoundsException
// }

// object Main extends App {
//   val a: TwistedMonoPair[A] = new TwistedMonoPair[B](new B(7), new A)
//   println(a(0))
//   println(a(1))
//   println(a)

//   val b: TwistedMonoPair[A] = new TwistedMonoPair[B](new B(9), new B(77))
//   println(b)

//   // This line should not compile due to covariance
//   // val c: TwistedMonoPair[A] = new TwistedMonoPair[B](new B(9), new A)

//   val d1 = b.replace(0)(new A)
//   println(d1)
//   val tA: TwistedMonoPair[A] = d1

//   // This line should not compile due to covariance
//   // val tB: TwistedMonoPair[B] = d1

//   val d2 = b.replace(1)(new A)
//   println(d2)
// }
