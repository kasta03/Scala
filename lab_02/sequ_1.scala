object seq
{
    def fun_1(N : Int): Int =
    {
        if (N <= 1)
        {
            println(N: Int)
        }
        else 
        {
            N * fun_1(N - 1)
            println(N: Int)
        }
        N - 1
    } 
    def fun_2(arg_1 : Int, arg_2 : Int): Int =
    {
        if (arg_1 == arg_2)
        {
        println(arg_1)
        }
        else 
        {
            arg_1 * fun_1(arg_1 + 1)
            println(arg_1)
        }
        arg_1 - 1
    }
    def fun_3(arg_1 : Int, arg_2 : Int, arg_3 : Int): Int =
    {
        if (arg_1 == arg_2)
        {
        println(arg_1)
        }
        else 
        {
            arg_1 * fun_1(arg_1 + arg_3)
            println(arg_1)
        }
        arg_1 + arg_2
    }
    def main(args: Array[String]): Unit =
    {
        val arg_1 = args(1).toInt
        val arg_2 = args(2).toInt
        val arg_3 = args(3).toInt
        if(args.length == 1)
        {
            fun_1(arg_1)
        }
        else if(args.length == 2)
        {
            fun_2(arg_1, arg_2)
        }
        else 
        {
            fun_3(arg_1, arg_2, arg_3)
        }
    }
}

