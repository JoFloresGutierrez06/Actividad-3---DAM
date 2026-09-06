package com.example.actividad1.screens

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.actividad1.Priority
import com.example.actividad1.Task

class TaskViewModel : ViewModel() {

    private val _tasks = mutableStateListOf(
        Task(1, "Comprar comida", "03/09/2026", Priority.Media, "Comprar comida en un local"),
        Task(2, "Estudiar Kotlin", "05/09/2026", Priority.Alta, "Hacer el modulo 5 de DAM"),
        Task(3, "Hacer ejercicio", "27/09/2026", Priority.Media, "Ir al gym para hacer rutina"),
        Task(4, "Comer yogurth", "02/09/2026", Priority.Baja, "Ir a comer yogurth a las 8"),
        Task(5, "Entregar la Actividad 2", "30/09/2026", Priority.Alta, "Entregar la actividad 2 de DAM")
    )
    
    val tasks: List<Task> get() = _tasks
    
    fun addTask(title: String, date: String, priority: Priority, description: String) {
        val newId = (_tasks.maxOfOrNull { it.id } ?: 0) + 1
        _tasks.add(Task(newId, title, date, priority, description))
    }

    // Función para borrar
    fun deleteTask(task: Task) {
        _tasks.remove(task)
    }

    // Función para editar
    fun editTask(id: Int, title: String, date: String, priority: Priority, description: String) {
        val index = _tasks.indexOfFirst { it.id == id }
        if (index != -1) {
            _tasks[index] = _tasks[index].copy(
                title = title,
                date = date,
                priority = priority,
                description = description
            )
        }
    }
}
