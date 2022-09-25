package boj

/**
 *  https://www.acmicpc.net/problem/1715
 */

import java.util.*

fun main() {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()
    var result = 0

    // 우선순위 큐 사용
    val pq = PriorityQueue<Int>()
    for (i in 0 until n) {
        pq.offer(sc.nextInt())
    }

    // 힙에 원소가 1개 남을때까지
    while (pq.size != 1) {
        // 가장 작은 2개의 카드 묶음 꺼내기
        val one = pq.poll()
        val two = pq.poll()
        val summary = one + two
        result += summary
        pq.offer(summary)
    }

    println(result)
}