package com.good.roommemotest

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ContentActivity : AppCompatActivity() {

    private lateinit var title: TextView
    private lateinit var content: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content)
        val contentTitle = intent.getStringExtra(TodoListAdapter.EXTRA_TITLE)
        val contentContent = intent.getStringExtra(TodoListAdapter.EXTRA_CONTENT)
        title = this.findViewById(R.id.tv_content_title)
        content = this.findViewById(R.id.tv_content_content)
        title.text = contentTitle
        content.text = contentContent
    }
}