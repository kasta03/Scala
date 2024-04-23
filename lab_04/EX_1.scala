object pureFunctions
{
    def verb(f : Int => Int, x : Int ) : Int = 
        {
            val result_of_invocation = f(x)
            println(s"$x => $result_of_invocation ")
            return result_of_invocation
        } 

    def f(x: Int) : Int =
    {
        x + 7
    }

    def repN(n: Int, f: Int => Int, x: Int): Int = 
    {
    if (n <= 0) x
    else repN(n - 1, f, f(x))
    }
    
    def gt(x : Double, y : Double) : Boolean = 
    {
    return x > y
    }


    def neg = gt(0, _)
    def pos = gt(_, 0)

    def inrange(x: Double, y: Double)(value: Double): Boolean = gt(x, value) && gt(y, value)


    def main(args: Array[String]): Unit =
    {
        val a = f(3)
        println(s"a = $a") 

        val b = verb(f, 3) 
        println(s"b = $b") 

        println(repN(5, (x: Int) => 2*x , 1 ))

        println(neg(-20)) 
        println(pos(20))
        println()

        println(inrange(0,1)(0.5))

        println(inrange(0,1)(1))

        println(inrange(0,1)(2))

    }
}