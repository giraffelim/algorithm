package dfs

private var visited = BooleanArray(9)
private var graph = ArrayList<ArrayList<Int>>()

private fun dfs(x: Int) {
    visited[x] = true
    print("$x ")
    for (i in graph[x].indices) {
        val y = graph[x][i]
        if (!visited[y]) dfs(y)
    }
}

fun main() {
    // 그래프 초기화
    for (i in 0 .. 8) {
        graph.add(arrayListOf())
    }

    // 노드 1에 연결된 노드 정보 저장
    graph[1].addAll(listOf(2, 3, 8))

    // 노드 2에 연결된 노드 정보 저장
    graph[2].addAll(listOf(1, 7))

    // 노드 3에 연결된 노드 정보 저장
    graph[3].addAll(listOf(1, 4, 5))

    // 노드 4에 연결된 노드 정보 저장
    graph[4].addAll(listOf(3, 5))

    // 노드 5에 연결된 노드 정보 저장
    graph[5].addAll(listOf(3, 4))

    // 노드 6에 연결된 노드 정보 저장
    graph[6].addAll(listOf(7))

    // 노드 7에 연결된 노드 정보 저장
    graph[7].addAll(listOf(2, 6, 8))

    // 노드 8에 연결된 노드 정보 저장
    graph[8].addAll(listOf(1, 7))

    dfs(1)
    println()
}