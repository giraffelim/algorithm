package boj

/**
 *  https://www.acmicpc.net/problem/2579
 */

import java.util.Scanner
import kotlin.math.max

private lateinit var dp: IntArray

fun main() {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()
    val arr = IntArray(n + 1)
    dp = IntArray(n + 1)

    for (i in 1..n) {
        arr[i] = sc.nextInt()
    }

    dp[0] = arr[0]
    dp[1] = arr[1]

    if (n >= 2) {
        dp[2] = arr[1] + arr[2]
    }

    for (i in 3 .. n) {
        dp[i] = max(dp[i - 2], dp[i - 3] + arr[i - 1]) + arr[i]
    }

    println(dp[n])
}