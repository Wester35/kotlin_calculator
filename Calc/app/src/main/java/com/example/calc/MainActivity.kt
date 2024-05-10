package com.example.calc

import android.content.pm.ActivityInfo
import android.health.connect.datatypes.units.Length
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
    private lateinit var str: String
    override fun onCreate(savedInstanceState: Bundle?) {
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
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
        str = "0"
        expr.movementMethod = ScrollingMovementMethod()
        expr.isActivated = true
        expr.isPressed = true

        var checker = true
        var check_dot = true
        ac.setOnClickListener {
            str = "0"
            exprText(str)
            expr.textSize = 45F
            result.textSize = 30F
            checker = true
            check_dot = true
            resultText()
        }
        plus_minus.setOnClickListener {
            if (!(str.endsWith("p")||str.endsWith("/")||str.endsWith("*")||str.endsWith("+")||str.endsWith("-")||str.endsWith("."))){
                val tmp = findLastNumber(str).toString()
                if (checker) {
                    checker = false
                    str = str.dropLast(tmp.length) + "(-" + tmp + ")"
                    exprText(str)
                    resultText()
                } else {
                    if (str.endsWith("(-" + tmp + ")")) {
                        str = str.dropLast(tmp.length + 3) + tmp
                    }
                    checker = true
                    exprText(str)
                    resultText()
                }
            }
        }
        percent.setOnClickListener {
            if (str.endsWith("p")||str.endsWith("/")||str.endsWith("*")||str.endsWith("+")||str.endsWith("-")||str.endsWith(".")){
                exprText(str)
            }else{
                str += "p"
                exprText(str)
            }
            checker = true
        }
        division.setOnClickListener {
            if (str.endsWith("/")||str.endsWith("*")||str.endsWith("+")||str.endsWith("-")||str.endsWith(".")){
                exprText(str)
            }else{
                str += "/"
                exprText(str)
            }
            check_dot = true
            checker = true
        }
        multiply.setOnClickListener {
            if (str.endsWith("/")||str.endsWith("*")||str.endsWith("+")||str.endsWith("-")||str.endsWith(".")){
                exprText(str)
            }else{
                str += "*"
                exprText(str)
            }
            check_dot = true
            checker = true
        }
        subtract.setOnClickListener {
            if (str.endsWith("+")||str.endsWith("-")||str.endsWith(".")){
                exprText(str)
            }else{
                str += "-"
                exprText(str)
            }
            check_dot = true
            checker = true
        }
        add.setOnClickListener {
            if (str.endsWith("/")||str.endsWith("*")||str.endsWith("+")||str.endsWith("-")||str.endsWith(".")){
                exprText(str)
            }else{
                str += "+"
                exprText(str)
            }
            check_dot = true
            checker = true
        }
        equal.setOnClickListener {
            expr.textSize = 30F
            result.textSize = 45F
        }
        dot.setOnClickListener {
            if (check_dot) {
                if (str.endsWith("p") || str
                        .endsWith("/") || str.endsWith("*") || str
                        .endsWith("+") || str.endsWith("-") || str
                        .endsWith(".")
                ) {
                    exprText(str)
                } else {
                    str += "."
                    exprText(str)
                    check_dot = false
                }
            }
        }
        one.setOnClickListener {
            if(str.startsWith("0")){
                str = str.replace("0", "") + "1"
                exprText(str)
                resultText()
            }else{
                str += "1"
                exprText(str)
                resultText()
            }
        }
        two.setOnClickListener {
            if(str.startsWith("0")){
                str = str.replace("0", "") + "2"
                exprText(str)
                resultText()
            }else{
                str += "2"
                exprText(str)
                resultText()
            }
        }
        three.setOnClickListener {
            if(str.startsWith("0")){
                str = str.replace("0", "") + "3"
                exprText(str)
                resultText()
            }else{
                str += "3"
                exprText(str)
                resultText()
            }
        }
        four.setOnClickListener {
            if(str.startsWith("0")){
                str = str.replace("0", "") + "4"
                exprText(str)
                resultText()
            }else{
                str += "4"
                exprText(str)
                resultText()
            }
        }
        five.setOnClickListener {
            if(str.startsWith("0")){
                str = str.replace("0", "") + "5"
                exprText(str)
                resultText()
            }else{
                str += "5"
                exprText(str)
                resultText()
            }
        }
        six.setOnClickListener {
            if(str.startsWith("0")){
                str = str.replace("0", "") + "6"
                exprText(str)
                resultText()
            }else{
                str += "6"
                exprText(str)
                resultText()
            }
        }
        seven.setOnClickListener {
            if(str.startsWith("0")){
                str = str.replace("0", "") + "7"
                exprText(str)
                resultText()
            }else{
                str += "7"
                exprText(str)
                resultText()
            }
        }
        eight.setOnClickListener {
            if(str.startsWith("0")){
                str = str.replace("0", "") + "8"
                exprText(str)
                resultText()
            }else{
                str += "8"
                exprText(str)
                resultText()
            }
        }
        nine.setOnClickListener {
            if(str.startsWith("0")){
                str = str.replace("0", "") + "9"
                exprText(str)
                resultText()
            }else{
                str += "9"
                exprText(str)
                resultText()
            }
        }
        zero.setOnClickListener {
            if(str.startsWith("0")){
                str = str.replace("0", "") + "0"
                exprText(str)
                resultText()
            }else{
                str += "0"
                exprText(str)
                resultText()
            }
        }
    }

    private fun findLastNumber(expression: String): String? {
        val regex = Regex("""(?=\d)(?:\d+(\.\d+)?)\b""")
        val matches = regex.findAll(expression)
        var lastMatch: MatchResult? = null
        for (match in matches) {
            lastMatch = match
        }
        return lastMatch?.value
    }

    private fun exprText(str:String){
        expr.text = str.replace("p", "%").replace("*", "×").replace("/", "÷")
    }

    private fun resultText(){
        val exp = str
        try {
            val _exp = ExpressionBuilder(exp).function(PercentFunction()).build()
            val res = _exp.evaluate()
            if (res.toString().endsWith(".0")){
                result.text = "=" + res.toString().replace(".0", "")
            }else{
                result.text = "=$res"
            }
        }catch (e:Exception){
            expr.text = str
            result.text = "NaN"
        }
    }
}