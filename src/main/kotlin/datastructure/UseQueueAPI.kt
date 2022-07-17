package datastructure

fun main() {
    val queue = ArrayDeque<Int>()
    queue.add(5)
    queue.add(2)
    queue.add(3)
    queue.add(7)
    queue.removeFirst()
    queue.add(1)
    queue.add(4)
    queue.removeFirst()

    println(queue)
    println(queue.reversed())
}