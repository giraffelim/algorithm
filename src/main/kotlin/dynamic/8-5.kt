package dynamic

import java.util.Scanner
import kotlin.math.min

// 앞서 계산한 결과를 저장하기 위한 DP 테이블 초기화
var dArr = Array(30001) { 0 }

fun main() {
    val sc = Scanner(System.`in`)
    val x = sc.nextInt()

    for (i in 2..x) {
        // 현재의 수에서 1을 빼는 경우
        dArr[i] = dArr[i - 1] + 1
        // 현재의 수가 2로 나누어 떨어지는 경우
        if (i % 2 == 0) {
            dArr[i] = min(dArr[i], dArr[i / 2] + 1)
        }
        // 현재의 수가 3으로 나누어 떨어지는 경우
        if (i % 3 == 0) {
            dArr[i] = min(dArr[i], dArr[i / 3] + 1)
        }
        // 현재의 수가 5로 나누어 떨어지는 경우
        if (i % 5 == 0) {
            dArr[i] = min(dArr[i], dArr[i / 5] + 1)
        }
    }

    println(dArr[x])
}