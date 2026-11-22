package chapter12

    
object factorial {
    def factorial(num: Int): Int = {
        if (num == 0) 1
        else (1 to num).reduceLeft(_*_)
    }

    def factorial2(num: Int): Int = {
        (1 to num).foldLeft(1)(_*_)
    }
}