package math

import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.pow
import kotlin.math.sin



fun Int.factorial(): Long {
    var result = 1L
    for (i in 2..this) result *= i
    return result
}

fun F_(x: Double, rank: Int): Double {
    return if (rank == 1) {
        -PI * cos(PI * x) + 1
    } else if (rank % 2 == 0 && rank % 4 == 2) {
        PI.pow(rank) * sin(PI * x)
    } else if (rank % 2 == 1 && rank % 4 == 3) {
        PI.pow(rank) * cos(PI * x)
    } else if (rank % 2 == 0 && rank % 4 == 0) {
        -PI.pow(rank) * sin(PI * x)
    } else {
        -PI.pow(rank) * cos(PI * x)
    }
}
fun F(x: Double): Double {
    return x - sin(PI * x)
}