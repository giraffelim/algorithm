package boj

import java.util.LinkedList
import java.util.Scanner

/**
 *  https://www.acmicpc.net/problem/2178
 */

private val graph = Array(101) { IntArray(101) }
private val visited = Array(101) { IntArray(101) }
private var n = 0
private var m = 0
private val dx = mutableListOf(0, 1, 0, -1)
private val dy = mutableListOf(1, 0, -1, 0)

private typealias Node = Pair<Int, Int>

fun main() {
    val sc = Scanner(System.`in`)
    n = sc.nextInt()
    m = sc.nextInt()
    sc.nextLine()

    for (i in 0 until n) {
        val s = sc.nextLine().chunked(1).map { it.toInt() }
        for (j in s.indices) {
            graph[i][j] = s[j]
        }
    }

    bfs(0, 0)
    println(graph[n - 1][m - 1])
}

private fun bfs(x: Int, y: Int) {
    val q = LinkedList<Node>()
    q.offer(Node(x, y))
    visited[x][y] = 1

    while (q.isNotEmpty()) {
        val now = q.poll()
        // 4방향 확인
        for (i in 0 until 4) {
            val nx = now.first.plus(dx[i])
            val ny = now.second.plus(dy[i])
            if (!check(nx, ny)) continue
            if (graph[nx][ny] == 1 && visited[nx][ny] != 1) {
                graph[nx][ny] = graph[now.first][now.second].plus(1)
                visited[nx][ny] = 1
                q.offer(Node(nx, ny))
            }
        }
    }
}

private fun check(nx: Int, ny: Int) = nx < n && ny < m && nx >= 0 && ny >= 0
