package chapter13

import scala.collection.mutable

object indexer {
    def indexes(str: String): mutable.Map[Char, mutable.Set[Int]] = {
        val temp = str.zipWithIndex
        val data = mutable.Map[Char, mutable.Set[Int]]()

        for ((char, index) <- temp) {
            if (!data.contains(char)) data(char) = mutable.Set[Int]()
            data(char) += index
        }
        data
    }

    def indexes2(str: String): scala.collection.immutable.Map[Char, scala.collection.immutable.Set[Int]] = {
        val pairs = str.zipWithIndex
        val grouped = pairs.groupBy(_._1)
        grouped.map(x => (x._1, x._2.map(_._2).toSet))
    }
}