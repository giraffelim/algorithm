package graph

import java.util.*

private var v: Int = 0 // 노드의 개수
private var e: Int = 0 // 간선의 개수(Union 연산)
private val parent = IntArray(100001) // 부모 테이블

// 특정 원소가 속한 집합 찾기
private fun findParent(x: Int): Int {
    // 루트 노드가 아니라면, 루트 노드를 찾을 때까지 재귀적으로 호출
    if (x == parent[x]) return x
    return findParent(parent[x])
}

private fun findParentPathCompression(x: Int): Int {
    if (x == parent[x]) return x
    return findParentPathCompression(parent[x]).also { parent[x] = it }
}

private fun unionParent(a: Int, b: Int) {
    val xa = findParentPathCompression(a)
    val xb = findParentPathCompression(b)
    if (xa < xb) parent[xb] = xa
    else parent[xa] = xb
}

fun main() {
    val sc = Scanner(System.`in`)
    v = sc.nextInt()
    e = sc.nextInt()

    // 부모 테이블상에서, 부모를 자기 자신으로 초기화
    for (i in 1 .. v) {
        parent[i] = i
    }

    // Union 연산을 각각 수행
    for (i in 0 until e) {
        val a = sc.nextInt()
        val b = sc.nextInt()
        unionParent(a, b)
    }

    // 각 원소가 속한 집합 출력하기
    print("각 원소가 속한 집합: ")
    for (i in 1 .. v) {
        print("${findParentPathCompression(i)} ")
    }
    println()

    // 부모 테이블 내용 출력하기
    print("부모 테이블: ")
    for (i in 1 .. v) {
        print("${parent[i]} ")
    }
    println()
}