package com.good.logintest.ui


import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import com.good.logintest.R
import com.good.logintest.base.BaseFragment
import com.good.logintest.databinding.FragmentLoginBinding
import com.good.logintest.delegate.ContextDelegateImpl
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : BaseFragment<FragmentLoginBinding>(R.layout.fragment_login) {

    private val loginViewModel by lazy { LoginViewModel(ContextDelegateImpl(context)) }

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
                Toast.makeText(requireContext(), "$it", Toast.LENGTH_SHORT).show()
            })
        }
    }
}
