package chapter3

object ArraySwitch {
  def arraySwitch[T](arr: Array[T]): Array[T] = {
    for (i <- 1 until arr.length by 2){
        swap(arr, i-1, i)
    }
    arr
  }
  
  private def swap[T](arr: Array[T], left: Int, right: Int){
    val temp = arr(left)
    arr(left) = arr(right)
    arr(right) = temp
  }
}
