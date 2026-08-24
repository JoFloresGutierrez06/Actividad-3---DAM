package com.example.actividad1

fun getTaskStatus(completed: Boolean): String {
    return if (completed) {
        "Completada"
    } else {
        "Pendiente"
    }
}