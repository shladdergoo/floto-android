package com.datagility.floto

import kotlinx.serialization.*

@Serializable
data class Note(
    private val noteText: String,
    private val hasLocation: Boolean,
    private val latitude: Double,
    private val longitude: Double
) {

    val text: String = noteText
}
