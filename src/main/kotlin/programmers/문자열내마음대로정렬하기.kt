package programmers

/**
 *  https://school.programmers.co.kr/learn/courses/30/lessons/12915
 */

fun solution(strings: Array<String>, n: Int): Array<String> {
    return strings.map { it.toCharArray() }.sortedWith(compareBy({ it[n] }, { String(it) })).map { String(it) }.toTypedArray()
}