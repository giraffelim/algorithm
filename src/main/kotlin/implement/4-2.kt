package implement

import util.ExecutionTime
import java.util.Scanner

fun solutionByMe(n: Int) {
    ExecutionTime {
        var result = 0
        for(t in 0..n) {
            for (m in 0 .. 59) {
                for (s in 0 .. 59) {
                    if ("${t}${m}${s}".contains('3')) {
                        result++
                    }
                }
            }
        }

        println(result)
    }
}

fun main() {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()
    solutionByMe(n)
}
