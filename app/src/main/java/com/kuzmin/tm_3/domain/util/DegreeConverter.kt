package com.kuzmin.tm_3.domain.util

import kotlin.math.absoluteValue

object DegreeConverter {

    fun fromDegMinSecToDecimal(degreeArray: IntArray): Double {
        val isNegative = degreeArray[0] < 0
        val degreeDecimal =
            degreeArray[0].absoluteValue + (degreeArray[1].toDouble() / 60) + (degreeArray[2].toDouble() / 3600)

        return if (isNegative) -degreeDecimal else degreeDecimal
    }

    fun fromDecimalToDegMinSec(value: Double?): IntArray {
        if (value == null) throw java.lang.RuntimeException("Degree value is null")
        val isNegative = value < 0
        val absValue = value.absoluteValue

        val degreeArray = IntArray(3)
        val degrees = absValue.toInt()
        val minutes = ((absValue - degrees) * 60).toInt()
        val seconds = (((absValue - degrees) * 60 - minutes) * 60).toInt()
        degreeArray[0] = if (isNegative) -degrees else degrees
        degreeArray[1] = minutes
        degreeArray[2] = seconds

        return degreeArray
    }
}