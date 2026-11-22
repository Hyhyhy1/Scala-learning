package chapter12

object largestAt {
    def largestAt(fun: (Int) => Int, inputs: Seq[Int]): Option[Int] = {
        inputs.map(x => (x, fun(x))).maxByOption(_._2).map(_._1)
    }
}
