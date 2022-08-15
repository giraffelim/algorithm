package shortestpath

import java.util.PriorityQueue
import java.util.Scanner

fun main() {
    class Node(private val index: Int, private val distance: Int) : Comparable<Node> {
        fun getIndex() = this.index
        fun getDistance() = this.distance

        override fun compareTo(other: Node): Int {
            if (this.distance < other.distance) {
                return -1
            }
            return 1
        }
    }

    val INF = 99999 // 무한을 의미하는 값
    // 노드의 개수(N), 간선의 개수(M), 시작 노드 번호(Start)
    var n = 0
    var m = 0
    var start = 0
    // 각 노드에 연결되어 있는 노드에 대한 정보를 담는 배열
    val graph = arrayListOf<ArrayList<Node>>()
    // 최단 거리 테이블
    val d = IntArray(100001)

    fun dijkstra(start: Int) {
        val pq = PriorityQueue<Node>()
        // 시작 노드로 가기 위한 최단 경로는 0으로 설정하며, 큐에 삽입
        pq.offer(Node(start, 0))
        d[start] = 0
        while (!pq.isEmpty()) {
            // 가장 최단 거리가 짧은 노드에 대해 정보 꺼내기
            val node = pq.poll()
            val dist = node.getDistance() // 현재 노드까지의 비용
            val now = node.getIndex() // 현재 노드
            // 현재 노드가 이미 처리된 적이 있는 노드라면 무시
            if (d[now] < dist) continue
            // 현재 노드와 연결된 다른 인접한 노드들을 확인
            for (i in 0 until graph[now].size) {
                val cost = d[now] + graph[now][i].getDistance()
                // 현재 노드를 거쳐서, 다른 노드로 이동하는 거리가 더 짧은 경우
                if (cost < d[graph[now][i].getIndex()]) {
                    d[graph[now][i].getIndex()] = cost
                    pq.offer(Node(graph[now][i].getIndex(), cost))
                }
            }
        }
    }

    val sc = Scanner(System.`in`)
    n = sc.nextInt()
    m = sc.nextInt()
    start = sc.nextInt()

    // 그래프 초기화
    for (i in 0..n) {
        graph.add(arrayListOf())
    }

    // 모든 간선 정보를 입력 받기
    for (i in 0 until m) {
        val a = sc.nextInt()
        val b = sc.nextInt()
        val c = sc.nextInt()
        // a번 노드에서 b번 노드로 가는 비용이 c라는 의미
        graph[a].add(Node(b, c))
    }

    // 최단 거리 테이블을 모두 무한으로 초기화
    d.fill(INF)

    // 다익스트라 알고리즘을 수행
    dijkstra(start)

    // 모든 노드로 가기 위한 최단 거리를 출력
    for (i in 1..n) {
        // 도달 할 수 없는 경우, 무한(INFINITY)이라고 출력
        if (d[i] == INF) {
            println("INFINITY")
        }
        // 도달할 수 있는 경우 거리 출력
        else {
            println(d[i])
        }
    }
}