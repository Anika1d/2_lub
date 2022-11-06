package lub

import math.factorial
import math.F
import math.F_
import kotlin.math.abs

class Newton(private val x: Double, list_: MutableList<MutableList<Double>>, private val step: Double):
    Interpolation(x, list_, step) {
    override fun firstFun() {
        var index = 0
        while (x > list[0][index]) {
            index += 1
        }
        index -= 1
        val t = (x - list[0][index]) / step
        ans = list[1][index]
        var deltaT = t
        var count = 2
        var n = 1
        while (count < list.size - index) {
            ans = ans!! + list[count][index] * deltaT / (count - 1).factorial()
            count += 1
            deltaT *= (t - count + 2)
            n += 1
        }

        println("По первой формуле Ньютона: \n\t $ans")
        println("Реальное значение:\n\t${F(x)}")
        initR1s(index = index, n = n)
    }

    override  fun initR1s(
        index: Int,
        n: Int,
    ) {
        var indexR = index
        var w = 1.0
        val listR = mutableListOf<Double>()
        while (indexR < list[0].size) {
            w *= (x - list[0][indexR])
            listR.add(abs(F_(list[0][indexR], n)))
            indexR += 1
        }
        RMIN = abs(listR.min() * w / n.factorial())
        RMAX = abs(listR.max() * w / n.factorial())
        RN = abs(ans!! - F(x))
        if (listR.min() < 0 && w < 0) {
            val tmp = RMAX
            RMAX = RMIN
            RMIN = tmp
        }
        println("R1min:\t $RMIN \n   R1max:\t $RMAX   \n R1n: $RN")

    }

   override fun answerFirst() {
        println(
            "R min: < Rn < R max ? \n" +
                    "$RMIN < $RN < $RMAX  \n\t" +
                    if (RMIN!! < RN!! && RN!! < RMAX!!)
                        "true"
                    else
                        "false"
        )
    }


    override fun secondFun(
    ) {
        var index = 0
        while (x > list[0][index]) index += 1
        val t = (x - list[0][index]) / step
        ans2 = list[1][index]
        var deltaT = t
        var m = 1
        var xn2 = index
        var n = 1
        while (m + 1 < index + 2) {
            ans2 = ans2!! + list[m + 1][xn2 - 1] * deltaT / m.factorial()
            m += 1
            deltaT *= (t + m - 1)
            xn2 -= 1
            n += 1
        }

        println("По второй формуле Ньютона:\n\t$ans2")
        println("Реальное значение:\n\t${F(x)}")
        initR2s(index = index, n = n)
    }


     override  fun initR2s(
        index: Int,
        n: Int
    ) {
        var indexR = 0
        var w = 1.0
        val listR = emptyList<Double>().toMutableList()
        while (indexR <= index) {
            w *= (x - list[0][indexR])
            listR.add(abs(F_(list[0][indexR], n)))
            indexR += 1
        }
        R2MIN = abs(listR.min() * w / n.factorial())
        R2MAX = abs(listR.max() * w / n.factorial())
        R2N = abs(ans2!! - F(x))
        if (listR.min() < 0 && w < 0) {
            val tmp = R2MAX
            R2MAX = R2MIN
            R2MIN = tmp
        }
        println("R2min:\t $R2MIN \n   R2max:\t $R2MAX   \n R2n: $R2N")
    }

    override fun answerSecond() {
        println(
            "R min: < Rn < R max ?\n" +
                    "$R2MIN < $R2N < $R2MAX  \n\t" +
                    if (R2MIN!! < R2N!! && R2N!! < R2MAX!!)
                        "true"
                    else
                        "false"
        )
    }
}


