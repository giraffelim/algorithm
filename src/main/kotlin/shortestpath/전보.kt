package shortestpath

import java.util.PriorityQueue
import java.util.Scanner
import kotlin.math.max

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

    val sc = Scanner(System.`in`)

    val inf = 99999 // 무한을 의미하는 값
    val n = sc.nextInt() // 도시 개수
    val m = sc.nextInt() // 통로 개수
    val c = sc.nextInt().minus(1) // 메시지를 보내고자 하는 도시

    val graph = arrayListOf<ArrayList<Node>>() // 각 노드에 연결되어 있는 노드에 대한 정보를 담는 배열
    // 그래프 초기화
    for (i in 0 until n) {
        graph.add(arrayListOf())
    }
    // 모든 통로 정보 입력 받기
    for (i in 0 until m) {
        val a = sc.nextInt().minus(1)
        val b = sc.nextInt().minus(1)
        val c = sc.nextInt()
        // a번에서 b번 노드로 가는 비용이 c
        graph[a].add(Node(b, c))
    }

    // 최단 거리 테이블
    val d = IntArray(n)
    d.fill(inf)

    fun dijkstra(start: Int) {
        val pq = PriorityQueue<Node>()
        pq.offer(Node(start, 0))
        d[start] = 0
        while(!pq.isEmpty()) {
            // 가장 최단거리가 짧은 노드 꺼내기
            val node = pq.poll()
            val dist = node.getDistance() // 현재 노드까지의 비용
            val now = node.getIndex() // 현재 노드
            // 현재 노드가 이미 처리된 적 있는 노드라면 무시
            if (d[now] < dist) continue
            // 현재 노드와 인접한 다른 노드들을 확인
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

    dijkstra(c)

    // 도달할 수 있는 노드의 개수
    var count = 0
    // 도달할 수 있는 노드 중에서, 가장 멀리있는 노드와의 최단 거리
    var maxDistance = 0
    for (i in 0 until n) {
        // 도달할 수 있는 노드인 경우
        if (d[i] != inf) {
            count += 1
            maxDistance = max(maxDistance, d[i])
        }
    }

    // 시작 노드는 제외해야 하므로 count - 1을 출력
    println("${count - 1} $maxDistance")
}

