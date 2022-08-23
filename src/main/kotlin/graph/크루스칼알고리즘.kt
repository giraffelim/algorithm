package graph

import java.util.Scanner

private var v = 0 // 노드의 개수
private var e = 0 // 간선의 개수
private val parent = IntArray(100001) // 부모 테이블
private val edges = arrayListOf<Edge>() // 모든 간선을 담을 리스트
private var result = 0 // 최종 비용을 담을 변수

private class Edge(
    private var distance: Int,
    private var nodeA: Int,
    private var nodeB: Int
) {
    fun getDistance() = this.distance
    fun getNodeA() = this.nodeA
    fun getNodeB() = this.nodeB
}

private fun findParent(x: Int): Int {
    if (x == parent[x]) return x
    return findParent(parent[x]).also { parent[x] = it }
}

private fun unionParent(a: Int, b: Int) {
    val xa = findParent(a)
    val xb = findParent(b)
    if (xa < xb) parent[xb] = xa
    else parent[xa] = xb
}

fun main() = with(Scanner(System.`in`)) {
    v = nextInt()
    e = nextInt()

    // 부모 테이블상에서, 부모를 자기 자신으로 초기화
    for (i in 1 .. v) {
        parent[i] = i
    }

    // 모든 간선에 대한 정보를 입력 받기
    for (i in 0 until e) {
        val a = nextInt()
        val b = nextInt()
        val cost = nextInt()
        edges.add(Edge(cost, a, b))
    }

    // 간선을 비용순으로 정렬
    edges.sortBy { it.getDistance() }

    // 간선을 하나씩 확인하며
    for (i in 0 until edges.size) {
        val cost = edges[i].getDistance()
        val a = edges[i].getNodeA()
        val b = edges[i].getNodeB()
        // 사이클이 발생하지 않는 경우에만 집합에 포함
        if (findParent(a) != findParent(b)) {
            unionParent(a, b)
            result += cost
        }
    }

    println(result)
}