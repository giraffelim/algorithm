/**
 *  큰 수의 법칙
 *  다양한 수로 이루어진 배열이 있을 때 주어진 수들을 M번 더하여 가장 큰 수를 만드는 법칙
 *  단 배열의 특정한 인덱스(번호)에 해당하는 수가 연속해서 K번을 초과하여 더해질 수 없다.
 */


fun solution(m: Int, k: Int, arr: Array<Int>): Int {
    arr.sortDescending()
    val first = arr[0]
    val second = arr[1]
    var result = 0
    for(i in 1..m) {
        if (i % k == 0) {
            result += second
            continue
        }
        result += first
    }

    return result
}

/**
 *  가장 큰 수와 두번째로 큰 수가 더해질때는 특정한 수열 형태로 일정하게 반복해서 더해지는 특징이 있다.
 *  예시로 들자면 현재 Input 기준으로는 {6,6,6,5}가 반복된다.
 *  여기서 반복되는 수열의 길이는 (k+1)로 구할 수 있다.
 *  따라서 M을 (k+1)로 나눈 값이 반복 횟수가 되고 다시 여기에 k를 곱해주면 큰 수가 등장하는 횟수가 된다.
 *  이때 M이 (K+1)로 나누어 떨어지지 않는 경우도 고려해야 한다. 그럴 때는 M을 (K+1)로 나눈 나머지 만큼 가장 큰 수가
 *  추가되어야 한다.
 *  위 과정을 통해 제일 큰 수가 반복되는 횟수를 알게되고 그 수를 count라고 칭할 때 두번째 숫자가 나오는 횟수는
 *  m - count가 되므로 결과를 구할 수 있다.
 */
fun solution2(m: Int, k: Int, arr: Array<Int>): Int {
    arr.sortDescending()
    val first = arr[0]
    val second = arr[1]
    var result = 0

    // 가장 큰 수가 더해지는 횟수 계산
    var count = (m / (k + 1)) * k
    // m이 나누어 떨어지지 않을 경우 나머지만큼 가장 큰 수가 추가로 더해짐
    count += m % (k + 1)

    result += count * first
    result += (m - count) * second
    return result
}

fun main() {
    val inputArr1 = arrayOf(2, 4, 5, 4, 6)
    val result = solution(m = 8, k = 3, arr = inputArr1)
    println(result)

    val inputArr2 = arrayOf(2, 4, 5, 4, 6)
    val result2 = solution2(m = 8, k = 3, arr = inputArr2)
    println(result2)

    val inputArr3 = arrayOf(2, 4, 5, 4, 6)
    val result3 = solution2(m = 9, k = 3, arr = inputArr3)
    println(result3)
}