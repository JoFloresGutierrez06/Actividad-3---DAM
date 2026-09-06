package com.example.actividad1

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class InvalidTaskException(message: String) : Exception(message)

interface Validator {
    fun isValid(text: String): Boolean
}

// Función de validación normal (NO es @Composable)
fun getValidationError(title: String, date: String, description: String): String? {
    // Validaciones de campos vacios
    if (title.isBlank()) return "¡Título requerido! No puede haber ningun campo vacío"
    if (description.isBlank()) return "¡Descripción requerida! No puede haber ningun campo vacío"
    if (date.isBlank()) return "¡Fecha requerida! No puede haber ningun campo vacío"
    
    // Validación de fecha futura
    try {
        val formatter = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        val taskDate = formatter.parse(date)
        // Obtenemos hoy sin la hora para comparar solo el día
        val todayStr = formatter.format(Date())
        val today = formatter.parse(todayStr)
        
        if (taskDate != null && today != null && taskDate.before(today)) {
            return "¡La fecha no puede ser en el pasado!"
        }
    } catch (e: Exception) {
        return "Formato de fecha inválido"
    }

    return null
}
