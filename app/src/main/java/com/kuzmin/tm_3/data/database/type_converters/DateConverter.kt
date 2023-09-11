package com.kuzmin.tm_3.data.database.type_converters

import androidx.room.TypeConverter
import java.util.Date

class DateConverter {
    @TypeConverter
    fun toDate(dateLong:Long): Date {
        return Date(dateLong)
    }

    @TypeConverter
    fun fromDate(date: Date): Long{
        return date.time;
    }
}