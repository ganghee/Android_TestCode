package com.good.roommemotest

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(entities = [Todo::class], version = 3, exportSchema = false)
abstract class TodoRoomDatabase : RoomDatabase() {

    abstract fun todoDao(): TodoDao

    companion object {
        @Volatile
        private var INSTANCE: TodoRoomDatabase? = null

        fun getDatabase(
                context: Context,
                scope: CoroutineScope
        ): TodoRoomDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                        context.applicationContext,
                        TodoRoomDatabase::class.java,
                        "todo_database"
                )
                        .fallbackToDestructiveMigration()
                        .addCallback(TodoDatabaseCallback(scope))
                        .build()
                INSTANCE = instance
                instance
            }
        }

        private class TodoDatabaseCallback(
                private val scope: CoroutineScope
        ) : RoomDatabase.Callback() {
            override fun onOpen(db: SupportSQLiteDatabase) {
                super.onOpen(db)
                INSTANCE?.let { database ->
                    scope.launch(Dispatchers.IO) {
                        populateDatabase(database.todoDao())
                    }
                }
            }
        }

        suspend fun populateDatabase(todoDao: TodoDao) {
            val todo = Todo("Hello", "content", "2020-01-01")
            todoDao.insert(todo)
        }
    }

}
