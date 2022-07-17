package graph

import java.util.LinkedList

fun adjacencyMatrix() {
    val inf = 999999999 // 무한의 비용 선언

    // 2차원 리스트를 이용해 인접 행렬 표현
    val graph = listOf(
        listOf(0, 7, 5),
        listOf(7, 0, inf),
        listOf(5, inf, 0)
    )

    println(graph)
}

fun adjacencyList() {
    val graph = LinkedHashMap<Int, LinkedList<Pair<Int, Int>>>()
    graph.apply {
        set(0, LinkedList(listOf(Pair(1, 7), Pair(2, 5)))) // Node, Edge
        set(1, LinkedList(listOf(Pair(0, 7))))
        set(2, LinkedList(listOf(Pair(0, 5))))
    }

    println(graph)
}

fun main() {
    adjacencyMatrix()
    adjacencyList()
}