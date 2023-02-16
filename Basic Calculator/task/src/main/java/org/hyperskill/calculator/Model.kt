package org.hyperskill.calculator

interface Model {
    fun add(num: Double): Double
    fun sub(num: Double): Double
    fun mul(num: Double): Double
    fun div(num: Double): Double
    fun setNegative()
    fun restore()
    fun executeLastOperation(num: Double)
    fun getLastOperation(): Operation
    fun setLastOperation(operation: Operation)
    fun getValue(): Double
}