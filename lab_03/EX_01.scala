object Shop 
{
  def deliveryInventory(inventory: List[(String, Int)], flower: String, deliveryAmount: Int): List[(String, Int)] = 
    {
    inventory.map 
    {
      case (f, quantity) 
      if f == flower => (f, quantity + deliveryAmount)
      case other => other
    }
  }
  def main(args: Array[String]): Unit = 
    {
    val inventory: List[(String, Int)] = List(
      ("rose white star", 12),
      ("sunfloer", 3),
      ("orchid", 7),
      ("carnation white", 30),
      ("carnation red", 25)
    )

    println("Inventory:")
    inventory.foreach 
    {
    case (flower, quantity) => println(s"$flower: $quantity")
    }

    println("Flowers to order:")
    val flowersToOrder = inventory.filter(_._2 < 10)
    flowersToOrder.foreach 
    {
    case (flower, quantity) => println(s"$flower: $quantity")
    }

    val newInventory = deliveryInventory(inventory, "sunflower", 10)
    println("New Inventory:")
    newInventory.foreach 
    {
    case (flower, quantity) => println(s"$flower: $quantity")
    }
  }
}