package boj

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

/**
 *  https://www.acmicpc.net/problem/15649
 */

private var N = 0
private var M  = 0
private lateinit var arr: IntArray
private lateinit var visit: BooleanArray
private var sb = StringBuilder()

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val st = StringTokenizer(br.readLine())

    // 정적변수 N과 M을 초기화해준다.
    N = st.nextToken().toInt()
    M = st.nextToken().toInt()
    arr = IntArray(M)
    visit = BooleanArray(N)

    // 정적변수를 쓰면 되기 때문에 굳이 N과 M을 넘겨줄 필요 없다.
    dfs(0)
    println(sb)
}

private fun dfs(depth: Int) {
    if (depth == M) {
        for (value in arr) {
            sb.append("$value ")
        }
        sb.append('\n')
        return
    }
    for (i in 0 until N) {
        if (!visit[i]) {
            visit[i] = true
            arr[depth] = i + 1
            dfs(depth + 1)
            visit[i] = false
        }
    }
}