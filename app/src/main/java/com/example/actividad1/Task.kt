package com.example.actividad1

/*class Task {
}*/

// Clase Prioridad
enum class Priority {
    Baja, Media, Alta
}

// Clase de Tareas
data class Task(
    val id: Int,
    var title: String,
    var date: String,
    var priority: Priority,
    var description: String
)