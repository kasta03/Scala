object SeqPrinter extends App
{
  val start = if (args.length > 1) args(0).toInt else 0
  val end = if (args.length > 0) args(1 % args.length).toInt else 0
  val step = if (args.length > 2) args(2).toInt else 1

  for (i <- start to end by step) print(s"$i ")
}