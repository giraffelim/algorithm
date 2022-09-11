package boj

import java.util.*

/**
 *  https://www.acmicpc.net/problem/1697
 */

private var n = 0 // 수빈이의 위치
private var m = 0 // 동생의 위치
private var d = IntArray(100001)
private var move = mutableListOf(-1, 1, 2)

fun main() {
    val sc = Scanner(System.`in`)

    n = sc.nextInt()
    m = sc.nextInt()

    bfs(n)
    if (d[m] == 0) println(d[m])
    else println(d[m] - 1)
}

private fun bfs(x: Int): Boolean {
    val q = LinkedList<Int>()
    q.offer(x)
    d[x] = 1

    while (q.isNotEmpty()) {
        val now = q.poll()
        if (now == m) return true
        var next: Int
        for (i in move.indices) {
            next = if (i == move.size - 1) now * move[i] else now.plus(move[i])
            if (!check(next)) continue
            if (d[next] == 0) {
                d[next] = d[now].plus(1)
                q.offer(next)
            }
        }
    }

    return false
}

private fun check(next: Int) = next in 0..100000