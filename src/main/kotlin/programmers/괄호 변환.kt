package programmers

import java.util.Stack

/**
 *  https://school.programmers.co.kr/learn/courses/30/lessons/60058
 */

private var position = 0

private fun isCorrect(str: String): Boolean {
    var ret = true
    var left = 0
    var right = 0
    val stack = Stack<Char>()

    for (i in str.indices) {
        if (str[i] == '(') {
            left++
            stack.push('(')
        } else {
            right++
            if (stack.isEmpty()) ret = false
            else stack.pop()
        }
        if (left == right) {
            position = i + 1
            return ret
        }
    }

    return true
}

fun solution(p: String): String {
    if (p.isEmpty()) return ""

    val correct = isCorrect(p)
    val u = p.substring(0, position)
    val v = p.substring(position, p.length)

    if (correct) {
        return u + solution(v)
    }

    var answer = "(" + solution(v) + ")"
    for (i in 1 until u.length - 1) {
        answer += if (u[i] == '(') ')' else '('
    }

    return answer
}

fun main() {
    solution("((())")
}