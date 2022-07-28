package dynamic

import util.ExecutionTime

var dp = Array(100) { 0 }

fun main() {
    ExecutionTime {
        val result = topDownFibo(6)
        println()
        println(result)
    }
}

fun topDownFibo(x: Int): Int {
    print("f($x) ")
    if (x == 1 || x == 2) return 1
    if(dp[x] != 0) return dp[x]
    dp[x] = topDownFibo(x - 1) + topDownFibo(x - 2)
    return dp[x]
}