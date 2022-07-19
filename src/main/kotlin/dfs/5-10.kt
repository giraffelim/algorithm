package dfs

import java.util.Scanner


fun dfs(x: Int, y: Int, n: Int, m: Int, graph: Array<IntArray>, visited: Array<IntArray>): Boolean {
    if (x < 0 || x >= n || y < 0 || y >= m) {
        return false
    }

    if (graph[x][y] == 0 && visited[x][y] == 0) {
        visited[x][y] = 1
        dfs(x - 1, y, n, m, graph, visited)
        dfs(x, y - 1, n, m, graph, visited)
        dfs(x + 1, y, n, m, graph, visited)
        dfs(x, y + 1, n, m , graph, visited)
        return true
    }

    return false
}

fun main() {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()
    val m = sc.nextInt()
    val graph = Array(m) { IntArray(n) }
    val visited = Array(m) { IntArray(n) }
    var result = 0
    sc.nextLine()

    for (i in 0 until n) {
        val str = sc.nextLine()
        val chunked = str.chunked(1)
        for (j in chunked.indices) {
            graph[i][j] = chunked[j].toInt()
        }
    }

    for (i in 0 until n) {
        for (j in 0 until m) {
            println("$i, $j")
            if (dfs(i, j, n, m, graph, visited)) {
                result++
            }
        }
    }

    println(result)
}