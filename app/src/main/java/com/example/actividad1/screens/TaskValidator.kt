package com.example.actividad1

class InvalidTaskException(message: String) : Exception(message)

interface Validator {
    fun isValid(text: String): Boolean
}

object TaskValidator : Validator {

    override fun isValid(text: String): Boolean {
        if (text.isBlank()) {
            throw InvalidTaskException("El título no puede estar vacío")
        }

        return true
    }
}