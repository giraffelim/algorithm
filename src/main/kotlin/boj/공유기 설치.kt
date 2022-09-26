package boj

/**
 *  https://www.acmicpc.net/problem/2110
 */

import java.util.*

fun main() {
    //  집의 개수(N)와 공유기의 개수(C)를 입력받기
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()
    val c = sc.nextInt()

    // 전체 집의 좌표 정보를 입력받기
    val arr = ArrayList<Int>()
    for (i in 0 until n) {
        arr.add(sc.nextInt())
    }

    // 이진 탐색을 위해 정렬 수행
    arr.sort()

    var start = 1 // 가능한 최소 거리(min gap)
    var end = arr[n - 1] - arr[0] // 가능한 최대 거리(max gap)
    var result = 0

    while (start <= end) {
        // mid는 가장 인접한 두 공유기 사이의 거리(gap)을 의미
        val mid = (start + end) / 2
        // 첫째 집에는 무조건 공유기를 설치한다고 가정
        var value = arr[0]
        var cnt = 1
        // 현재의 mid 값을 이용해 공유기를 설치하기
        for (i in 1 until n) { // 앞에서부터 차근차근 설치
            if (arr[i] >= value + mid) {
                value = arr[i]
                cnt += 1
            }
        }
        // C개 이상의 공유기를 설치할 수 있는 경우, 거리를 증가시키기
        if (cnt >= c) {
            start = mid + 1
            result = mid // 최적의 결과를 저장
        } else {
            end = mid - 1
        }
    }
    println(result)
}