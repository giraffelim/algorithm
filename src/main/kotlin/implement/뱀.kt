package implement

import java.util.Scanner

/**
 *  https://www.acmicpc.net/problem/3190
 */

private val snake = mutableListOf<Pair<Int, Int>>() // 뱀의 위치
private val movePlan = mutableListOf<Pair<Int, Char>>() // 이동 계획
private var second = 0 // 초
private var n = 0 // 보드의 크기
private var endFlag = false // 게임 종료 플래그
private var snakeDirection = 0 // 동쪽(0), 남쪽(1), 서쪽(2), 북쪽(3)
private val dx = mutableListOf(0, 1, 0, -1)
private val dy = mutableListOf(1, 0, -1, 0)

fun main() {
    val sc = Scanner(System.`in`)
    n = sc.nextInt() // 보드의 크기

    val map = Array(n) { IntArray(n) } // 맵
    snake.add(Pair(0, 0))

    val k = sc.nextInt() // 사과의 갯수
    for (i in 0 until k) {
        val x = sc.nextInt().minus(1) // 사과의 위치(행)
        val y = sc.nextInt().minus(1) // 사과의 위치(열)
        map[x][y] = 1  // 맵의 x, y 위치에 사과를 위치시킨다
    }

    val l = sc.nextInt() // 방향 변환 횟수
    for (i in 0 until l) {
        val second = sc.nextInt() // 초
        val direction = sc.next().first() // 방향
        movePlan.add(Pair(second, direction))
    }

    while (true) {
        move(map)
        if (endFlag) {
            break
        }
    }

    println(second)
}

private fun move(map: Array<IntArray>) {
    val snakeLocation = snake.last()
    val matchPlan = movePlan.firstOrNull { it.first == second }
    matchPlan?.let { plan -> changeSnakeDirection(plan.second) }

    val nx = snakeLocation.first.plus(dx[snakeDirection])
    val ny = snakeLocation.second.plus(dy[snakeDirection])

    if (canMove(nx, ny) && !isCollide(nx, ny)) {
        // 이동한 맵에 사과가 있는지 확인
        if (map[nx][ny] == 1) {
            snake.add(Pair(nx, ny))
            map[nx][ny] = 0
        } else {
            snake.add(Pair(nx, ny))
            snake.removeFirst()
        }
    } else {
        endFlag = true
    }

    second++
}

private fun canMove(nx: Int, ny: Int): Boolean {
    return !(nx >= n || nx < 0 || ny >= n || ny < 0)
}

private fun isCollide(nx: Int, ny: Int): Boolean {
    return snake.any { it.first == nx && it.second == ny }
}


private fun changeSnakeDirection(direction: Char) {
    if (direction == 'L') if (snakeDirection == 0) snakeDirection = 3 else snakeDirection -= 1
    else snakeDirection = (snakeDirection + 1) % 4
}