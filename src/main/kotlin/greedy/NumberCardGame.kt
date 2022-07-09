/**
 *  숫자 카드 게임은 여러 개의 숫자 카드 중에서 가장 높은 숫자가 쓰인 카드 한 장을 뽑는 게임이다.
 *  단, 게임의 룰을 지키며 카드를 뽑아야하고 룰은 다음과 같다.
 *  1. 숫자가 쓰인 카드들이 N X M 형태로 놓여있다. 이 때 N은 행의 개수를 의미하여 M은 열의 개수를 의미한다.
 *  2. 먼저 뽑고자 하는 카드가 포함되어 있는 행을 선택한다.
 *  3. 그 다음 선택된 행에 포함된 카드들 중 가장 숫자가 낮은 카드를 뽑아야 한다.
 *  4. 따라서 처음에 카드를 골라낼 행을 선택할 때, 이후에 해당 행에서 가장 숫자가 낮은 카드를 뽑을 것을 고려하여
 *  최종적으로 가장 숫자가 높은 카드를 뽑을 수 있도록 전략을 세워야한다.
 */

/**
 *  입력 조건
 *  1. 첫째줄에 카드들이 놓인 행의 개수 N과 열의 개수 M이 공백을 기준으로 하여 각각 자연수로 주어진다.(1 <= N, M <= 100)
 *  2. 둘째 줄부터 N개의 줄에 걸쳐 각 카드에 적힌 숫자가 주어진다. 각 숫자는 1 이상 10,000이하의 자연수이다.
 */

/**
 *  출력 조건
 *  1. 첫째 줄에 게임의 룰에 맞게 선택한 카드에 적힌 숫자를 출력한다.
 */

package greedy

import java.util.*
import kotlin.math.max
import kotlin.math.min

fun main() {
    val sc = Scanner(System.`in`)
    // 행, 열 입력 받기
    val n = sc.nextInt()
    val m = sc.nextInt()

    var result = 0
    for (i in 1..n) {
        var minValue = 10001
        for (j in 1..m) {
            val x = sc.nextInt()
            minValue = min(minValue, x)
        }
        result = max(result, minValue)
    }

    println(result)
}