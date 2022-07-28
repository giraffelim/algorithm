package dynamic

import util.ExecutionTime

var d = Array(100) { 0 }

fun main() {
    ExecutionTime {
        bottomUpFibo(6)
    }
}

fun bottomUpFibo(x: Int) {
    d[1] = 1
    d[2] = 1

    for (i in 3 until x + 1) {
        d[i] = d[i - 1] + d[i - 2]
    }

    println(d[x])
}