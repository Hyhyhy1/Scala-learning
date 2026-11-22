package chapter13

object MatrixBuilder {
    def to2DArray(arr: Array[Double], cols: Int): Array[Array[Double]] = {
        arr.grouped(cols).toArray
    }
}