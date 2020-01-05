package com.good.logintest.delegate

import androidx.annotation.StringRes

interface ContextDelegate{
    fun getString(@StringRes resId: Int) : String
}