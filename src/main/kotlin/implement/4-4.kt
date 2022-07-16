package implement

import util.ExecutionTime
import java.util.Scanner

fun solutionByMe(sc: Scanner, initData: GameInitData) {
    ExecutionTime {
        // N X M 크기의 맵 선언
        val map = Array(initData.n) { IntArray(initData.m) }
        // N X M 크기의 유저가 이동한 구역을 마킹하는 맵 선언
        val movement = Array(initData.n) { IntArray(initData.m) }
        // 바라보는 방향에 따라 더해야 하는 값(캐릭터는 현재 방향을 기준으로 왼쪽으로 이동)
        val dx = listOf(-1, 0, 1, 0)
        val dy = listOf(0, -1, 0, 1)
        // 맵 초기화
        for (i in 0 until initData.n) {
            for (j in 0 until initData.m) {
                map[i][j] = sc.nextInt()
            }
        }
        // 유저가 처음 서있는 곳 마킹
        movement[initData.x][initData.y] = 1

        var direction = initData.direction
        var result = 1
        var turnTime = 0
        var x = initData.x
        var y = initData.y

        while(true) {
            direction -= 1 // 왼쪽으로 방향을 변경
            if (direction == -1) direction = 3 // 북쪽(0)에서 왼쪽을 볼 경우 서쪽
            var nx = x.plus(dx[direction])
            var ny = y.plus(dy[direction])

            if (map[nx][ny] == 0 && movement[nx][ny] == 0) {
                movement[nx][ny] = 1
                result++
                x = nx
                y = ny
                turnTime = 0
                continue
            } else turnTime++

            if (turnTime == 4) {
                nx = x.minus(dx[direction])
                ny = y.minus(dy[direction])
                if (map[nx][ny] == 0) {
                    x = nx
                    y = ny
                } else break
                turnTime = 0
            }
        }

        println("유저의 이동경로")
        printMap(movement)
        println("유저가 이동한 횟수: $result")
    }
}

fun printMap(map: Array<IntArray>) {
    // 맵 출력
    map.forEach {
        it.forEach { m ->
            print("$m ")
        }
        println()
    }
}

fun main() {
    val sc = Scanner(System.`in`)
    val initData = GameInitData(
        n = sc.nextInt(),
        m = sc.nextInt(),
        x = sc.nextInt(),
        y = sc.nextInt(),
        direction = sc.nextInt()
    )

    solutionByMe(sc, initData)
}

data class GameInitData(
    var n: Int,
    var m: Int,
    var x: Int,
    var y: Int,
    var direction: Int
)