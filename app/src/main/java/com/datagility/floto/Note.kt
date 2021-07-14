package com.datagility.floto

import kotlinx.serialization.Serializable
import java.time.Instant

@Serializable
data class Note(
    private val noteText: String,
    private val hasLocation: Boolean,
    private val latitude: Double,
    private val longitude: Double,
    @Serializable(with = InstantSerializer::class)
    private val noteDate: Instant
) {
    val text: String = noteText
}
