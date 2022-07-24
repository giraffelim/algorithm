package search

import java.util.Scanner

fun main() {
    val sc = Scanner(System.`in`)

    // 원소의 개수(n)와 찾고자 하는 값(target)을 입력받기
    val n = sc.nextInt()
    val target = sc.nextInt()

    // 전체 원소 입력받기
    val arr = mutableListOf<Int>()
    for (i in 0 until n) {
        arr.add(sc.nextInt())
    }

    val result = binarySearchByWhile(arr, target, 0, n - 1)
    if (result == -1) {
        println("원소가 존재하지 않습니다.")
    } else {
        println("${result + 1}")
    }
}

fun binarySearchByRecursive(arr: List<Int>, target: Int, start: Int, end: Int): Int {
    if (start > end) return -1
    val mid = start.plus(end).div(2)
    // 찾은 경우 중간점 인덱스 반환
    if (arr[mid] == target) return mid
    // 중간점의 값보다 찾고자 하는 값이 작은 경우 왼쪽 확인
    else if (arr[mid] > target) return binarySearchByRecursive(arr, target, start, mid - 1)
    // 중간점의 값보다 찾고자 하는 값이 큰 경우 오른쪽 확인
    else return binarySearchByRecursive(arr, target, mid + 1, end)
}

fun binarySearchByWhile(arr: List<Int>, target: Int, start: Int, end: Int): Int {
    var nStart = start
    var nEnd = end
    while (nStart <= nEnd) {
        val mid = nStart.plus(nEnd).div(2)
        // 찾은 경우 중간 인덱스 반환
        if (arr[mid] == target) return mid
        // 중간점의 값보다 찾고자 하는 값이 작은 경우 왼쪽 확인
        if (arr[mid] > target) nEnd = mid - 1
        // 중간점의 값보다 찾고자 하는 값이 큰 경우 오른쪽 확인
        if (arr[mid] < target) nStart = mid + 1
    }
    return -1
}