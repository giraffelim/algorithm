package boj

import java.util.*
import kotlin.math.abs

/**
 *  https://www.acmicpc.net/problem/9205
 */

private var n = 0 // 맥주를 파는 편의점 개수
private lateinit var distances: MutableList<Place>
private lateinit var graph: MutableList<MutableList<Int>>

private class Place(val x: Int, val y: Int)

fun main() {
    val sc = Scanner(System.`in`)
    var t = sc.nextInt()
    val sb = StringBuilder()

    while(t > 0) {
        n = sc.nextInt()
        distances = mutableListOf()
        graph = mutableListOf()

        for (i in 0 until n + 2) {
            // 장소 입력
            distances.add(Place(sc.nextInt(), sc.nextInt()))
            graph.add(mutableListOf())
        }

        for (i in 0 until n + 2) {
            for (j in i + 1 until n + 2) {
                val manhattanDistance = calculateManhattanDistance(distances[i], distances[j])
                if (manhattanDistance <= 1000) {
                    graph[i].add(j)
                    graph[j].add(i)
                }
            }
        }

        if (bfs()) sb.append("happy \n") else sb.append("sad \n")
        t --
    }

    println(sb.toString())
}

// 맨해튼 거리 계산
private fun calculateManhattanDistance(a: Place, b: Place): Int {
    return abs(a.x - b.x) + abs(a.y - b.y)
}

private fun bfs(): Boolean {
    val q = LinkedList<Int>()
    val visited = BooleanArray(n + 2)
    q.offer(0)
    visited[0] = true

    while (q.isNotEmpty()) {
        val now = q.poll()
        if (now == n + 1) {
            return true
        }
        for (next in graph[now]) {
            if (!visited[next]) {
                visited[next] = true
                q.offer(next)
            }
        }
    }

    return false
}