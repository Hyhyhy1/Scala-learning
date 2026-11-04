package chapter6

class Point(val x:Int, val y:Int) {

    override def toString: String = s"Point($x, $y)"
}

object Point {
    def apply(x:Int, y:Int): Point ={
        new Point(x, y)
    }
}