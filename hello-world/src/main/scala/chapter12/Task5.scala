package chapter12

object largest {
    def largest(fun: (Int) => Int, inputs: Seq[Int]): Option[Int] = {
        inputs.map(fun).reduceLeftOption(_ max _)
    }
}
