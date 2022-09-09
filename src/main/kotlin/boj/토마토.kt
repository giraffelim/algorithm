package boj

import java.util.LinkedList
import java.util.Scanner
import kotlin.math.max

/**
 *  https://www.acmicpc.net/problem/7569
 */


private class Tomato(val h: Int, val x: Int, val y: Int)

private var m = 0
private var n = 0
private var h = 0
private val dx = mutableListOf(0, 1, 0, -1, 0, 0)
private val dy = mutableListOf(1, 0, -1, 0, 0, 0)
private val dh = mutableListOf(0, 0, 0, 0, 1, -1)
private val q = LinkedList<Tomato>()
private val graphs = mutableListOf<Array<IntArray>>()
private var result = 0

fun main() {
    val sc = Scanner(System.`in`)
    m = sc.nextInt() // 가로
    n = sc.nextInt() // 세로
    h = sc.nextInt() // 상자의 수(높이)

    for (i in 0 until h) {
        val arr = Array(n) { IntArray(m) }
        for (j in 0 until n) {
            for (k in 0 until m) {
                arr[j][k] = sc.nextInt()
                if (arr[j][k] == 1) q.add(Tomato(i, j, k))
            }
        }
        graphs.add(arr)
    }

    bfs()
    if (result < 0) println(result)
    else println(result - 1)
}

private fun bfs() {
    while (q.isNotEmpty()) {
        val now = q.poll()
        for (i in dx.indices) {
            val nx = now.x.plus(dx[i])
            val ny = now.y.plus(dy[i])
            val nh = now.h.plus(dh[i])
            if (canRipe(nx, ny, nh)) {
                q.offer(Tomato(nh, nx, ny))
                graphs[nh][nx][ny] = graphs[now.h][now.x][now.y] + 1
            }
        }
    }

    for (i in 0 until h) {
        for (j in 0 until n) {
            for (k in 0 until m) {
                if (graphs[i][j][k] == 0) {
                    result = -1
                    return
                }
                result = max(result, graphs[i][j][k])
            }
        }
    }
}

private fun canRipe(nx: Int, ny: Int, nh: Int): Boolean {
    if (nx >= n || ny >= m || nh >= h || nx < 0 || ny < 0 || nh < 0) return false
    return graphs[nh][nx][ny] == 0
}