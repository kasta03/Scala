// object SeqPrinter {
//   def printSeq(start: Int, end: Int, step: Int = 1): Unit = {
//     if (start <= end) {
//       print(s"$start ")
//       printSeq(start + step, end, step)
//     }
//   }

//   def handleOneArg(N: Int): Unit = {
//     printSeq(0, N - 1)  // Adjusted for inclusive start and exclusive end
//   }

//   def handleTwoArgs(arg1: Int, arg2: Int): Unit = {
//     printSeq(arg1, arg2 - 1)  // Adjusted to make the end exclusive
//   }

//   def handleThreeArgs(arg1: Int, arg2: Int, arg3: Int): Unit = {
//     printSeq(arg1, arg2 - 1, arg3)  // Uses step argument
//   }

//   def main(args: Array[String]): Unit = {
//     args.length match {
//       case 1 => handleOneArg(args(0).toInt)
//       case 2 => handleTwoArgs(args(0).toInt, args(1).toInt)
//       case 3 => handleThreeArgs(args(0).toInt, args(1).toInt, args(2).toInt)
//       case _ => println("Invalid number of arguments.")
//     }
//   }
// }

object Main{
    def main(args: Array[String]): Unit = {
    val start = if (args.length > 1) args(0).toInt else 0
    val end = if (args.length > 0) args(1 % args.length).toInt else 0
    val step = if (args.length > 2) args(2).toInt else 1

    for (i <- start to end by step) print(s"$i ")
    println("")
    }
}