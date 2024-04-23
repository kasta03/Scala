import scala.annotation.tailrec


object Main extends App 
{
    @annotation.tailrec
    def ifStartsWith(x: List[Int], y: List[Int]): Boolean = 
    {
        if (y.isEmpty) 
        {
            true
        } 
        else if (x.isEmpty) 
        {
            false
        } 
        else if (x.head == y.head) 
        {
            ifStartsWith(x.tail, y.tail)
        } 
        else 
        {
            false
        }
    }
    def tailCount(a: List[Int], b: List[Int]): Int = 
    {
        @annotation.tailrec
        def recCounter(a: List[Int], count: Int): Int = 
        {
            if (a.isEmpty) 
            {
                count
            }
            else 
            {
                val head = a.head
                val tail = a.tail
                if (ifStartsWith(a, b)) 
                {
                    recCounter(tail, count + 1)
                } else 
                {
                    recCounter(tail, count)
                }
            }
        }
        recCounter(a, 0)
    }


    val a = List(1, 4, 5, 7, 2, 5, 6, 7, 4, 5, 7, 2, 4, 1)
    val b = List(7, 2)

    val result = ifStartsWith(a, b)
    println(result)

    val result_2 = tailCount(a, b)
    println(result_2)
}
        
// Functional class MapPoint
case class MapPoint(name: String, latitude: Double, longitude: Double) {
  // Method to calculate the distance between two MapPoints using Haversine formula
  def distanceTo(other: MapPoint): Double = {
    val earthRadius = 6371 // Earth's radius in kilometers
    val lat1 = Math.toRadians(latitude)
    val lon1 = Math.toRadians(longitude)
    val lat2 = Math.toRadians(other.latitude)
    val lon2 = Math.toRadians(other.longitude)
    
    val dLat = lat2 - lat1
    val dLon = lon2 - lon1
    
    val a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
            Math.cos(lat1) * Math.cos(lat2) *
            Math.sin(dLon / 2) * Math.sin(dLon / 2)
    val c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a))
    
    earthRadius * c
  }
  
  // Method to move the MapPoint by given offsets
  def move(latOffset: Double, lonOffset: Double): MapPoint = {
    MapPoint(name, latitude + latOffset, longitude + lonOffset)
  }
  
  // Overriding toString method for printing MapPoint
  override def toString: String = s"$name ($latitude, $longitude)"
  
  // Overloading subtraction operator to calculate distance between two MapPoints
  def -(other: MapPoint): Double = distanceTo(other)
}

// Non-functional class Route
class Route(val points: List[MapPoint]) {
  // Constructor with varargs to create a Route from MapPoints
  def this(points: MapPoint*) = this(points.toList)
  
  // Method to add a stop to the Route
  def addStop(point: MapPoint): Route = new Route(points :+ point)
  
  // Overriding toString method for printing Route
  override def toString: String = points.mkString(" -> ")
}

// Companion object for Route class
object Route {
  // Constructor with varargs to create a Route from MapPoints
  def apply(points: MapPoint*): Route = new Route(points.toList)
}

object zad extends App {
  val krk = MapPoint("Krakow", 50.061389, 19.938333)
  println(krk)
  val nyc = MapPoint("NYC", 40.7127, -74.0059)
  println(nyc)
  val porto = MapPoint("Porto", 41.162142, -8.621953)
  val irkutsk = MapPoint("Irkutsk", 52.283333, 104.283333)
  println(irkutsk)
  println(porto - irkutsk)
  println(krk - irkutsk)
  println(krk.distanceTo(porto))
  val mp = krk.move((irkutsk.latitude - krk.latitude) / 2, (irkutsk.longitude - krk.longitude) / 2)
  println(mp + " " + (mp - krk) + " " + (mp - irkutsk))
  val r = Route(krk, nyc, porto)
  println(r)
  val updatedRoute = r.addStop(porto.move(1, 1)).addStop(irkutsk)
  println(updatedRoute)
}
