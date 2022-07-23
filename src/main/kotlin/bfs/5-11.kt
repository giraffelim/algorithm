package bfs

import java.util.Scanner

private var graph: Array<IntArray> = arrayOf()
private var n: Int = 0
private var m: Int = 0
private val dx = listOf(-1, 1, 0, 0)
private val dy = listOf(0, 0, -1, 1)


fun main() {
    val sc = Scanner(System.`in`)
    n = sc.nextInt()
    m = sc.nextInt()

    graph = Array(n) { IntArray(m) }
    for (i in 0 until n) {
        for (j in 0 until m) {
            graph[i][j] = sc.nextInt()
        }
    }

    val result = bfs(0, 0)
    println(result)
}

fun bfs(x: Int, y: Int): Int {
    var x1 = x
    var y1 = y
    // deque
    val q = ArrayDeque<Pair<Int, Int>>()
    q.add(Pair(x1, y1))

    // 큐가 빌 때까지 반복
    while(!q.isEmpty()) {
        val node = q.removeFirst()
        x1 = node.first
        y1 = node.second
        // 동서남북 확인
        for (i in 0 until 4) {
            val nx = x1 + dx[i]
            val ny = y1 + dy[i]
            // 맵을 벗어날 경우 무시
            if (nx < 0 || nx >= n || ny >= m || ny < 0) continue
            // 벽인 경우 무시
            if (graph[nx][ny] == 0) continue
            // 처음 방문하는가?
            if (graph[nx][ny] == 1) {
                graph[nx][ny] = graph[x1][y1] + 1
                q.add(Pair(nx, ny))
            }
        }
    }

    return graph[n - 1][m - 1]
}