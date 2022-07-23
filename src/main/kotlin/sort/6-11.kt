package sort

import java.util.Scanner

fun main() {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()
    val list = mutableListOf<Pair<String, Int>>()

    for (i in 0 until n) {
        val name = sc.next()
        val score = sc.nextInt()
        list.add(Pair(name, score))
    }

    val sorted = list.sortedBy { it.second }

    sorted.forEach { print("${it.first} ") }
}