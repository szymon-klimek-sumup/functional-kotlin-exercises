fun main(args: Array<String>) {
    println("Hello World!")

    // Exercise 2.1 Fibonacci
    println("fib(1..7) = [${fib(1)}, ${fib(2)}, ${fib(3)}, ${fib(4)}, ${fib(5)}, ${fib(6)}, ${fib(7)}]")

    // Exercise 2.2 "isSorted"
    println("isSorted(1, 2, 3) ASC: " + isSorted(listOf(1, 2, 3)) { a, b -> a < b })
    println("isSorted(3, 2, 1) DESC: " + isSorted(listOf(3, 2, 1)) { a, b -> a > b })
    println("isSorted(3, 1, 2) DESC: " + isSorted(listOf(3, 1, 2)) { a, b -> a > b })
}

/**
 * Exercise 2.1 Fibonacci
 */
fun fib(i: Int): Int {
    fun go(previousNumber: Int, currentNumber: Int, index: Int, endIndex: Int): Int {
        return if (index == endIndex) previousNumber
        else go(
            previousNumber = currentNumber,
            currentNumber = previousNumber + currentNumber,
            index = index + 1,
            endIndex = endIndex
        )
    }
    return go(previousNumber = 0, currentNumber = 1, index = 1, endIndex = i)
}

/**
 * Exercise 2.2 "isSorted" to check if list is sorted
 */
val <T> List<T>.tail: List<T>
    get() = drop(1)

val <T> List<T>.head: T
    get() = first()

tailrec fun <A> isSorted(aa: List<A>, order: (A, A) -> Boolean): Boolean =
    when {
        aa.size <= 1 -> true
        !order(aa.head, aa.tail.head) -> false
        else -> isSorted(aa.tail, order)
    }
