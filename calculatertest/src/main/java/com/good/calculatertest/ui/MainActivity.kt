package com.good.calculatertest.ui

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.good.calculatertest.R
import com.good.calculatertest.base.BaseActivity
import com.good.calculatertest.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    private val mainViewModel by lazy {
        ViewModelProviders.of(this@MainActivity).get(MainViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.viewModel = mainViewModel
        observeViewModel()
    }

    private fun observeViewModel() {
        mainViewModel.apply {
            firstNum.observe(this@MainActivity, Observer {
                textview_result.text = calc(textView_indicator.text.toString()).toString()
            })

            secondNum.observe(this@MainActivity, Observer {
                textview_result.text = calc(textView_indicator.text.toString()).toString()
            })
        }
    }
}
