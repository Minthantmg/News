package com.nara.news.db

import androidx.room.TypeConverters
import com.nara.news.model.Source

class Converters {

    @TypeConverters
    fun fromSource(source: Source): String{
        return source.name
    }

    @TypeConverters
    fun toSource(name: String): Source {
        return Source(name,name)
    }
}