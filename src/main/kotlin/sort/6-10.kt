package sort

import java.util.Scanner

fun main() {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()
    val arr = Array(n) { 0 }

    for (i in 0 until n) {
        arr[i] = sc.nextInt()
    }

    arr.sortDescending()

    for (i in arr.indices) {
        print("${arr[i]} ")
    }

    println()
}