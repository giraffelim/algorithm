package sort

import java.util.Scanner

fun main() {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()
    val k = sc.nextInt()

    val arrA = mutableListOf<Int>()
    val arrB = mutableListOf<Int>()

    for (i in 0 until n) {
        arrA.add(sc.nextInt())
    }

    for (i in 0 until n) {
        arrB.add(sc.nextInt())
    }

    arrA.sort()
    arrB.sortDescending()

    for (i in 0 until k) {
        if (arrA[i] < arrB[i]) {
            val temp = arrA[i]
            arrA[i] = arrB[i]
            arrB[i] = temp
        }
        else break
    }

    println(arrA.sum())
}