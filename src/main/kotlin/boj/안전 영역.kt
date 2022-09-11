package boj

import java.util.Scanner
import kotlin.math.max

/**
 *  https://www.acmicpc.net/problem/2667
 */

private var n = 0
private var graph = Array(101) { IntArray(101) }
private var visited = Array(101) { IntArray(101) }
private var result = 0
private val dx = mutableListOf(0, 1, 0, -1)
private val dy = mutableListOf(1, 0, -1, 0)
private var max = 0

fun main() {
    val sc = Scanner(System.`in`)
    n = sc.nextInt()

    for (i in 1 .. n) {
        for (j in 1 .. n) {
            graph[i][j] = sc.nextInt()
            max = max(max, graph[i][j])
        }
    }

    for (i in 1 .. max) {
        var cnt = 0
        visited = Array(101) { IntArray(101) }
        for (j in 1 .. n) {
            for (k in 1 .. n) {
                if (visited[j][k] == 0 && graph[j][k] >= i) {
                    cnt ++
                    dfs(i, j, k)
                }
            }
        }
        result = max(result, cnt)
    }

    println(result)
}

private fun dfs(height: Int, x: Int, y: Int) {
    visited[x][y] = 1

    for (i in dx.indices) {
        val nx = x + dx[i]
        val ny = y + dy[i]

        if (nx < 1 || ny < 1 || nx > n || ny > n) continue

        if(visited[nx][ny] == 0 && graph[nx][ny] >= height) {
            visited[nx][ny] = 1
            dfs(height, nx, ny)
        }
    }
}