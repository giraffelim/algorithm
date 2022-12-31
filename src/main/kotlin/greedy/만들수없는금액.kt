package greedy

import java.util.Scanner

fun main() = with(Scanner(System.`in`)) {
    val n = nextInt()
    val coins = mutableListOf<Int>()
    for (i in 0 until n) coins.add(nextInt())

    coins.sort()

    var target = 1
    for (i in 0 until n) {
        if (target < coins[i]) break
        target += coins[i]
    }

    println(target)
}