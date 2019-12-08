package com.good.logintest.ui


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer

import com.good.logintest.R
import com.good.logintest.base.BaseFragment
import com.good.logintest.databinding.FragmentLoginBinding
import com.good.logintest.util.isValidEmail
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : BaseFragment<FragmentLoginBinding>(R.layout.fragment_login) {

    private val loginViewModel by lazy { LoginViewModel() }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        binding.viewModel = loginViewModel
        observeViewModel()
    }

    private fun observeViewModel() {
        loginViewModel.apply {
            id.observe(this@LoginFragment, Observer {
                isEmail(it)
                isLoginSelected()
                button_login.isSelected = isButtonSelected.value!!
            })

            pw.observe(this@LoginFragment, Observer {
                isMoreSix(it)
                isLoginSelected()
                button_login.isSelected = isButtonSelected.value!!
            })
            nextState.observe(this@LoginFragment, Observer {
                Toast.makeText(requireContext(),"$it",Toast.LENGTH_SHORT).show()
            })
        }
    }
}
