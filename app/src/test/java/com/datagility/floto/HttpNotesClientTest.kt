package com.datagility.floto

import okhttp3.Call
import okhttp3.OkHttpClient
import org.junit.Test
import org.mockito.kotlin.*

class HttpNotesClientTest {

    @Test
    fun post_empty_text_returns() {

        val mockHttp: OkHttpClient = mock()
        val mockCall: Call = mock()
        whenever(mockHttp.newCall(any())).thenReturn(mockCall)

        val sut = HttpNotesClient(mockHttp, ClientConfig())
        sut.post(Note(""))

        verify(mockHttp, never()).newCall(any())
    }

    @Test
    fun post_some_text_makes_request() {

        val mockHttp: OkHttpClient = mock()
        val mockCall: Call = mock()
        whenever(mockHttp.newCall(any())).thenReturn(mockCall)

        val sut = HttpNotesClient(mockHttp, ClientConfig())
        sut.post(Note("some text"))

        verify(mockHttp).newCall(any())
    }
}
