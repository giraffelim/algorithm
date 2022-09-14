package boj

import java.lang.RuntimeException
import java.util.Scanner
import kotlin.math.max
import kotlin.math.min

/**
 *  https://www.acmicpc.net/problem/14888
 */

private val arr = mutableListOf<Char>()
private val visited = BooleanArray(101)
private val arrPermutations = mutableListOf<CharArray>()
private val numArr = mutableListOf<Int>()

fun main() {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()

    for (i in 0 until n) {
        numArr.add(sc.nextInt())
    }

    initCharArr(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt())

    var max = Int.MIN_VALUE
    var min = Int.MAX_VALUE
    permutation(0, arr.size, CharArray(arr.size))

    arrPermutations.forEach { perm ->
        var temp = calculate(perm[0], numArr[0], numArr[1])
        for (i in 1 until perm.size) {
            temp = calculate(perm[i], temp, numArr[i + 1])
        }
        max = max(max, temp)
        min = min(min, temp)
    }

    println(max)
    println(min)
}

private fun initCharArr(plus: Int, minus: Int, multiply: Int, divide: Int) {
    repeat((0 until plus).count()) { arr.add('+') }
    repeat((0 until minus).count()) { arr.add('-') }
    repeat((0 until multiply).count()) { arr.add('*') }
    repeat((0 until divide).count()) { arr.add('/') }
}

private fun calculate(operator: Char, temp: Int, v: Int): Int {
    return when (operator) {
        '+' -> temp + v
        '-' -> temp - v
        '*' -> temp * v
        '/' -> temp / v
        else -> {
            throw RuntimeException()
        }
    }
}

private fun permutation(depth: Int, r: Int, output: CharArray) {
    if (depth == r) {
        arrPermutations.add(output.copyOf())
        return
    }

    for (i in arr.indices) {
        if (!visited[i]) {
            visited[i] = true
            output[depth] = arr[i]
            permutation(depth + 1, r, output)
            visited[i] = false
        }
    }
}