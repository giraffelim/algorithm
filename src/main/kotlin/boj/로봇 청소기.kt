package boj

import java.util.Scanner

/**
 *  https://www.acmicpc.net/problem/14503
 */

private var n = 0
private var m = 0
private var dx = mutableListOf(-1, 0, 1, 0) // 북, 동, 남, 서
private var dy = mutableListOf(0, 1, 0, -1)
private lateinit var graph: Array<IntArray>
private var d = 0 // 바라보는 방향
private var cnt = 1

fun main() {
    val sc = Scanner(System.`in`)
    n = sc.nextInt()
    m = sc.nextInt()
    graph = Array(n) { IntArray(m) }
    val r = sc.nextInt()
    val c = sc.nextInt()
    d = sc.nextInt()

    for (i in 0 until n) {
        for (j in 0 until m) {
            graph[i][j] = sc.nextInt()
        }
    }

    dfs(r, c)
    println(cnt)
}

private fun dfs(x: Int, y: Int) {
    graph[x][y] = 2

    for (i in dx.indices) {
        d = (d + 3) % 4
        val nx = x + dx[d]
        val ny = y + dy[d]
        if (nx in 0 until n && ny in 0 until m && graph[nx][ny] == 0) {
            cnt ++
            dfs(nx, ny)
            // 후진할때만 이전 길을 되돌아 갈 수 있기에 return
            return
        }
    }

    val nd = (d + 2) % 4
    val nx = x + dx[nd]
    val ny = y + dy[nd]
    if (nx in 0 until n && ny in 0 until m && graph[nx][ny] != 1) {
        dfs(nx, ny)
    }
}