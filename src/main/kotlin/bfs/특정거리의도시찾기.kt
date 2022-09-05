package bfs

import java.util.LinkedList
import java.util.Scanner

/**
 *  https://www.acmicpc.net/problem/18352
 */

private val graph = mutableListOf<MutableList<Int>>()
private val d = IntArray(300001) // 모든 도시에 대한 최단거리
private var k = 0 // 거리 정보

fun main() {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt() // 도시의 개수
    val m = sc.nextInt() // 도로의 개수
    k = sc.nextInt()
    val x = sc.nextInt() // 출발 도시의 번호

    // 그래프 초기화
    for (i in 0 .. n) {
        graph.add(mutableListOf())
        d[i] = -1
    }

    // 도로 입력
    for (i in 0 until m) {
        val a = sc.nextInt() // A번 도시
        val b = sc.nextInt() // B번 도시
        graph[a].add(b)
    }

    d[x] = 0 // 출발 도시까지의 거리는 0으로 설정
    bfs(x)

    var check = false
    for (i in 0 .. n) {
        if (d[i] == k) {
            println(i)
            check = true
        }
    }

    if (!check) println(-1)
}

private fun bfs(x: Int) {
    val q = LinkedList<Int>()
    q.offer(x)

    while(!q.isEmpty()) {
        val now = q.poll()
        for (i in graph[now].indices) {
            val nextNode = graph[now][i]
            // 아직 방문하지 않은 노드라면
            if (d[nextNode] == -1) {
                // 최단 거리 갱신
                d[nextNode] = d[now] + 1
                q.offer(nextNode)
            }
        }
    }
}