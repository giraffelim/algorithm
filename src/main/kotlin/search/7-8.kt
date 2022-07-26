package search

import java.util.Scanner

fun main() {
    val sc = Scanner(System.`in`)
    // 떡의 개수
    val n = sc.nextInt()
    // 떡의 길이
    val m = sc.nextInt()
    // 각 떡의 개별 높이 정보
    val arr = arrayListOf<Int>()
    for (i in 0 until n) {
        arr.add(sc.nextInt())
    }

    // 이진 탐색을 위한 시작점과 끝점
    var start = 0
    var end = arr.maxOf { it }

    var result = 0

    while(start <= end) {
        var total = 0
        val mid = start.plus(end).div(2)
        arr.forEach {
            if (it > mid) {
                // 잘랐을 때 떡의 양 계산
                total += (it - mid)
            }
        }
        if (total < m) end = mid - 1 // 떡의 양이 부족한 경우 더 많이 자르기(왼쪽 부분 탐색)
        else { // 떡의 양이 충분한 경우 덜 자르기(오른쪽 부분 탐색)
            result = mid // 최대한 덜 잘랐을 때가 정답이므로, 여기에서 result에 기록
            start = mid + 1
        }
    }

    println(result)
}