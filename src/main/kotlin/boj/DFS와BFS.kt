package boj

import java.util.LinkedList
import java.util.Scanner

/**
 *  https://www.acmicpc.net/problem/1260
 */

private var n = 0
private var m = 0
private val graph = mutableListOf<MutableList<Int>>()
private var visited = BooleanArray(1001)

fun main() {
    val sc = Scanner(System.`in`)
    n = sc.nextInt()
    m = sc.nextInt()
    val v = sc.nextInt()

    for (i in 0..n) {
        graph.add(mutableListOf())
    }

    for (j in 0 until m) {
        val a = sc.nextInt()
        val b = sc.nextInt()
        graph[a].add(b)
        graph[b].add(a)
    }

    graph.forEach { it.sort() }

    dfs(v)
    visited = reset()
    println()
    bfs(v)
}

private fun reset() = BooleanArray(1001)

private fun dfs(x: Int) {
    print("$x ")
    visited[x] = true

    for (i in graph[x].indices) {
        val node = graph[x][i]
        if (!visited[node]) {
            dfs(node)
        }
    }
}

private fun bfs(x: Int) {
    val q = LinkedList<Int>()
    q.offer(x)
    visited[x] = true

    while (q.isNotEmpty()) {
        val now = q.poll()
        print("$now ")
        for (i in graph[now].indices) {
            val node = graph[now][i]
            if (!visited[node]) {
                q.offer(node)
                visited[node] = true
            }
        }
    }
}