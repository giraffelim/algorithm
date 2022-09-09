package boj

import java.util.LinkedList
import java.util.Scanner

/**
 *  https://www.acmicpc.net/problem/2644
 */

private var graph = mutableListOf<MutableList<Int>>()
private var d = IntArray(101)

fun main() {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()
    val x = sc.nextInt()
    val y = sc.nextInt()
    val m = sc.nextInt()

    for (i in 0..n) {
        graph.add(mutableListOf())
    }

    for (i in 0 until m) {
        val a = sc.nextInt()
        val b = sc.nextInt()
        graph[a].add(b)
        graph[b].add(a)
    }

    bfs(x)
    if (d[y] == 0) d[y] = -1
    println(d[y])
}

private fun bfs(x: Int) {
    val q = LinkedList<Int>()
    q.offer(x)
    d[x] = 0

    while (q.isNotEmpty()) {
        val node = q.poll()
        for (i in graph[node].indices) {
            val next = graph[node][i]
            if (d[next] == 0) {
                d[next] = d[node].plus(1)
                q.offer(next)
            }
        }
    }
}