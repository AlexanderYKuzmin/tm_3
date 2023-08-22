package com.kuzmin.tm_3.extensions

import java.text.SimpleDateFormat
import java.util.*

fun Date.formatToDate(): String {
    val sdf = SimpleDateFormat("dd.MM.yyyy", Locale.getDefault())
    return sdf.format(this)
}

fun Date.formatToDateTime(): String {
    val sdf= SimpleDateFormat("dd-MM-yyyy HH:mm", Locale.getDefault())
    return sdf.format(this)
}

fun Date.formatToTime(): String {
    val sdf= SimpleDateFormat("HH:mm", Locale.getDefault())
    return sdf.format(this)
}

fun Date.formatToDateTimeUpToSeconds(): String {
    val sdf= SimpleDateFormat("dd-MM-yyyy HH:mm:ss", Locale.getDefault())
    return sdf.format(this)
}

fun Date.hours(): Int {
    return (this.time / (3600 * 1000)).toInt()
}



