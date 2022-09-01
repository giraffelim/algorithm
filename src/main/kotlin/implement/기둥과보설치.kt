package implement

import java.util.Scanner

/**
 *  https://school.programmers.co.kr/learn/courses/30/lessons/60061
 */

private class Frame(
    val x: Int,
    val y: Int,
    val s: Int,
    val c: Int
)

private class Structure(
    val x: Int,
    val y: Int,
    val s: Int
)

private fun solution(n: Int, build_frame: Array<IntArray>): Array<IntArray> {
    val frames = build_frame.map { c -> Frame(c[0], c[1], c[2], c[3]) }
    val result = mutableListOf<Structure>()

    for (i in frames.indices) {
        val bf = frames[i]
        if (bf.c == 1) {
            val structure = Structure(bf.x, bf.y, bf.s)
            result.add(structure)
            if (!possible(result)) {
                result.removeLast()
            }
        } else {
            val removeStructure = Structure(bf.x, bf.y, bf.s)
            result.removeIf { it.x == removeStructure.x && it. y == removeStructure.y && it.s == removeStructure.s }
            if (!possible(result)) {
                result.add(removeStructure)
            }
        }
    }

    return result.sortedWith(compareBy({ it.x }, { it.y }, {it.s})).map { intArrayOf(it.x, it.y, it.s) }.toTypedArray()
}

private fun possible(result: MutableList<Structure>): Boolean {
    for (i in result.indices) {
        val structure = result[i]
        if (structure.s == 0) {
            var check = false
            if (structure.y == 0) check = true
            for (j in result.indices) {
                if (result[j].x == structure.x - 1 && result[j].y == structure.y && result[j].s == 1) {
                    check = true
                }
                if (result[j].x == structure.x && result[j].y == structure.y && result[j].s == 1) {
                    check = true
                }
                if (result[j].x == structure.x && result[j].y == structure.y - 1 && result[j].s == 0) {
                    check = true
                }
            }
            if (!check) {
                return false
            }
        } else {
            var check = false
            var right = false
            var left = false
            for (j in result.indices) {
                if (result[j].x == structure.x && result[j].y == structure.y - 1 && result[j].s == 0) {
                    check = true
                }
                if (result[j].x == structure.x + 1 && structure.y - 1 == result[j].y && result[j].s == 0) {
                    check = true
                }
                // 왼쪽에 보
                if (result[j].x - 1 == structure.x && result[j].y == structure.y && result[j].s == 1) {
                    left = true
                }
                // 오른쪽에 보
                if (result[j].x + 1 == structure.x && result[j].y == structure.y && result[j].s == 1) {
                    right = true
                }
            }
            if (right && left) check = true
            if (!check) {
                return false
            }
        }
    }

    return true
}

fun main() {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt() // n x n 크기의 정사각형 형태
//    val build_frame =
//        arrayOf(
//            intArrayOf(0, 0, 0, 1), intArrayOf(2, 0, 0, 1), intArrayOf(4, 0, 0, 1), intArrayOf(0, 1, 1, 1),
//            intArrayOf(1, 1, 1, 1), intArrayOf(2, 1, 1, 1), intArrayOf(3, 1, 1, 1), intArrayOf(2, 0, 0, 0),
//            intArrayOf(2, 0, 0, 0), intArrayOf(1, 1, 1, 0), intArrayOf(2, 2, 0, 1)
//        )

    val build_frame =
        arrayOf(
            intArrayOf(2, 0, 0, 1), intArrayOf(100, 0, 0, 1), intArrayOf(100, 1, 1, 1), intArrayOf(99, 1, 1, 1),
            intArrayOf(99, 1, 0, 1), intArrayOf(99, 0, 0, 1))

    solution(n, build_frame)
}