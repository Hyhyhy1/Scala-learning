package chapter5

class Car(
  val manufacturer: String,
  val model: String,
  val year: Int,
  var regNumber: String
) {
  def this(manufacturer: String, model: String, year: Int) = {
    this(manufacturer, model, year, "")
  }

  def this(manufacturer: String, model: String, regNumber: String) = {
    this(manufacturer, model, -1, regNumber)
  }

  def this(manufacturer: String, model: String) = {
    this(manufacturer, model, -1, "")
  }

  override def toString: String =
    s"Car($manufacturer $model, $year, '$regNumber')"
}
