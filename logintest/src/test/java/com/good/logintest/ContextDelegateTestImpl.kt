package com.good.logintest

import android.content.Context
import com.good.logintest.delegate.ContextDelegate
import org.mockito.Mockito.mock

class ContextDelegateTestImpl : ContextDelegate{

    private val mockContext = mock(Context::class.java)

    override fun getString(resId: Int): String = mockContext.getString(resId)

}