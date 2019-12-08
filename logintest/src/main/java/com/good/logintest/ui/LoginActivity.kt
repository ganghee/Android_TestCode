package com.good.logintest.ui

import android.os.Bundle
import com.good.logintest.R
import com.good.logintest.base.BaseActivity
import com.good.logintest.databinding.ActivityLoginBinding

class LoginActivity : BaseActivity<ActivityLoginBinding>(R.layout.activity_login) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        loginFragment()
    }

    private fun loginFragment() {
        supportFragmentManager
            .beginTransaction()
            .add(binding.fragmentContainer.id, LoginFragment())
            .commit()
    }
}
