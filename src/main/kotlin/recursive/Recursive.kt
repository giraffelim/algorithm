package recursive

fun recursive(i: Int) {
    if (i == 100) return
    println("${i}번째 재귀 함수에서, ${i+1} 번째 재귀 함수를 호출합니다.")
    recursive(i + 1)
    println("${i}번째 재귀 함수를 종료합니다.")
}

fun factorialIterative(n: Int): Int {
    var result = 1
    // 1부터 n까지의 수를 차례대로 곱하기
    for (i in IntRange(1, n)) result *= i
    return result
}

fun factorialRecursive(n: Int): Int {
    if (n <= 1) return 1
    return n * factorialRecursive(n - 1)
}

fun main() {
    recursive(1)
    println(factorialIterative(5))
    println(factorialRecursive(5))
}