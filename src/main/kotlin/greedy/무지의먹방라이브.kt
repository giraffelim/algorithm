package greedy

fun main() {
    val result = solution(intArrayOf(3, 5, 1, 5, 4, 3), 20)
    println(result)
}

fun solution(food_times: IntArray, k: Long): Int {
    // Pair<번호, 시간>
    val foods = food_times.mapIndexed { index, i -> Pair(index + 1, i) }.sortedBy { it.second }
    // 총 음식 갯수
    var len = foods.size
    // 이전 음식을 먹는데 걸린 시간
    var previous = 0
    // 남은 시간
    var remain = k
    // 음식을 먹는데 걸린 시간
    var spend: Int

    for (food: Pair<Int, Int> in foods) {
        val diff = food.second - previous
        if (diff != 0) {
            spend = diff * len // 차이 * 남은 음식
            if (spend <= remain) {
                remain -= spend
                previous = food.second
            }
            else {
                val remainFoods = foods.drop(food_times.size - len).sortedBy { it.first }
                return remainFoods[(remain % len).toInt()].first
            }
        }
        len--
    }


    return -1
}