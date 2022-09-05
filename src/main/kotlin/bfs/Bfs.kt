package bfs

import java.util.LinkedList

private var visited = BooleanArray(9)
private var graph = ArrayList<ArrayList<Int>>()

private fun bfs(start: Int) {
    val q = LinkedList<Int>()
    q.offer(start)
    // 현재 노드를 방문 처리
    visited[start] = true
    // 큐가 빌 때까지 반복
    while(!q.isEmpty()) {
        // 큐에서 하나의 원소를 뽑아서 출력
        val x = q.poll()
        print("$x ")
        // 해당 원소와 연결된, 아직 방문하지 않은 원소들을 큐에 삽입
        for (i in 0 until graph[x].size) {
            val y = graph[x][i]
            if (!visited[y]) {
                q.offer(y)
                visited[y] = true
            }
        }
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

    bfs(1)
}