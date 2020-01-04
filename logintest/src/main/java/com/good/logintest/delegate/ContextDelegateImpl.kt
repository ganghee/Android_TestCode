package com.good.logintest.delegate

import android.content.Context

class ContextDelegateImpl(private val context: Context?) : ContextDelegate {
    override fun getString(resId: Int): String = context?.getString(resId)!!
}