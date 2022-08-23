package graph

import java.util.*

private var v: Int = 0 // 노드의 개수
private var e: Int = 0 // 간선의 개수(Union 연산)
private val parent = IntArray(100001) // 부모 테이블

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

    var cycle = false // 사이클 발생 여부
    for (i in 0 until e) {
        val a = sc.nextInt()
        val b = sc.nextInt()
        // 사이클이 발생한 경우 종료
        if (findParentPathCompression(a) == findParentPathCompression(b)) {
            cycle = true
            break;
        }
        // 사이클이 발생하지 않았다면 합집합(Union) 연산 수행
        else { unionParent(a, b) }
    }

    if (cycle) {
        println("사이클이 발생했습니다.")
    } else {
        println("사이클이 발생하지 않았습니다.")
    }
}