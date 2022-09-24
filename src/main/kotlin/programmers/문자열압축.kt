package programmers

/**
 *  https://school.programmers.co.kr/learn/courses/30/lessons/60057
 */

private fun solution(s: String): Int {
    var count = 1
    var min = Int.MAX_VALUE

    while (count <= s.length / 2 + 1) {
        val pairs = mutableListOf<Pair<Int, String>>()
        val ns = s.chunked(count)
        var sameCount = 1
        var prev = ns.first().toString()

        for (i in 1 until ns.size) {
            if (prev == ns[i]) {
                sameCount++
            } else {
                pairs.add(Pair(sameCount, prev))
                sameCount = 1
            }
            prev = ns[i]
        }

        pairs.add(Pair(sameCount, prev))

        val t = pairs.fold(0) { total, pair ->
            total + countLength(pair.first) + pair.second.length
        }

        if (min > t) {
            min = t
        }

        count++
    }

    return min
}

private fun countLength(i: Int): Int {
    return if (i == 1) {
        0
    } else {
        i.toString().length
    }
}
