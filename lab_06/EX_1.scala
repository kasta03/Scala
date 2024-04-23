import scala.math
case class MapPoint(name: String, latitude: Double, longitude: Double) {

  def distanceTo(other: MapPoint): Double = {
    val latDifference = latitude - other.latitude
    val lonDifference = longitude - other.longitude
    Math.sqrt(latDifference * latDifference + lonDifference * lonDifference)
  }

  def -(other: MapPoint): Double = {
    distanceTo(other)
  }

  override def toString: String = s"$name, $latitude, $longitude   "

  def move(x: Double, y: Double): MapPoint = {
    MapPoint(name, latitude + x, longitude + y)
  }
}

case class Route(first: MapPoint, second: MapPoint, third: MapPoint) {
  def addStop(other: MapPoint): MapPoint = {
    val string: String = " Nearby Porto "
    MapPoint(string, 42.162142, 7.6219529999999995)
  }
}

object zad extends App {

  def inTheMiddle(first: MapPoint, second: MapPoint, name: String): MapPoint = {
    val middleLatitude = (first.latitude + second.latitude) / 2
    val middleLongitude = (first.longitude + second.longitude) / 2

    MapPoint(name, middleLatitude, middleLongitude)
  }

  val krk = MapPoint("Krakow", 50.061389, 19.938333);
  println(krk);
  val nyc = MapPoint("NYC", 40.7127, -74.0059);
  println(nyc);
  val porto = MapPoint("Porto", 41.162142, -8.621953);
  val irkutsk = MapPoint("Irkutsk", 52.283333, 104.283333);
  println(irkutsk);
  println(porto - irkutsk)
  println(krk - irkutsk)
  println(krk.distanceTo(porto))
  val mp = inTheMiddle(krk, irkutsk, "Somwhere in Russia");
  println(mp + " " + (mp - krk) + " " + (mp - irkutsk))
  val r = Route(krk, nyc, porto)
  println(r);
  r.addStop(porto.move(1, 1))
  r.addStop(irkutsk)
  println(r)
}
