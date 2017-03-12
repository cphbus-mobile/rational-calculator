package dk.cphbusiness.calculator

import java.util.*

class Stack<T> : ArrayList<T>() {

    fun push(item: T) {
        add(item)
        }

    fun pop(): T {
        val item = this[size - 1]
        removeAt(size - 1)
        return item
        }

    }