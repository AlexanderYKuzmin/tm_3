package com.kuzmin.tm_3.domain.util

class Coordinates constructor(){
    private var latitude: Double? = null
    private var longitude: Double? = null

    constructor(latitude: Double, longitude: Double) : this() {
        this.latitude = latitude
        this.longitude = longitude
    }

    /*constructor(coordinatesString: String) : this() {
        coordinatesString.split(' ')
    }*/

    fun asDecimalString() = "$latitude $longitude"

    fun asDegMinSecString():String? {
        if (latitude == null || longitude == null) return null
        val degreeArrayLatitude = DegreeConverter.fromDecimalToDegMinSec(latitude)
        val degreeArrayLongitude = DegreeConverter.fromDecimalToDegMinSec(longitude)
        return "${degreeArrayLatitude[0]}\u00B0${degreeArrayLatitude[1]}\'${degreeArrayLatitude[2]}\" " +
                "${degreeArrayLongitude[0]}°${degreeArrayLongitude[1]}'${degreeArrayLongitude[2]}\""
    }
}