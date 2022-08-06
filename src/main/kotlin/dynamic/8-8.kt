package dynamic

import java.util.Scanner
import kotlin.math.min

fun main() {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt() // 화폐 갯수
    val m = sc.nextInt() // 만들 금액

    val coin = mutableListOf<Int>()
    for (i in 0 until n) {
        coin.add(sc.nextInt())
    }

    val d = Array(m + 1) { 10001 } // dp 테이블
    d[0] = 0

    for (i in 0 until n) {
        for (j in coin[i] .. m) {
            // (i - k)원을 만드는 방법이 존재하는 경우
            if (d[j - coin[i]] != 10001) {
                d[j] = min(d[j], d[j - coin[i]] + 1)
            }
        }
    }

    // 계산된 결과 출력
    if (d[m] == 10001) { // 최종적으로 M원을 만드는 방법이 없는 경우
        println(-1)
    } else {
        println(d[m])
    }
}