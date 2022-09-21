package boj

import java.util.*

/**
 *  https://www.acmicpc.net/problem/2573
 */

private lateinit var map: Array<IntArray>
private lateinit var melt: Array<IntArray>
private lateinit var visited: Array<BooleanArray>
private var n = 0 // 행
private var m = 0 // 열
private var dx = mutableListOf(-1, 0, 1, 0)
private var dy = mutableListOf(0, -1, 0, 1)

fun main() {
    val sc = Scanner(System.`in`)
    n = sc.nextInt()
    m = sc.nextInt()
    map = Array(n) { IntArray(m) }
    visited = Array(n) { BooleanArray(m) }
    melt = Array(n) { IntArray(m) }

    for (i in 0 until n) {
        for (j in 0 until m) {
            map[i][j] = sc.nextInt()
        }
    }

    var year = 0
    while (true) {
        // dfs로 빙산 덩어리 세기
        var count = 0
        for (i in 0 until n) {
            for (j in 0 until m) {
                if (!visited[i][j] && map[i][j] != 0) {
                    dfs(i, j)
                    count++
                }
            }
        }

        if (count == 0) {
            println(0)
            break
        } else if (count >= 2) {
            println(year)
            break
        }

        melting()
        year++
    }
}

private fun dfs(x: Int, y: Int) {
    visited[x][y] = true

    for (i in dx.indices) {
        val nx = x + dx[i]
        val ny = y + dy[i]

        if (nx in 0 until n && ny in 0 until m) {
            // 1년 후에 녹는 빙산의 양 구하기
            if (map[nx][ny] == 0) melt[x][y]++
            // dfs 재귀
            if (!visited[nx][ny] && map[nx][ny] != 0) dfs(nx, ny)
        }
    }
}

private fun melting() {
    for (i in 0 until n) {
        for (j in 0 until m) {
            // 빙산 녹이기
            map[i][j] -= melt[i][j]
            // 녹인 높이가 음수일 경우 0으로 변경
            if (map[i][j] < 0) map[i][j] = 0
            // visited 초기화
            visited[i][j] = false
            // melt 초기화
            melt[i][j] = 0
        }
    }
}