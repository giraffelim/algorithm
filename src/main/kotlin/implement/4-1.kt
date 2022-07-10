package implement

import java.util.Scanner

fun solutionByAuthor(n: Int, plans: List<String>) {
    var x = 1;
    var y = 1

    // L, R, U, D에 따른 이동방향
    val dx = listOf(0, 0, -1, 1)
    val dy = listOf(-1, 1, 0, 0)
    val moveTypes = listOf('L', 'R', 'U', 'D')

    // 이동 계획을 하나씩 확인
    plans.forEach {
        // 이동 후 좌표 구하기
        var nx = -1;
        var ny = -1
        for (j in 0..3) {
            if (it.first() == moveTypes[j]) {
                nx = x + dx[j]
                ny = y + dy[j]
            }
        }
        // 공간을 벗어나는 경우 무시
        if (nx < 1 || ny < 1 || nx > n || ny > n) return@forEach

        // 이동 수행
        x = nx
        y = ny
    }

    println("$x $y")
}

fun solutionByMe(n: Int, plans: List<String>) {
    var x = 1;
    var y = 1
    plans.forEach {
        when (it) {
            "L" -> if (y != 1) {
                y -= 1
            }
            "R" -> if (y != n) {
                y += 1
            }
            "U" -> if (x != 1) {
                x -= 1
            }
            "D" -> if (x != n) {
                x += 1
            }
        }
    }

    println("$x $y")
}

fun solutionByMe2(n: Int, plans: List<String>) {
    var x = 1;
    var y = 1
    plans.forEach {
        var nx = -1;
        var ny = -1
        when (it) {
            "L" -> {
                ny = y - 1
                nx = x
            }
            "R" -> {
                ny = y + 1
                nx = x
            }
            "U" -> {
                nx = x - 1
                ny = y
            }
            "D" -> {
                nx = x + 1
                ny = y
            }
        }
        if (nx < 1 || ny < 1 || nx > n || ny > n) return@forEach
        x = nx
        y = ny
    }

    println("$x $y")
}

fun main() {
    val sc = Scanner(System.`in`)

    val n = sc.nextInt()
    sc.nextLine()
    // 이동할 계획
    val command = sc.nextLine().split(" ")

    solutionByAuthor(n, command)
    solutionByMe(n, command)
    solutionByMe2(n, command)
}