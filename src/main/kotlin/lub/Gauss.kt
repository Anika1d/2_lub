package lub

import math.F
import math.F_
import math.factorial
import kotlin.math.abs

class Gauss(private val x: Double, list_: MutableList<MutableList<Double>>, private val step: Double) :
    Interpolation(x, list_, step) {
    override fun firstFun() {
        var index = 0
        while (x > list[0][index]) index += 1
        index -= 1
        val t = (x - list[0][index]) / step
        ans = list[1][index]
        var deltaT = t
        var count = 2
        var xn = index
        var n = 1
        while (xn > 0) {
            ans = (ans!! + list[count][xn] * deltaT / (count - 1).factorial()
                    + list[count + 1][xn - 1] * deltaT * (t - count / 2) / count.factorial())
            deltaT *= (t - count / 2) * (t + count / 2)
            count += 2
            xn -= 1
            n += 2
        }
        println("По первой формуле Гауса: \n\t $ans")
        println("Реальное значение:\n\t${F(x)}")
        initR1s(index = index, n = n)
    }

    override fun initR1s(index: Int, n: Int) {
        var w = 1.0
        var indexR = 0
        val listR = mutableListOf<Double>()
        if (index < list[0].size / 2)
            while (indexR <= n - 1) {
                w *= x - list[0][indexR]
                listR.add(
                    abs(
                        F_(list[0][indexR], n)
                    )
                )
                indexR += 1

            }
        else {
            while (list[0].size - n + indexR < list[0].size) {
                w *= x - list[0][indexR]
                listR.add(abs(F_(list[0][indexR], n)))
                indexR += 1
            }
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

    override fun secondFun() {
        var index = 0
        while (x > list[0][index]) index += 1
        val t = (x - list[0][index]) / step
        ans2 = list[1][index]
        var deltaT = t
        var count = 2
        var xn = index
        var n = 1
        while (count < list.size - 1) {
            ans2 =
                (ans2!! + list[count][xn - 1] * deltaT / (count - 1).factorial()
                        + list[count + 1][xn - 1] * deltaT * (t + count / 2) / count.factorial())
            deltaT*=(t-count/2)*(t+count/2)
            count+=2
            xn-=1
            n+=2
        }
        println("По второй формуле Гауса: \n\t $ans2")
        println("Реальное значение:\n\t${F(x)}")
        initR2s(index = index, n = n)
    }

    override fun initR2s(index: Int, n: Int) {
        var w = 1.0
        var indexR = 0
        val listR = mutableListOf<Double>()
        if (index < list[0].size / 2)
            while (indexR <= index) {
                w *= x - list[0][indexR]
                listR.add(
                    abs(
                        F_(list[0][indexR], n)
                    )
                )
                indexR += 1

            }
        else {
            while (list[0].size - n + indexR < list[0].size) {
                w *= x - list[0][indexR]
                listR.add(abs(F_(list[0][indexR], n)))
                indexR += 1
            }
        }
        R2MIN = abs(listR.min() * w / n.factorial())
        R2MAX = abs(listR.max() * w / n.factorial())
        R2N = abs(ans!! - F(x))
        if (listR.min() < 0 && w < 0) {
            val tmp = R2MAX
            R2MAX = R2MIN
            R2MIN = tmp
        }
        println("R2min:\t $R2MIN \n   R2max:\t $R2MAX   \n R2n: $R2N")
    }

    override fun answerSecond() {
        println(
            "R2 min: < R2n < R2 max ? \n" +
                    "$R2MIN < $R2N < $R2MAX  \n\t" +
                    if (R2MIN!! < R2N!! && R2N!! < R2MAX!!)
                        "true"
                    else
                        "false"
        )
    }


}