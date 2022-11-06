package lub

abstract class Interpolation(private val x: Double, list_: MutableList<MutableList<Double>>, private val step: Double) {

    var list: MutableList<MutableList<Double>> = mutableListOf()
    var ans: Double? = null
    var RMIN: Double? = null
    var RMAX: Double? = null
    var RN: Double? = null
    var ans2: Double? = null
    var R2MIN: Double? = null
    var R2MAX: Double? = null
    var R2N: Double? = null

    init {
        list.addAll(list_)
    }

    fun changeList(_list: MutableList<MutableList<Double>>) {
        list.clear()
        list.addAll(_list)
    }

    abstract fun firstFun()
    abstract fun initR1s(index: Int, n: Int)
    abstract fun answerFirst()

    abstract fun secondFun()
    abstract fun initR2s(index: Int, n: Int)
    abstract fun answerSecond()
}

