package sort

fun main() {
    // 모든 원소의 값이 0보다 크거나 같다고 가정
    val arr = arrayOf(7, 5, 9, 0, 3, 1, 6, 2, 9, 1, 4, 8, 0, 5, 2)
    // 모든 범위를 포함하는 배열을 선언(모든 값은 0으로 초기화)
    val cnt = Array(arr.size) { 0 }

    for (i in arr.indices) {
        cnt[arr[i]] += 1
    }

    for (i in arr.indices) {
        for (j in 0 until cnt[i]) {
            print("$i ")
        }
    }
}