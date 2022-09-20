package programmers

/**
 *  https://school.programmers.co.kr/learn/courses/30/lessons/42889
 */

private fun solution(N: Int, stage: IntArray): IntArray {
    val failureRate = mutableListOf<Pair<Int, Double>>()
    var total = stage.size

    for (i in 1 .. N) {
        val notClear = stage.count { it == i }
        if (notClear == 0) {
            failureRate.add(Pair(i, 0.0))
        } else {
            failureRate.add(Pair(i, notClear.toDouble() / total.toDouble()))
        }

        total -= notClear
    }

    return failureRate.sortedByDescending { it.second }.map { it.first }.toIntArray()
}