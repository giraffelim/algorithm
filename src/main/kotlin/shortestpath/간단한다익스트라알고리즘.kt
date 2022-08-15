package shortestpath

import java.util.Scanner

fun main() {
    class Node(private val index: Int, private val distance: Int) {
        fun getIndex() = this.index
        fun getDistance() = this.distance
    }

    val INF = 99999 // 무한을 의미하는 값
    // 노드의 개수(N), 간선의 개수(M), 시작 노드 번호(Start)
    var n = 0
    var m = 0
    var start = 0
    // 각 노드에 연결되어 있는 노드에 대한 정보를 담는 배열
    val graph = arrayListOf<ArrayList<Node>>()
    // 방문한 적이 있는지 체크하는 목적의 배열
    val visited = BooleanArray(100001)
    // 최단 거리 테이블
    val d = IntArray(100001)

    // 방문하지 않은 노드 중에서, 가장 최단 거리가 짧은 노드의 번호를 반환
    fun getSmallestNode(): Int {
        var minValue = INF
        var idx = 0 // 가장 최단 거리가 짧은 노드(인덱스)
        for (i in 1 until n) {
            if (d[i] < minValue && !visited[i]) {
                minValue = d[i]
                idx = i
            }
        }
        return idx
    }

    fun dijkstra(start: Int) {
        // 시작 노드에 대해서 초기화
        d[start] = 0
        visited[start] = true
        for (i in 0 until graph[start].size) {
            d[graph[start][i].getIndex()] = graph[start][i].getDistance()
        }
        // 시작 노드를 제외한 전체 n - 1개의 노드에 대한 반복
        for (i in 0 until n - 1) {
            // 현재 최단 거리가 가장 짧은 노드를 꺼내서, 방문 처리
            val now = getSmallestNode()
            visited[now] = true
            // 현재 노드와 연결된 다른 노드를 확인
            for (j in 0 until graph[now].size) {
                val cost = d[now] + graph[now][j].getDistance()
                // 현재 노드를 거쳐서 다른 노드로 이동하는 거리가 더 짧은 경우
                if (cost < d[graph[now][j].getIndex()]) {
                    d[graph[now][j].getIndex()] = cost
                }
            }
        }
    }

    val sc = Scanner(System.`in`)
    n = sc.nextInt()
    m = sc.nextInt()
    start = sc.nextInt()

    // 그래프 초기화
    for (i in 0 until n) {
        graph.add(arrayListOf())
    }

    // 모든 간선 정보를 입력받기
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