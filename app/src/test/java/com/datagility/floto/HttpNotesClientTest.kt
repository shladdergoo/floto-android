package com.datagility.floto

import okhttp3.Call
import okhttp3.OkHttpClient
import org.junit.Test
import org.mockito.kotlin.*
import java.time.Instant

class HttpNotesClientTest {

    @Test
    fun post_empty_text_returns() {

        val mockHttp: OkHttpClient = mock()
        val mockCall: Call = mock()
        whenever(mockHttp.newCall(any())).thenReturn(mockCall)
        val mockNetwork: Network = mock()

        val sut = HttpNotesClient(mockHttp, mockNetwork, ClientConfig())
        sut.post(Note("", false, 0.0, 0.0, Instant.now()))

        verify(mockHttp, never()).newCall(any())
    }

    @Test
    fun post_some_text_makes_request() {

        val mockHttp: OkHttpClient = mock()
        val mockCall: Call = mock()
        whenever(mockHttp.newCall(any())).thenReturn(mockCall)
        val mockNetwork: Network = mock()

        val sut = HttpNotesClient(mockHttp, mockNetwork, ClientConfig())
        sut.post(Note("some text",false, 0.0, 0.0, Instant.now()))

        verify(mockHttp).newCall(any())
    }
}
