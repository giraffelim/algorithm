package datastructure

import java.util.Stack

fun main() {
    val stack = Stack<Int>()
    stack.add(5)
    stack.add(2)
    stack.add(3)
    stack.add(7)
    stack.pop()
    stack.add(1)
    stack.add(4)
    stack.pop()

    println(stack)
    println(stack.reversed())
}