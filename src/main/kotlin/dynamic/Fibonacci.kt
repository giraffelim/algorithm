package dynamic

import util.ExecutionTime

fun main() {
    ExecutionTime {
        val result = fibo(6)
        println(result)
    }
}

fun fibo(x: Int): Int {
    print("f($x) ")
    if (x == 1 || x == 2) return 1
    return fibo(x - 1) + fibo(x - 2)
}