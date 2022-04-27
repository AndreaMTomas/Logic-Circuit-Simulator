package com.example.circuittester.data

open class Gate {
    var state : Boolean = false
    open fun execute(){}
}

class Not(private var input1 : Boolean = false) : Gate() {
    override fun execute(){
        state = !input1
    }
}

class And(private var input1: Boolean, private var input2 : Boolean) : Gate() {
    override fun execute() {
        state = input1 && input2
    }
}

class Or(private var input1: Boolean, private var input2: Boolean) : Gate() {
    override fun execute() {
        state = input1 || input2
    }
}

class Xor(private var input1: Boolean, private var input2: Boolean) : Gate() {
    override fun execute() {
        state = ((input1 && !input2) || (!input1 && input2))
    }
}
