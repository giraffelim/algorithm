package graph

import java.util.LinkedList
import java.util.Scanner

// 노드의 개수
private var v = 0
// 간선의 개수
private var e = 0
// 모든 노드에 대한 진입차수를 나타내는 초기값 0의 Array
private val indegree = IntArray(10001) { 0 }
// 각 노드에 연결된 간선 정보를 담기 위한 연결 리스트 초기화
private val graph = arrayListOf<ArrayList<Int>>()

// 위상 정렬 함수
private fun topologySort() {
    val result = arrayListOf<Int>() // 알고리즘 수행 결과를 담을 리스트
    val q = LinkedList<Int>() // 노드를 담기 위한 큐

    // 처음 시작할 때는 진입차수가 0인 노드를 큐에 삽입한다.
    for (i in 0 until v) {
        if (indegree[i] == 0) {
            q.offer(i)
        }
    }

    // 큐가 빌 때까지 반복
    while (q.isNotEmpty()) {
        // 큐에서 원소 꺼내기
        val now = q.poll()
        result.add(now)
        //해당 원소와 연결된 노드들의 진입차수에서 1 빼기
        for (i in 0 until graph[now].size) {
            indegree[graph[now][i]] -= 1;
            // 새롭게 진입차수 0이 되는 노드를 큐에 삽입
            if (indegree[graph[now][i]] == 0) {
                q.offer(graph[now][i])
            }
        }
    }

    // 위상 정렬을 수행한 결과 출력
    result.forEach { print("${it + 1} ") }
}

fun main() {
    val sc = Scanner(System.`in`)

    v = sc.nextInt()
    e = sc.nextInt()

    // 그래프 초기화
    for (i in 0 until v) {
        graph.add(arrayListOf())
    }

    // 방향 그래프의 모든 간선 정보를 입력 받기
    for (i in 0 until e) {
        val a = sc.nextInt().minus(1)
        val b = sc.nextInt().minus(1)
        graph[a].add(b) // 정점 a에서 b로 이동 가능
        // 진입 차수를 1 증가
        indegree[b] += 1
    }

    topologySort()
}