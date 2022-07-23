package implement

import kotlin.math.abs

/**
 *  주어진 시간 hh:mm (24시간 표기법)에 대한 아날로그 시계의 시침과 분침 사이의 짧은 각도 구하기
 */

fun main() {
    val angle = getAngle(17, 30)
    println(angle)
}

// 1분에 시침은 0.5도 이동
// 1분에 분침은 6도 이동
fun getAngle(h: Int, m: Int): Int {
    val hh = h % 12

    // 시침 = 정각이 아닌 경우는 분침에 이동에 따라 시침도 이동
    val hourAngle = hh * (360 / 12) + (m * 0.5)

    // 분침
    val minuteAngle = (m * (360 / 60)).toDouble()

    return abs(minuteAngle - hourAngle).toInt()
}