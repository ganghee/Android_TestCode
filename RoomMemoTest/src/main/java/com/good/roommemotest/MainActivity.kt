package com.good.roommemotest

import android.annotation.TargetApi
import android.app.Activity
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private val newTodoActivityRequestCode = 1
    private lateinit var todoViewModel: TodoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        val adapter = TodoListAdapter(this)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        todoViewModel = ViewModelProvider(this).get(TodoViewModel::class.java)

        todoViewModel.allWords.observe(this, Observer { words ->
            words?.let { adapter.setWords(it) }
        })

        val fab = findViewById<FloatingActionButton>(R.id.fab)
        fab.setOnClickListener {
            val intent = Intent(this@MainActivity, NewTodoActivity::class.java)
            startActivityForResult(intent, newTodoActivityRequestCode)
        }
    }

    @TargetApi(Build.VERSION_CODES.O)
    override fun onActivityResult(requestCode: Int, resultCode: Int, intentData: Intent?) {
        super.onActivityResult(requestCode, resultCode, intentData)

        if (requestCode == newTodoActivityRequestCode && resultCode == Activity.RESULT_OK) {

            val title = intentData!!.getStringExtra(NewTodoActivity.EXTRA_TITLE)
            val content = intentData.getStringExtra(NewTodoActivity.EXTRA_CONTENT)
            val date = intentData.getStringExtra(NewTodoActivity.EXTRA_DATE)
            val word = Todo(title, content, date)
            todoViewModel.insert(word)
        } else {
            Toast.makeText(
                applicationContext,
                R.string.empty_not_saved,
                Toast.LENGTH_LONG
            ).show()
        }
    }
}
