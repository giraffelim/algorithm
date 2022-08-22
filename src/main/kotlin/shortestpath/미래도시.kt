package shortestpath

import java.util.*
import kotlin.math.min

fun main() {
    val sc = Scanner(System.`in`)

    val inf = 99999
    val n = sc.nextInt() // 회사의 개수
    val m = sc.nextInt() // 경로의 개수

    val graph = Array(n) { IntArray(n) { 0 } } // 2차원 배열(그래프)

    // 2차원 배열을 모두 무한으로 초기화
    for (i in 0 until n) {
        Arrays.fill(graph[i], inf)
    }

    // 자기 자신에서 자기 자신으로 가는 값은 0으로 초기화
    for (i in 0 until n) {
        graph[i][i] = 0
    }

    // 각 간선에 대한 정보를 입력 받아, 그 값으로 초기화
    for (i in 0 until m) {
        val a = sc.nextInt().minus(1)
        val b = sc.nextInt().minus(1)
        val c = 1 // 거리
        graph[a][b] = c
        graph[b][a] = c // 연결된 회사는 양방향으로 이동할 수 있다.
    }

    val x = sc.nextInt().minus(1) // 물건을 판매할 회사
    val k = sc.nextInt().minus(1) // 소개팅 상대의 회사

    for (j in 0 until n) {
        for (a in 0 until n) {
            for (b in 0 until n) {
                graph[a][b] = min(graph[a][b], graph[a][j] + graph[j][b])
            }
        }
    }

    var result = graph[1][k].plus(graph[k][x])
    if (result >= inf) result = -1
    println(result)
}