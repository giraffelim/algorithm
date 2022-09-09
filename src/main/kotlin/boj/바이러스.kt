package boj

/**
 *  https://www.acmicpc.net/problem/2606
 */

import java.util.Scanner

private val graph = mutableListOf<MutableList<Int>>()
private var n = 0 // 컴퓨터 개수
private var m = 0 // 간선 개수
private var visited = BooleanArray(101)
private var result = 0

fun main() {
    val sc = Scanner(System.`in`)
    n = sc.nextInt()
    m = sc.nextInt()

    for (i in 0..n) {
        graph.add(mutableListOf())
    }

    for (i in 0 until m) {
        val a = sc.nextInt()
        val b = sc.nextInt()
        graph[a].add(b)
        graph[b].add(a)
    }

    dfs(1)
    println(result)
}

private fun dfs(x: Int) {
    visited[x] = true

    for (i in graph[x].indices) {
        if (!visited[graph[x][i]]) {
            result++
            dfs(graph[x][i])
        }
    }
}