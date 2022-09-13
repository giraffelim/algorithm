package boj

import java.util.Scanner
import kotlin.system.exitProcess

private var n = 0
private var arr = Array(7) { CharArray(7) }
private val dx = mutableListOf(-1, 0, 1, 0)
private val dy = mutableListOf(0, 1, 0, -1)
private val teachers = mutableListOf<Pair<Int, Int>>()

fun main() {
    val sc = Scanner(System.`in`)
    n = sc.nextInt()

    for (i in 0 until n) {
        for (j in 0 until n) {
            arr[i][j] = sc.next()[0]
            if (arr[i][j] == 'T') teachers.add(Pair(i, j))
        }
    }

    dfs(0)
    println("NO")
}

private fun dfs(obstacle: Int) {
    if (obstacle == 3) {
        if (!watch()) {
            println("YES")
            exitProcess(0)
        }
        return
    }

    for (i in 0 until n) {
        for (j in 0 until n) {
            if (arr[i][j] == 'X') {
                arr[i][j] = 'O'
                dfs(obstacle + 1)
                arr[i][j] = 'X'
            }
        }
    }
}

private fun watch(): Boolean {
    for (t in teachers.indices) {
        for (i in dx.indices) {
            var nx = teachers[t].first
            var ny = teachers[t].second
            while(true) {
                nx += dx[i]
                ny += dy[i]
                if (nx !in 0 .. n || ny !in 0 .. n) break
                if (arr[nx][ny] == 'S') return true
                if (arr[nx][ny] == 'O') break
            }
        }
    }

    return false
}