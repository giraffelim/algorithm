package graph

import java.util.Scanner

private val edges = mutableListOf<Triple<Int, Int, Int>>() // (A번 집, B번 집, 연결하는 길의 유지비)
private val parent = (0..100001).toMutableList() // 부모 테이블

private fun findParent(x: Int): Int {
    if (x == parent[x]) return x
    return findParent(parent[x]).also { parent[x] = it }
}

private fun unionParent(a: Int, b: Int) {
    val xa = findParent(a)
    val xb = findParent(b)
    if (xa < xb) parent[xb] = parent[xa]
    else parent[xa] = parent[xb]
}

fun main() {
    val sc = Scanner(System.`in`)

    val n = sc.nextInt() // 집의 개수
    val m = sc.nextInt() // 길의 개수

    for (i in 1 .. m) {
        val a = sc.nextInt() // A번 집
        val b = sc.nextInt() // B번 집
        val c = sc.nextInt() // A번 집과 B번 집을 연결하는 길의 유지비
        edges.add(Triple(a, b, c))
    }

    edges.sortBy { it.third } // 길의 유지비 오름차순 정렬

    var result = 0 // 길의 유지비의 합의 최솟값
    var last = 0

    for (edge in edges) {
        if (findParent(edge.first) != findParent(edge.second)) {
            unionParent(edge.first, edge.second)
            result += edge.third
            last = edge.third
        }
    }

    println(result - last)
}