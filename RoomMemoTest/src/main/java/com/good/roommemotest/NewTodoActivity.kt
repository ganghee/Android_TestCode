
package com.example.android.roomwordssample

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import java.sql.Date
import java.text.SimpleDateFormat

class NewTodoActivity : AppCompatActivity() {

    private lateinit var editWordView: EditText
    private lateinit var editContent: EditText

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_word)
        editWordView = findViewById(R.id.edit_title)
        editContent = findViewById(R.id.edit_content)

        val button = findViewById<Button>(R.id.button_save)
        button.setOnClickListener {
            val replyIntent = Intent()
            if (TextUtils.isEmpty(editWordView.text)) {
                setResult(Activity.RESULT_CANCELED, replyIntent)
            } else {
                val title = editWordView.text.toString()
                val content = editContent.text.toString()
                val now: Long = System.currentTimeMillis()
                val mDate: Date = Date(now)
                val pattern = "yyyy-MM-dd"
                val simpleDate = SimpleDateFormat(pattern)
                val getTime: String = simpleDate.format(mDate)
                replyIntent.putExtra(EXTRA_TITLE, title)
                replyIntent.putExtra(EXTRA_CONTENT, content)
                replyIntent.putExtra(EXTRA_DATE, getTime)
                setResult(Activity.RESULT_OK, replyIntent)
            }
            finish()
        }
    }

    companion object {
        const val EXTRA_TITLE = "title"
        const val EXTRA_CONTENT = "content"
        const val EXTRA_DATE = "date"
    }
}

