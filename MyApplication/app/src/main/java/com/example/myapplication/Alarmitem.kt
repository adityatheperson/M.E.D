package com.example.myapplication

import java.time.LocalDateTime

data class AlarmItem(
    val message: String,
    val time: LocalDateTime,
    val repeatInterval: Long // Add this line
)
