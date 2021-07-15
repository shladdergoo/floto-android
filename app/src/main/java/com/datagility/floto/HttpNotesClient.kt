package com.datagility.floto

import android.net.Uri
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import javax.inject.Inject

class HttpNotesClient @Inject constructor(
    private val http: OkHttpClient,
    private val network: Network,
    private val clientConfig: ClientConfig
) : NotesClient {

    override fun post(note: Note) {

        if (note.text == "") {
            return
        }

        val url =
            Uri.Builder().scheme(clientConfig.scheme).authority(clientConfig.authority)
                .appendPath("note").build().toString()

        val noteJson = Json.encodeToString(note)
        val body = noteJson.toRequestBody("application/json; charset=utf-8".toMediaType())
        val request = Request.Builder()
            .url(url)
            .post(body)
            .build()

        http.newCall(request).execute()
    }
}
