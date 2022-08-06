package dynamic

import java.util.Scanner
import kotlin.math.max

var foodArr = Array(101) { 0 }

fun main() {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()
    val storage = Array(n) { 0 }

    for (i in 0 until n) {
        storage[i] = sc.nextInt()
    }

    foodArr[0] = storage[0]
    foodArr[1] = max(storage[0], storage[1])

    for (i in 2 until storage.size) {
        foodArr[i] = max(foodArr[i - 1], foodArr[i - 2] + storage[i])
    }

    println(foodArr[n - 1])
}