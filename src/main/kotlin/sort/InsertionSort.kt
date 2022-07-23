package sort

fun main() {
    val n = 10
    val arr = arrayOf(7, 5, 9, 0, 3, 1, 6, 2, 4, 8)

    for (i in 1 until n) {
        for (j in i downTo 1) {
            // 한 칸씩 왼쪽으로 이동
            if (arr[j] < arr[j - 1]) {
                // 스와프
                val temp = arr[j]
                arr[j] = arr[j - 1]
                arr[j - 1] = temp
            }
            // 자기보다 작은 데이터를 만나면 그 위치에서 멈춤
            else break
        }
    }

    arr.forEach { print("$it ") }
}