package implement

/**
 *  https://school.programmers.co.kr/learn/courses/30/lessons/60059
 */

private fun solution(key: Array<IntArray>, lock: Array<IntArray>): Boolean {
    val n = lock.size
    val m = key.size
    // 자물쇠의 크기를 기존의 3배로 전환
    val newLock = Array(n * 3) { IntArray(n * 3) }
    var newKey = key
    // 새로운 자물쇠의 중앙 부분에 기존의 자물쇠 넣기
    for (i in 0 until n) {
        for (j in 0 until n) {
            newLock[i + n][j + n] = lock[i][j]
        }
    }

    // 4가지 방향에 대해서 확인
    for (rotation in 0 until 4) {
        newKey = rotateMatrixBy90Degree(newKey) // 열쇠 회전
        for (x in 0 until n * 2) {
            for (y in 0 until n * 2) {
                // 자물쇠에 열쇠를 끼워넣기
                for (i in 0 until m) {
                    for (j in 0 until m) {
                        newLock[x + i][y + j] += newKey[i][j]
                    }
                }
                // 새로운 자물쇠에 열쇠가 정확히 들어맞는지 검사
                if (check(newLock)) return true
                // 자물쇠에서 열쇠를 빼기
                for (i in 0 until m) {
                    for (j in 0 until m) {
                        newLock[x + i][y + j] -= newKey[i][j]
                    }
                }
            }
        }
    }

    return false
}

private fun rotateMatrixBy90Degree(key: Array<IntArray>): Array<IntArray> {
    val n = key.size
    val newKey = Array(n) { IntArray(n) }

    for (i in key.indices) {
        for (j in key.indices) {
            newKey[j][n - i - 1] = key[i][j]
        }
    }

    return newKey
}

private fun check(newLock: Array<IntArray>): Boolean {
    val lockLength = newLock.size / 3
    for (i in lockLength until lockLength * 2) {
        for (j in lockLength until lockLength * 2) {
            if (newLock[i][j] != 1) {
                return false
            }
        }
    }

    return true
}

fun main() {
    val key = arrayOf(intArrayOf(0, 0, 0), intArrayOf(1, 0, 0), intArrayOf(0, 1, 1))
    val lock = arrayOf(intArrayOf(1, 1, 1), intArrayOf(1, 1, 0), intArrayOf(1, 0, 1))
    println(solution(key, lock))
}