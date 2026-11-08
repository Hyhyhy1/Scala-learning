package chapter8

import scala.collection.mutable.ArrayBuffer

abstract class Item {
  def price: Double
  def description: String
}

class SimpleItem(prc: Double, desc: String) extends Item {
  val price = prc
  val description = desc
}

class Bundle extends Item {
  private val items = ArrayBuffer[Item]()

  def add(item: Item): Unit = {
    items.append(item)
  }

  override def price: Double = {
    items.map(_.price).sum
  }

  override def description: String = {
    items.map(_.description).mkString(", ")
  }
}