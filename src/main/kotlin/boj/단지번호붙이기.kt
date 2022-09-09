package boj

import java.util.Scanner

/**
 *  https://www.acmicpc.net/problem/2667
 */

private var n = 0
private var graph = Array(25) { IntArray(25) }
private var visited = Array(25) { IntArray(25) }
private var result = mutableListOf<Int>()
private val dx = mutableListOf(0, 1, 0, -1)
private val dy = mutableListOf(1, 0, -1, 0)
private var temp = 0

fun main() {
    val sc = Scanner(System.`in`)
    n = sc.nextInt()
    sc.nextLine()

    for (i in 0 until n) {
        val s = sc.nextLine().chunked(1).map { it.toInt() }
        for (j in s.indices) {
            graph[i][j] = s[j]
        }
    }

    for (i in graph.indices) {
        for (j in graph[i].indices) {
            dfs(i, j)
            if (temp != 0) {
                result.add(temp)
                temp = 0
            }
        }
    }

    println(result.count())
    result.sorted().forEach { println(it) }
}

fun dfs(x: Int, y: Int) {
    if (x < 0 || x >= n || y < 0 || y >= n) return

    if (graph[x][y] == 1 && visited[x][y] == 0) {
        visited[x][y] = 1
        temp++
        for (i in dx.indices) {
            val nx = dx[i].plus(x)
            val ny = dy[i].plus(y)
            dfs(nx, ny)
        }
    }
}