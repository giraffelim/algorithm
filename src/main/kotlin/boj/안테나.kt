package boj

/**
 *  https://www.acmicpc.net/problem/18310
 */

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val home = mutableListOf<Int>()
    val st = StringTokenizer(br.readLine())
    for (i in 0 until n) {
        home.add(st.nextToken().toInt())
    }

    home.sort()

    println(home[(n - 1) / 2])
}