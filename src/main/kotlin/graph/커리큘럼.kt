package graph

import java.util.LinkedList
import java.util.Scanner
import kotlin.math.max

private val graph = arrayListOf<ArrayList<Int>>() // 그래프
private val indegree = IntArray(501) // 진입 차수
private val times = IntArray(501) // 강의 시간

private fun topologySort() {
    val q = LinkedList<Int>()
    val result = IntArray(501) // 알고리즘 수행 결과를 담을 배열
    for (i in result.indices) {
        result[i] = times[i]
    }

    for (i in graph.indices) {
        if (indegree[i] == 0) {
            q.offer(i)
        }
    }

    while(q.isNotEmpty()) {
        val now = q.poll() // 큐에서 원소 꺼내기

        graph[now].forEach { node ->
            result[node] = max(result[node], result[now] + times[node]) // result 값 갱신
            indegree[node] -= 1
            if (indegree[node] == 0) {
                q.offer(node)
            }
        }
    }

    for (i in 0 until graph.size) {
        println(result[i])
    }
}

fun main() {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()

    for (i in 0 until n)
        graph.add(arrayListOf())

    for (i in 0 until n) {
        var x = sc.nextInt() // 첫번째 수는 강의 시간
        times[i] = x
        while(true) {
            x = sc.nextInt().minus(1)
            if (x < 0) break
            graph[x].add(i)
            indegree[i] += 1
        }
    }

    topologySort()
}