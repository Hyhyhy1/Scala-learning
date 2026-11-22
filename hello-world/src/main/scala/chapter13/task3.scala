package chapter13

import scala.collection.mutable.ListBuffer

object remover {
    def remover1[T](data: ListBuffer[T]) : Unit = {
        val len = data.length
        for (i <- len-1 to 0 by -1){
            if (i % 2 == 0){
                data.remove(i)
            }
        }
    }
    
    def remover2[T](data: ListBuffer[T]) : ListBuffer[T] = {
        val temp = ListBuffer[T]()
        for (i <- 1 until data.length by 2) temp.append(data(i))
        temp
    }
}
