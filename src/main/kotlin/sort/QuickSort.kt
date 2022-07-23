package sort

fun quickSort(arr: Array<Int>, start: Int, end: Int) {
    if (start >= end) return // 원소가 1개인 경우 종료
    val pivot = start // 피봇은 첫번째 원소
    var left = start + 1
    var right = end

    while(left <= right) {
        // 피벗보다 큰 데이터를 찾을 때까지 반복
        while(left <= end && arr[left] <= arr[pivot]) {
            left++
        }
        // 피벗보다 작은 데이터를 찾을 때까지 반복
        while(right > start && arr[right] >= arr[pivot]) {
            right--
        }
        // 엇갈렸다면 작은 데이터와 피벗을 교체
        if (left > right) {
            val temp = arr[pivot]
            arr[pivot] = arr[right]
            arr[right] = temp
        }
        // 엇갈리지 않았다면 작은 데이터와 큰 데이터를 교체
        else {
            val temp = arr[left]
            arr[left] = arr[right]
            arr[right] = temp
        }
    }

    // 분할 이후에 왼쪽 부분과 오른쪽 부분에서 각각 정렬을 수행
    quickSort(arr, start, right - 1)
    quickSort(arr, right + 1, end)
}

fun main() {
    val n = 10
    val arr = arrayOf(5, 7, 9, 0, 3, 1, 6, 2, 4, 8)

    quickSort(arr, 0, n - 1)

    arr.forEach { print("$it ") }
}