package chapter12

import scala.collection.mutable.ArrayBuffer

object valuesObject {
    def values(fun: (Int) => Int, low: Int, high: Int): Seq[(Int, Int)] = {
        (low to high).map(x => (x, fun(x)))
    }

    def values2(fun: (Int) => Int, low: Int, high: Int): Seq[(Int, Int)] = {
        for (x <- low to high) yield (x, fun(x))
  }

    def values3(fun: (Int) => Int, low: Int, high: Int): Seq[(Int, Int)] = {

        val result = new ArrayBuffer[(Int, Int)]()
        
        for (x <- low to high) {
            result.append((x, fun(x)))
        }
        
        result.toSeq
    }
}
