object Main
{
    def dup(s: String, n: Int): String = 
    {
        @scala.annotation.tailrec
        def inner(times: Int, string: String): String = 
        {
        if (times < 0) string
        else inner(times - 1, string + s)
        }
        inner(n, "")
    }


    def main(args: Array[String]) : Unit = 
    {
    println(dup("Hola, Ciao, Czesc", 6))
    }

}