package implement

import util.ExecutionTime
import java.util.*

fun solutionByMe(input: String) {
    ExecutionTime {
        val split = input.chunked(1)
        val col = (split[0].first().code - 96)
        val row = split[1].toInt()
        var result = 0

        val move = listOf(
            Pair(-2, -1),
            Pair(-2, 1),
            Pair(2, -1),
            Pair(2, 1),
            Pair(1, -2),
            Pair(1, 2),
            Pair(-1, -2),
            Pair(-1, 2)
        )

        move.forEach {
            val nx = col.plus(it.first)
            val ny = row.plus(it.second)
            if (nx in 1..8 && ny in 1..8) result++
        }

        println(result)
    }
}

fun solutionByAuthor(input: String) {
    val split = input.chunked(1)
    val col = (split[0].first().code - 96)
    val row = split[1].toInt()
    var result = 0

    // 나이트가 이동할 수 있는 8가지 방향 정의
    val dx = intArrayOf(-2, -1, 1, 2, 2, 1, -1, -2)
    val dy = intArrayOf(-1, -2, -2, -1, 1, 2, 2, 1)

    // 8가지 방향에 대하여 각 위치로 이동이 가능한지 확인
    for (i in 0..7) {
        // 이동하고자 하는 위치 확인
        val nextRow: Int = row + dx[i]
        val nextColumn: Int = col + dy[i]
        // 해당 위치로 이동이 가능하다면 카운트 증가
        if (nextRow >= 1 && nextRow <= 8 && nextColumn >= 1 && nextColumn <= 8) {
            result += 1
        }
    }

    println(result)
}

fun main() {
    val sc = Scanner(System.`in`)
    val input = sc.next()
    solutionByMe(input)
    solutionByAuthor(input)
}