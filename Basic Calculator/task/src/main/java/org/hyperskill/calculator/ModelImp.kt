package org.hyperskill.calculator

class ModelImp(private var firstTerm: Double, private var value: Double, private var lastOperation: Operation = Operation.NONE): Model {

    override fun setLastOperation(operation: Operation) {
        lastOperation = operation
    }

    override fun getLastOperation(): Operation {
        return lastOperation
    }

    override fun setNegative() {
        value = -value
    }

    override fun add(num: Double): Double {
        value += num
        return value
    }

    override fun sub(num: Double): Double {
        value -= num
        return value
    }

    override fun mul(num: Double): Double {
        value *= num
        return value
    }

    override fun div(num: Double): Double {
        value /= num
        return value
    }

    override fun restore() {
        firstTerm = 0.0;
        value = 0.0
        lastOperation = Operation.NONE
    }

    override fun getValue(): Double {
        return value
    }

    override fun executeLastOperation(num: Double) {
        when(this.lastOperation){
            Operation.NONE -> value = num
            Operation.ADD -> add(num)
            Operation.SUB -> sub(num)
            Operation.MUL -> mul(num)
            Operation.DIV -> div(num)
            Operation.EQUAL -> return
        }
    }
}