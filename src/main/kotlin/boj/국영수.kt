package boj

/**
 *  https://www.acmicpc.net/problem/10825
 */

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val students = mutableListOf<Student>()

    for (i in 0 until n) {
        val st = StringTokenizer(br.readLine())
        val s = Student(st.nextToken(), st.nextToken().toInt(), st.nextToken().toInt(), st.nextToken().toInt())
        students.add(s)
    }

    students.sortWith(
        compareByDescending<Student> { it.korean }.thenBy { it.english }.thenByDescending { it.math }.thenBy { it.name }
    )

    students.forEach { println(it.name) }

}

private class Student(val name: String, val korean: Int, val english: Int, val math: Int)