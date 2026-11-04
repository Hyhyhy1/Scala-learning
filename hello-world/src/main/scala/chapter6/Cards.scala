package chapter6

object Suit extends Enumeration {
  val Club = Value("♣")
  val Diamond = Value("♦")
  val Heart = Value("♥")
  val Spade = Value("♠")

  def isRed(suit: Suit.Value): Boolean = {
    suit == Heart || suit == Diamond
  }
}
