package com.good.roommemotest

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "todo_table")
data class Todo(@PrimaryKey @ColumnInfo(name = "title") val title: String,
                @ColumnInfo(name = "content") val content: String,
                @ColumnInfo(name = "date") val date: String
)
