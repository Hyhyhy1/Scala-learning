package chapter10

import java.awt.Point
import scala.math.Ordered

class OrderedPoint(x: Int, y: Int) extends Point(x, y) with scala.math.Ordered[Point] {

    override def toString: String = s"($x, $y)"
    def compare(that: Point): Int = {
        val xCompare = this.getX().compare(that.getX())
        if (xCompare != 0) xCompare
        else this.getY().compare(that.getY())
    }
}
