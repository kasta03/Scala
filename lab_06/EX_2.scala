/*
The goal is to write a covariant (therefore the name) container for a Pair of objects of the same type. Functionality as in example code.
class A{
override def toString: String = "A"
}
class B( val x: Int) extends A{
override def toString: String = "B:"+x.toString
}
class C( x: Int) extends B(x){
override def toString: String = "C:"+x.toString
}
val a: TwistedMonoPair[A] = TwistedMonoPair[A](new B(7), new A)
println(a(0))
println(a(1))
println(a)
val b: TwistedMonoPair[A] = TwistedMonoPair[B](new B(9), new B(77)) // covariantnes
println(b)
// val c: TwistedMonoPair[A] = new TwistedMonoPair[B](new B(9), new A) // should not compile,
covariantness
val d1 = b.replace(0)(new A) // conversion to TwistedMonoPair[A] and replacement of the first el. in
the pair
println(d1)
val tA : TwistedMonoPair[A] = d1
//val tB : TwistedMonoPair[B] = d1// can not compile
val d2 = b.replace(1)(new A) // as above, but replaced is the second el
println(d2)
*/

class TwistedMonoPair[+T](val first: T, val second: T) {
    def apply(index: Int) : T = index match {
        case 0 => first
        case 1 => second
    }

    override def toString: String = s"TwistedMonoPair($first, $second)"

    def replace[S >: T](index: Int)(newElem: S): TwistedMonoPair[S] = index match {
        case 0 => new TwistedMonoPair(newElem, second)
        case 1 => new TwistedMonoPair(first, newElem)
    }
}

object TwistedMonoPair {
  def apply[T](first: T, second: T): TwistedMonoPair[T] = new TwistedMonoPair(first, second)
}

class A {
  override def toString: String = "A"
}
class B(val x: Int) extends A {
  override def toString: String = "B:" + x.toString
}
class C(x: Int) extends B(x) {
  override def toString: String = "C:" + x.toString
}
val a: TwistedMonoPair[A] = TwistedMonoPair[A](new B(7), new A)
println(a(0))
println(a(1))
println(a)
val b: TwistedMonoPair[A] = TwistedMonoPair[B](new B(9), new B(77)) // covariantnes
println(b)
//val c: TwistedMonoPair[A] = TwistedMonoPair[B](new B(9), new A) // should not compile, covariantness
val d1 = b.replace(0)(new A) // conversion to TwistedMonoPair[A] and replacement of the first el. in the pair
println(d1)
val tA : TwistedMonoPair[A] = d1
//val tB : TwistedMonoPair[B] = d1// can not compile
val d2 = b.replace(1)(new A) // as above, but replaced is the second el
println(d2)
