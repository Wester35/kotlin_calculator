package com.example.calc

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import net.objecthunter.exp4j.ExpressionBuilder


class MainActivity : AppCompatActivity() {
    private lateinit var expr: TextView
    private lateinit var result: TextView
    private lateinit var ac: Button
    private lateinit var plus_minus: Button
    private lateinit var percent: Button
    private lateinit var division: Button
    private lateinit var multiply: Button
    private lateinit var subtract: Button
    private lateinit var add: Button
    private lateinit var equal: Button
    private lateinit var dot: Button
    private lateinit var one: Button
    private lateinit var two: Button
    private lateinit var three: Button
    private lateinit var four: Button
    private lateinit var five: Button
    private lateinit var six: Button
    private lateinit var seven: Button
    private lateinit var eight: Button
    private lateinit var nine: Button
    private lateinit var zero: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        expr = findViewById(R.id.expr)
        result = findViewById(R.id.res)
        ac = findViewById(R.id.ac)
        plus_minus = findViewById(R.id.plus_minus)
        percent = findViewById(R.id.percent)
        division = findViewById(R.id.div)
        multiply = findViewById(R.id.multiply)
        subtract = findViewById(R.id.minuse)
        add = findViewById(R.id.plus)
        equal = findViewById(R.id.equal)
        dot = findViewById(R.id.dot)
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

        expr.movementMethod = ScrollingMovementMethod()
        expr.isActivated = true
        expr.isPressed = true

