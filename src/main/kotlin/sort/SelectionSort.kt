package sort

fun main() {
    val array = arrayOf(7, 5, 9, 0, 3, 1, 6, 2, 4, 8)
    val n = array.size

    for (i in 0 until n) {
        var min = i // 가장 작은 원소의 인덱스
        for (j in i + 1 until n) {
            if (array[j] < array[min]) {
                min = j
            }
        }

        // 스와프
        val temp = array[i]
        array[i] = array[min]
        array[min] = temp
//        Collections.swap(array.asList(), i, min)
    }

    array.forEach { print("$it ") }

    array.sort()
}