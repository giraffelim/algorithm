package graph

import java.util.Scanner

// 부모 테이블
private val parent = (0..10001).toMutableList()

// 특정 원소가 속한 집합 찾기
private fun findParent(x: Int): Int {
    if (x == parent[x]) return x
    return findParent(parent[x]).also { parent[x] = it }
}

// 두 원소가 속한 집합을 합치기
private fun unionParent(a: Int, b: Int) {
    val xa = findParent(a)
    val xb = findParent(b)
    if (xa < xb) parent[xb] = parent[xa]
    else parent[xa] = parent[xb]
}

private fun compareParent(a: Int, b: Int) {
    if (findParent(a) == findParent(b)) {
        println("YES")
    } else {
        println("NO")
    }
}

fun main() {
    val sc = Scanner(System.`in`)

    val n = sc.nextInt() // 팀의 갯수
    val m = sc.nextInt() // 주어지는 연산의 개수

    for (i in 0 until m) {
        val o = sc.nextInt() // 연산
        val a = sc.nextInt()
        val b = sc.nextInt()

        if (o == 0) {
            unionParent(a, b)
        } else {
            compareParent(a, b)
        }
    }
}