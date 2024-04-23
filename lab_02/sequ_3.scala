object Main {
  def main(args: Array[String]): Unit = {
    if (args.length == 1) {
      for(x <- 0 to args(0).toInt) {
        println(x)
      }
    } else if (args.length == 2) {
      for(x <- args(0).toInt to args(1).toInt) {
        println(x)
      }
    } else if (args.length == 3) {
      for(x <- Range(args(0).toInt, args(1).toInt, args(2).toInt)) {
        println(x)
      }
    } else {
      println("You entered the wrong number of arguments. Try again!")
    }
  }
}
// object SeqPrinter extends App {
//   args.length match {
//     case 1 =>
//       Range.inclusive(0, args(0).toInt).foreach(i => print(s"$i "))
//     case 2 =>
//       Range.inclusive(args(0).toInt, args(1).toInt).foreach(i => print(s"$i "))

//     case 3 =>
//       Range(args(0).toInt, args(1).toInt + 1, args(2).toInt).foreach(i => print(s"$i "))

//     case _ =>
//       println("Invalid number of arguments. Provide up to three integers.")
//   }
//   println()
// }