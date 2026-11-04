package chapter4

object TaskOne {

    private val prices = scala.collection.mutable.Map(
    "Футболка базовая"      -> 1490.00,
    "Джинсы slim fit"       -> 4990.00,
    "Худи оверсайз"         -> 3490.00,
    "Кроссовки белые"       -> 7990.00,
    "Куртка-бомбер"         -> 8990.00,
    "Рубашка Oxford"        -> 3290.00,
    "Брюки чинос"           -> 3990.00,
    "Свитер из мериноса"    -> 5490.00,
    "Кеды классические"     -> 4490.00,
    "Шапка вязаная"         -> 990.00
    )

    def getSales(sale: Double) ={
        for ((k, v) <- prices) yield (k, sale * v)
    }
}
