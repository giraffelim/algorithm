package search

import java.util.Scanner

fun main() {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()
    val stock = mutableListOf<Int>()
    for (i in 0 until n) {
        stock.add(sc.nextInt())
    }

    val m = sc.nextInt()
    val find = mutableListOf<Int>()
    for (j in 0 until m) {
        find.add(sc.nextInt())
    }

    stock.sort()

    for (i in find.indices) {
        val exist = binarySearch(stock, find[i], 0, n)
        print("$exist ")
    }
}

fun binarySearch(arr: List<Int>, target: Int, start: Int, end: Int): String {
    if (start >= end) return "no"
    val mid = start.plus(end).div(2)
    if (arr[mid] == target) return "yes"
    else if (arr[mid] < target) return binarySearch(arr, target, mid + 1, end)
    else return binarySearch(arr, target, start, mid - 1)
}