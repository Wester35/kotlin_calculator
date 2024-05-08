package com.example.calc

import net.objecthunter.exp4j.function.Function

class PercentFunction : Function("p", 1) {
    override fun apply(vararg args: Double): Double {
        val value = args[0]
        return value / 100.0
    }
}