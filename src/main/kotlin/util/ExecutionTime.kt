package util

import kotlin.time.ExperimentalTime
import kotlin.time.measureTimedValue

object ExecutionTime {
    @OptIn(ExperimentalTime::class)
    operator fun invoke(block: () -> Unit) {
        val timedValue = measureTimedValue { block() }
        println("수행시간: ${timedValue.duration.inWholeMilliseconds}ms")
    }
}