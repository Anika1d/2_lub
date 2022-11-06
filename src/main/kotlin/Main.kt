import lub.Gauss
import lub.Newton
import math.F
import java.lang.Exception

fun main() {
    val a = 0.6
    val b = 1.1
    val steps = 10
    val x1 = 0.88
    val x2 = 0.63
    val x3 = 1.08
    val x4 = 0.83
    val step = (b - a) / steps
    val lists = mutableListOf<MutableList<Double>>()
    for (i in 0..steps + 1) {
        val tmpl = mutableListOf<Double>()
        for (j in 0..steps + 1)
            tmpl.add(0.0)
        lists.add(tmpl)
    }
    println("Таблица конечных разностей:")
    for (i in 0..steps) {
        lists[0][i] = a + i * step
        lists[1][i] = F(lists[0][i])
    }
    for (i in 0..steps + 1)
        for (k in 0..steps - 1 - i)
            lists[i + 2][k] = lists[i + 1][k + 1] - lists[i + 1][k]

    for (row in lists)
        println(row)
    println("=================Newton==============================")
    println("x*")
    val newton1 = Newton(x = x1, lists, step = step)
    newton1.firstFun()
    newton1.answerFirst()
    newton1.changeList(lists)
    newton1.secondFun()
    newton1.answerSecond()
    println("====================================================")
    println("x**")
    val newton2 = Newton(x = x2, lists, step = step)
    newton2.firstFun()
    newton2.answerFirst()
    newton2.changeList(lists)
    newton2.secondFun()
    newton2.answerSecond()
    println("====================================================")
    println("x***")
    val newton3 = Newton(x = x3, lists, step = step)
    newton3.firstFun()
    newton3.answerFirst()
    newton3.changeList(lists)
    newton3.secondFun()
    newton3.answerSecond()
    println("====================================================")
    println("x****")
    val newton4 = Newton(x = x4, list_ = lists, step = step)
    newton4.firstFun()
    newton4.answerFirst()
    newton4.changeList(lists)
    newton4.secondFun()
    newton4.answerSecond()
    println("=================Gauss==============================")

    try {
        println("x*")
        val gauss1 = Gauss(x = x1, lists, step = step)
        gauss1.firstFun()
        gauss1.answerFirst()
        gauss1.changeList(lists)
        gauss1.secondFun()
        gauss1.answerSecond()
        println("====================================================")
    } catch (e: Exception) {

    }


    try {
        println("x**")
        val gauss2 = Gauss(x = x2, lists, step = step)
        gauss2.firstFun()
        gauss2.answerFirst()
        gauss2.changeList(lists)
        gauss2.secondFun()
        gauss2.answerSecond()
        println("====================================================")
    } catch (e: Exception) {

    }
    try {
        println("x***")
        val gauss3 = Gauss(x = x3, lists, step = step)
        gauss3.firstFun()
        gauss3.answerFirst()
        gauss3.changeList(lists)
        gauss3.secondFun()
        gauss3.answerSecond()
        println("====================================================")
    } catch (e: Exception) {

    }
    try {
        println("x****")
        val gauss4 = Gauss(x = x4, lists, step = step)
        gauss4.firstFun()
        gauss4.answerFirst()
        gauss4.changeList(lists)
        gauss4.secondFun()
        gauss4.answerSecond()
        println("====================================================")
    } catch (e: Exception) {

    }

}