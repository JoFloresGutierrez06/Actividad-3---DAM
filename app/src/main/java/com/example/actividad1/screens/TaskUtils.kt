package com.example.actividad1


fun getTaskPriority(priority: Priority): String {
    return when (priority) {
        Priority.Baja -> "Baja"
        Priority.Media -> "Media"
        Priority.Alta -> "Alta"
    }
}