package boj

import java.util.LinkedList
import java.util.Scanner

/**
 *  https://www.acmicpc.net/problem/18405
 */

private var n = 0 // 시험관의 크기(N * N)
private var k = 0 // 바이러스 번호의 끝
private var s = 0 // 초
private lateinit var graph: Array<IntArray>
private val viruses = mutableListOf<Virus>()
private val dx = listOf(-1, 1, 0, 0)
private val dy = listOf(0, 0, -1, 1)
private val q = LinkedList<Virus>()

// 종류, 시간, 위치
private class Virus(val index: Int, val second: Int, val x: Int, val y: Int)

fun main() {
    val sc = Scanner(System.`in`)
    n = sc.nextInt()
    k = sc.nextInt()

    graph = Array(n + 1) { IntArray(n + 1) }
    for (i in 1..n) {
        for (j in 1..n) {
            graph[i][j] = sc.nextInt()
            if (graph[i][j] != 0) viruses.add(Virus(graph[i][j], 0, i, j))
        }
    }

    // 큐에 삽입 시 바이러스 종류가 낮은 순서부터
    viruses.sortBy { it.index }
    viruses.forEach { q.offer(it) }

    s = sc.nextInt()
    val x = sc.nextInt()
    val y = sc.nextInt()

    bfs()

    println(graph[x][y])
}

private fun bfs() {
    while (q.isNotEmpty()) {
        val virus = q.poll()
        // s만큼 초가 지난 경우 종료
        if (virus.second == s) break
        for (i in dx.indices) {
            val nx = virus.x + dx[i]
            val ny = virus.y + dy[i]
            if (canAccess(nx, ny)) {
                // 바이러스가 전염될 수 있는 공간이라면 전이
                if (graph[nx][ny] == 0) {
                    graph[nx][ny] = virus.index
                    q.offer(Virus(virus.index, virus.second + 1, nx, ny))
                }
            }
        }
    }
}

private fun canAccess(nx: Int, ny: Int) = nx in 1 .. n && ny in 1 .. n