        var str:String
        var checker = true
        var check_dot = true
        ac.setOnClickListener {
            exprText("0")
            expr.textSize = 45F
            result.textSize = 30F
            checker = true
            check_dot = true
            resultText()
        }
        plus_minus.setOnClickListener {
            str = expr.text.toString()
            if (checker){
                checker = false
                str = "-(" + str + ")"
                exprText(str)
                resultText()
            }else{
                if (str.length >= 3 && str.startsWith("-(") && str.endsWith(")")) {
                    str = str.substring(2).dropLast(1)
                }
                checker = true
                exprText(str)
                resultText()
            }
        }
        percent.setOnClickListener {
            if (expr.text.toString().endsWith("p")||expr.text.toString().endsWith("/")||expr.text.toString().endsWith("*")||expr.text.toString().endsWith("+")||expr.text.toString().endsWith("-")||expr.text.toString().endsWith(".")){
                str = expr.text.toString()
                exprText(str)
            }else{
                str = expr.text.toString() + "p"
                exprText(str)
            }
        }
        division.setOnClickListener {
            if (expr.text.toString().endsWith("/")||expr.text.toString().endsWith("*")||expr.text.toString().endsWith("+")||expr.text.toString().endsWith("-")||expr.text.toString().endsWith(".")){
                str = expr.text.toString()
                exprText(str)
            }else{
                str = expr.text.toString() + "/"
                exprText(str)
            }
            check_dot = true

        }
        multiply.setOnClickListener {
            if (expr.text.toString().endsWith("/")||expr.text.toString().endsWith("*")||expr.text.toString().endsWith("+")||expr.text.toString().endsWith("-")||expr.text.toString().endsWith(".")){
                str = expr.text.toString()
                exprText(str)
            }else{
                str = expr.text.toString() + "*"
                exprText(str)
            }
            check_dot = true

        }
        subtract.setOnClickListener {
            if (expr.text.toString().endsWith("+")||expr.text.toString().endsWith("-")||expr.text.toString().endsWith(".")){
                str = expr.text.toString()
                exprText(str)
            }else{
                str = expr.text.toString() + "-"
                exprText(str)
            }
            check_dot = true

        }
        add.setOnClickListener {
            if (expr.text.toString().endsWith("/")||expr.text.toString().endsWith("*")||expr.text.toString().endsWith("+")||expr.text.toString().endsWith("-")||expr.text.toString().endsWith(".")){
                str = expr.text.toString()
                exprText(str)
            }else{
                str = expr.text.toString() + "+"
                exprText(str)
            }
            check_dot = true
        }
        equal.setOnClickListener {
            expr.textSize = 30F
            result.textSize = 45F
        }
        dot.setOnClickListener {
            if (check_dot) {
                if (expr.text.toString().endsWith("p") || expr.text.toString()
                        .endsWith("/") || expr.text.toString().endsWith("*") || expr.text.toString()
                        .endsWith("+") || expr.text.toString().endsWith("-") || expr.text.toString()
                        .endsWith(".")
                ) {
                    str = expr.text.toString()
                    exprText(str)
                } else {
                    str = expr.text.toString() + "."
                    exprText(str)
                    check_dot = false
                }
            }
        }
        one.setOnClickListener {
            if(expr.text.toString().startsWith("0")){
                str = expr.text.toString().replace("0", "") + "1"
                exprText(str)
                resultText()
            }else{
                str = expr.text.toString() + "1"
                exprText(str)
                resultText()
            }
        }
        two.setOnClickListener {
            if(expr.text.toString().startsWith("0")){
                str = expr.text.toString().replace("0", "") + "2"
                exprText(str)
                resultText()
            }else{
                str = expr.text.toString() + "2"
                exprText(str)
                resultText()
            }
        }
        three.setOnClickListener {
            if(expr.text.toString().startsWith("0")){
                str = expr.text.toString().replace("0", "") + "3"
                exprText(str)
                resultText()
            }else{
                str = expr.text.toString() + "3"
                exprText(str)
                resultText()
            }
        }
        four.setOnClickListener {
            if(expr.text.toString().startsWith("0")){
                str = expr.text.toString().replace("0", "") + "4"
                exprText(str)
                resultText()
            }else{
                str = expr.text.toString() + "4"
                exprText(str)
                resultText()
            }
        }
        five.setOnClickListener {
            if(expr.text.toString().startsWith("0")){
                str = expr.text.toString().replace("0", "") + "5"
                exprText(str)
                resultText()
            }else{
                str = expr.text.toString() + "5"
                exprText(str)
                resultText()
            }
        }
        six.setOnClickListener {
            if(expr.text.toString().startsWith("0")){
                str = expr.text.toString().replace("0", "") + "6"
                exprText(str)
                resultText()
            }else{
                str = expr.text.toString() + "6"
                exprText(str)
                resultText()
            }
        }
        seven.setOnClickListener {
            if(expr.text.toString().startsWith("0")){
                str = expr.text.toString().replace("0", "") + "7"
                exprText(str)
                resultText()
            }else{
                str = expr.text.toString() + "7"
                exprText(str)
                resultText()
            }
        }
        eight.setOnClickListener {
            if(expr.text.toString().startsWith("0")){
                str = expr.text.toString().replace("0", "") + "8"
                exprText(str)
                resultText()
            }else{
                str = expr.text.toString() + "8"
                exprText(str)
                resultText()
            }
        }
        nine.setOnClickListener {
            if(expr.text.toString().startsWith("0")){
                str = expr.text.toString().replace("0", "") + "9"
                exprText(str)
                resultText()
            }else{
                str = expr.text.toString() + "9"
                exprText(str)
                resultText()
            }
        }
        zero.setOnClickListener {
            if(expr.text.toString().startsWith("0")){
                str = expr.text.toString().replace("0", "") + "0"
                exprText(str)
                resultText()
            }else{
                str = expr.text.toString() + "0"
                exprText(str)
                resultText()
            }
        }
    }

    private fun exprText(str:String){
        expr.text = str//.replace("per", "٪")
    }

    private fun resultText(){
        val exp = expr.text.toString()
        try {
            val _exp = ExpressionBuilder(exp).function(PercentFunction()).build()
            val res = _exp.evaluate()
            if (res.toString().endsWith(".0")){
                result.text = "=" + res.toString().replace(".0", "")
            }else{
                result.text = "=$res"
            }
        }catch (e:Exception){
            expr.text = expr.text.toString()
            result.text = expr.text.toString()
        }
    }
}