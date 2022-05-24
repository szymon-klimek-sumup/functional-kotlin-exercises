sealed class List<out A> {
    companion object {
        fun <A> of(vararg aa: A): List<A> {
            val tail = aa.sliceArray(1 until aa.size)
            return if (aa.isEmpty()) Nil else Cons(aa[0], of(*tail))
        }

        /**
         * Function for removing the first element of a List in constant time
         */
        fun <A> List<A>.tail(): List<A> = tail
    }

    object Nil : List<Nothing>()
    data class Cons<out A>(val head: A, val tail: List<A>) : List<A>()
}

fun main() {
    val ex1: List<Double> = List.Nil
    val ex2: List<Int> = List.Cons(1, List.Nil)
    val ex3: List<String> = List.Cons("a", List.Cons("b", List.Nil))
}
