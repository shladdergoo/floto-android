package com.datagility.floto

import kotlinx.serialization.*

@Serializable
class Note(private val noteText: String) {

    val text: String = noteText
}
