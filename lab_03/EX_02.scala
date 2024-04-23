/*
Write a two functions taking an integer argument that increase or
decrease argument value by 1: increase, and decrease. Test them!
Then write a function compose that takes as a first argument the function of
this kind: Int => Int, and returns a function that is n-composition of
it.
val i2 = compose(increase, 2) -> would be identical to:
def i2(x:Int) = increase(increase(x))
val d3 = compose(decrease, 3) -> would be identical to:
def d3(x:Int) = decrease(decrease(decrease(x)))
*/

object Main {
    def increase(x: Int): Int = x + 1
    def decrease(x: Int): Int = x - 1

    def compose(f: Int => Int, n: Int): Int => Int = 
    {
      if (n <= 0) (x: Int) => x
      else (x: Int) => compose(f, n-1)(f(x))
    }
  def main(args: Array[String]): Unit = 
{
    val first = compose(increase, 2)
    val second = compose(decrease, 3)
    println(first(5))
    println(second(12))
  }
}