package com.datagility.floto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import dagger.hilt.android.AndroidEntryPoint
import io.ktor.client.*
import io.ktor.client.request.*
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject lateinit var client: NotesClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnSend = findViewById<Button>(R.id.btn_send)
        val txtNote = findViewById<EditText>(R.id.txt_note)

        btnSend.setOnClickListener {
            Toast.makeText(this@MainActivity, txtNote.text, Toast.LENGTH_SHORT).show()
        }
    }

    fun postNote(noteText: String) {
        client.post(noteText)
    }
}
