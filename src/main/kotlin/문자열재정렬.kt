import java.util.Scanner

fun main() = with(Scanner(System.`in`)) {
    val s = next()
    val chars = mutableListOf<Char>()
    var sum = 0
    s.toCharArray().forEach {
        if (it.code in 'A'.code .. 'Z'.code ) chars.add(it)
        else sum += Character.getNumericValue(it)
    }

    val result = chars.sortedBy { it }.joinToString("") + sum
    println(result)
}
