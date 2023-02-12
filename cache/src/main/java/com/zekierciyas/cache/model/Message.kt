package com.zekierciyas.cache.model

import java.util.*

data class Message(
    val text: String,
    val type: MessageType,
    var epochTimeMs: Long = Date().time
)

enum class MessageType {
    SENT,
    RECEIVED
}
