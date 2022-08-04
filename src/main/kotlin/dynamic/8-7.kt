package dynamic

import java.util.Scanner

fun main() {
    val sc = Scanner(System.`in`)

    // 정수 N을 입력 받기
    val n = sc.nextInt()

    // 다이나믹 프로그래밍 진행(보텀업)
    d[1] = 1
    d[2] = 3
    for (i in 3 .. n) {
        d[i] = (d[i - 1] + 2 * d[i - 2]) % 796796
    }

    println(d[n])
}