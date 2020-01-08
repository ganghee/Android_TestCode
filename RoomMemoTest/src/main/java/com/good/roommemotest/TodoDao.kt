package com.good.roommemotest

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

@Dao
interface TodoDao {
    @Query("SELECT * from todo_table ORDER BY title ASC")
    fun getAlphabetizedWords(): LiveData<List<Todo>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(todo: Todo)

    @Query("DELETE FROM todo_table")
    suspend fun deleteAll()
}
