import math._
object PI {
  case class Angle(val radians: Double) {
    val norm = {
      val mod = radians % (2 * Pi)
      if (mod > Pi) mod - 2 * Pi
      else if (mod < -Pi) mod + 2 * Pi
      else mod
    }
    def +(that: Angle): Angle = Angle(this.norm + that.norm)
    def -(that: Angle): Angle = Angle(this.norm - that.norm)
    def *(factor: Double): Angle = Angle(this.norm * factor)

    override def toString: String = s"Angle = $norm"

  }
  object Angle {
    val right: Angle = Angle(math.Pi / 2)
    val straight: Angle = Angle(math.Pi)
    val full: Angle = Angle(2 * math.Pi)
  }

  def main(args: Array[String]): Unit = {
    val fi1 = Angle(1.5)
    val fi2 = Angle(2.5)
    val r = Angle.right;
    val s1 = Angle.straight;
    val su = Angle.full;
    val fi3 = fi1 + fi2
    println(fi1 + " " + fi2 + " " + fi3)
  }
}
