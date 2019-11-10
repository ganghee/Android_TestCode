package com.good.testcode

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.sdk27.coroutines.onClick

class MainActivity : AppCompatActivity() {

    private val viewModel by lazy { MainViewModel() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.onClick { observeText() }
    }

    fun observeText(): String? {
        viewModel.getText().postValue("Hello World")

        viewModel.getText().observe(this, Observer {
            main_text.text = it
        })

        return viewModel.getText().value
    }
}