package shortestpath

import java.util.*
import kotlin.math.min

fun main() {
    val sc = Scanner(System.`in`)

    val inf = 99999 // 무한을 의미하는 값
    val n = sc.nextInt() // 노드의 개수, 최대 500개라고 가정
    val m = sc.nextInt() // 간선의 개수
    val graph = Array(n) { IntArray(n) { 0 } } // 2차원 배열(그래프 표현)

    // 최단 거리 테이블을 모두 무한으로 초기화
    for (i in 0 until n) {
        Arrays.fill(graph[i], inf)
    }

    // 자기 자신에서 자기 자신으로 가는 값은 0으로 초기화
    for (i in 0 until n) {
        graph[i][i] = 0
    }

    // 각 간선에 대한 정보를 입력 받아, 그 값으로 초기화
    for (i in 0 until m) {
        // A에서 B로 가는 비용은 C라고 설정
        val a = sc.nextInt().minus(1)
        val b = sc.nextInt().minus(1)
        val c = sc.nextInt()
        graph[a][b] = c
    }

    // 점화식에 따라 플로이드 워셜 알고리즘을 수행
    for (k in 0 until n) {
        for (a in 0 until n) {
            for (b in 0 until n) {
                graph[a][b] = min(graph[a][b], graph[a][k] + graph[k][b])
            }
        }
    }

    // 수행된 결과를 출력
    for (a in 0 until n) {
        for (b in 0 until n) {
            // 도달할 수 없는 경우 무한(INFINITY)이라고 출력
            if (graph[a][b] == inf) print("INFINITY")
            else print("${graph[a][b]} ")
        }
        println()
    }
}
