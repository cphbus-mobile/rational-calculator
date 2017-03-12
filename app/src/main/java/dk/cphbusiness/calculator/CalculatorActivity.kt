package dk.cphbusiness.calculator

import android.app.Activity
import android.app.ListActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter

import dk.cphbusiness.template.R
import kotlinx.android.synthetic.main.activity_calculator.*

class CalculatorActivity : ListActivity() {
    var buffer: Int = 0
    var nextDigitClear = true
    // val stack: MutableList<Rational> = mutableListOf()
    val stack = Stack<Rational>();

    fun MutableList<Rational>.push(item: Rational) {
        this.add(item)
        }

    fun MutableList<Rational>.pop(): Rational {
        val result =  this[this.lastIndex]
        this.removeAt(this.lastIndex)
        return result
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)
        stack.push(Rational(22,7))
        listAdapter = ArrayAdapter<Rational>(
                this,
                android.R.layout.simple_list_item_1,
                stack
                )
        }

    private fun update() {
        nextDigitClear = true
        listView.invalidateViews()
        }

    private fun digit(d: Int) {
        if (nextDigitClear) buffer = d
        else buffer = 10*buffer + d
        textBuffer.text = buffer.toString()
        nextDigitClear = false
        }

    private fun enter() {
        stack.push(Rational(buffer,1))
        update()
        }

    private fun times() {
        val a = stack.pop()
        val b = if (nextDigitClear) stack.pop() else Rational(buffer,1)
        stack.push(a*b)
        update()
        }

    private fun div() {
        val a = stack.pop()
        val b = if (nextDigitClear) stack.pop() else Rational(buffer,1)
        stack.push(a/b)
        update()
        }

    private fun plus() {
        val a = stack.pop()
        val b = if (nextDigitClear) stack.pop() else Rational(buffer,1)
        stack.push(a + b)
        update()
        }

    private fun minus() {
        val a = stack.pop()
        val b = if (nextDigitClear) stack.pop() else Rational(buffer,1)
        stack.push(a - b)
        update()
        }

    fun buttonClicked(view: View) {
        when (view) {
            button0 -> digit(0)
            button1 -> digit(1)
            button2 -> digit(2)
            button3 -> digit(3)
            button4 -> digit(4)
            button5 -> digit(5)
            button6 -> digit(6)
            button7 -> digit(7)
            button8 -> digit(8)
            button9 -> digit(9)
            buttonEnter -> enter()
            buttonTimes -> times()
            buttonDiv -> div()
            buttonPlus -> plus()
            buttonMinus -> minus()
            }
        }

    }
