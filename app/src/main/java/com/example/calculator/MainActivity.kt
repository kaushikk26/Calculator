package com.example.calculator

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import kotlin.NullPointerException
import kotlin.NumberFormatException
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    lateinit var ftextview:TextView
    lateinit var textview: TextView
    lateinit var one: Button
    lateinit var two: Button
    lateinit var three: Button
    lateinit var four: Button
    lateinit var five: Button
    lateinit var six: Button
    lateinit var seven: Button
    lateinit var eight: Button
    lateinit var nine: Button
    lateinit var zero: Button
    lateinit var point: Button
    lateinit var pluse: Button
    lateinit var equal: Button
    lateinit var clear: Button
    lateinit var minus: Button
    lateinit var per: Button
    lateinit var multi: Button
    lateinit var div: Button
    lateinit var delete: Button
    lateinit var plusminus: Button

    var array = ArrayList<Button>()

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ftextview=findViewById(R.id.ftext)
        textview=findViewById(R.id.text)

        one = findViewById(R.id.one)
        two = findViewById(R.id.two)
        three = findViewById(R.id.three)
        four = findViewById(R.id.four)
        five = findViewById(R.id.five)
        six = findViewById(R.id.six)
        seven = findViewById(R.id.seven)
        eight = findViewById(R.id.eight)
        nine = findViewById(R.id.nine)
        zero = findViewById(R.id.zero)
        point = findViewById(R.id.point)
        clear = findViewById(R.id.clear)
        pluse = findViewById(R.id.plus)
        minus = findViewById(R.id.minus)
        multi = findViewById(R.id.multiply)
        div = findViewById(R.id.div)
        equal = findViewById(R.id.equals)
        per = findViewById(R.id.percent)
        delete = findViewById(R.id.delet)
        plusminus = findViewById(R.id.plusminus)


        array.add(one)
        array.add(two)
        array.add(three)
        array.add(four)
        array.add(five)
        array.add(six)
        array.add(seven)
        array.add(eight)
        array.add(nine)
        array.add(zero)
        array.add(plusminus)
        array.add(point)
        array.add(pluse)
        array.add(equal)
        array.add(clear)
        array.add(minus)
        array.add(multi)
        array.add(div)
        array.add(per)
        array.add(delete)

        click(0)
        click(1)
        click(2)
        click(3)
        click(4)
        click(5)
        click(6)
        click(7)
        click(8)
        click(9)
        click(10)
        click(11)
        click(12)
        click(13)
        click(14)
        click(15)
        click(16)
        click(17)
        click(18)
        click(19)
    }

    var firstvalue = 0.0
    var secondvalue = 0.0
    var tempvalue = 0.0
    var anss = 0.0

    fun click(i: Int) {
        array[i].setOnClickListener {

            if (array[i].text.toString().equals("+") || array[i].text.toString()
                    .equals("-") || array[i].text.toString().equals("*") || array[i].text.toString()
                    .equals("/")
            ) {
                try {
                    procees(array[i].text.toString(), i)
                } catch (i: Exception) {

                }
            } else if (array[i].text.toString().equals("=")) {
                try {
                    answer(i)
                } catch (i: Exception) {

                }

            } else if (array[i].text.toString().equals("AC")) {
                firstvalue = 0.0
                secondvalue = 0.0
                tempvalue = 0.0
                anss = 0.0
                textview.setText("")
                ftextview.setText("")
                OperatorSign.plus = false
                OperatorSign.minus = false
                OperatorSign.multi = false
                OperatorSign.div = false
            } else if (array[i].text.toString().equals(".")) {
                if (1 > textview.text.indexOf(".")) {
                    if (textview.text.isEmpty()) {
                        textview.setText(textview.text.toString() + "0.")
                    } else {
                        textview.setText(textview.text.toString() + ".")
                    }
                }
            } else if (array[i].text.toString().equals("%")) {
                try {
                    firstvalue = textview.text.toString().toDouble() / 100
                    textview.setText(firstvalue.toString())
                } catch (i: Exception) {

                }
            } else if (array[i].text.toString().equals("D")) {
                try {
                    textview.setText(textview.text.substring(0, textview.text.length - 1))
                } catch (i: Exception) {

                }
            } else if (array[i].text.toString().equals("0")) {

                if (textview.text.toString().isEmpty()) {
                    textview.setText("0")
                } else if (textview.text.equals("0")) {
                    textview.setText("0")
                } else if (textview.text.toString() != "0") {
                    textview.setText(textview.text.toString() + "0")
                }

            } else if (array[i].text.toString().equals("+/-")) {

                if (textview.text.isEmpty()) {
                    textview.setText("-")
                } else if (textview.text.startsWith("-")) {
                    textview.setText(textview.text.substring(1))
                } else {
                    textview.setText("-" + textview.text)
                }
            } else {
                textview.setText(textview.text.toString() + array[i].text)
            }
        }
    }

    private fun answer(i: Int) {
        secondvalue = textview.text.toString().toDouble()

        if (OperatorSign.plus) {
            anss = firstvalue + secondvalue
            ftextview.text="$firstvalue"+"$secondvalue"
        } else if (OperatorSign.minus) {
            anss = firstvalue - secondvalue
            ftextview.text="$firstvalue"+"-"+"$secondvalue"
        } else if (OperatorSign.multi) {
            anss = firstvalue * secondvalue
            ftextview.text="$firstvalue"+"*"+"$secondvalue"
        } else if (OperatorSign.div) {
            anss = firstvalue / secondvalue
            ftextview.text="$firstvalue"+"/"+"$secondvalue"
        }
        textview.setText(anss.toString())
        firstvalue = 0.0
        secondvalue = 0.0
        anss = 0.0
        OperatorSign.plus = false
        OperatorSign.minus = false
        OperatorSign.multi = false
        OperatorSign.div = false


    }

    private fun procees(s: String, i: Int) {

        tempvalue = textview.text.toString().toDouble()

        if (OperatorSign.plus) {
            firstvalue = tempvalue + firstvalue
        } else if (OperatorSign.minus) {
            firstvalue = tempvalue - firstvalue
        } else if (OperatorSign.multi) {
            firstvalue = tempvalue * firstvalue
        } else if (OperatorSign.div) {
            firstvalue = tempvalue / firstvalue
        } else {
            firstvalue = tempvalue
        }

        if (array[i].text.toString().equals("+")) {
            OperatorSign.plus = true
        } else if (array[i].text.toString().equals("-")) {
            OperatorSign.minus = true
        } else if (array[i].text.toString().equals("*")) {
            OperatorSign.multi = true
        } else if (array[i].text.toString().equals("/")) {
            OperatorSign.div = true
        }

        textview.setText("")
    }
}

class OperatorSign {
    companion object {
        var plus: Boolean = false
        var minus: Boolean = false
        var multi: Boolean = false
        var div: Boolean = false
    }
}
