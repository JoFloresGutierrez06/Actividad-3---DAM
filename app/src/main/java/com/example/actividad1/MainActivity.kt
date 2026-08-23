package com.example.actividad1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import com.example.actividad1.ui.theme.Actividad1Theme
import com.example.actividad1.screens.TaskListScreen //Importar la otra pantalla

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {

            Actividad1Theme {

                val tasks = remember {
                    mutableStateListOf(
                        Task(1, "Comprar comida", false),
                        Task(2, "Estudiar Kotlin", false),
                        Task(3, "Hacer ejercicio", true),
                        Task(4, "Comer yogurth", false)
                    )
                }

                TaskListScreen(
                    tasks = tasks,
                    onCompletedChange = { task, completed ->

                        val index =
                            tasks.indexOfFirst { it.id == task.id }

                        tasks[index] =
                            task.copy(completed = completed)
                    }
                )
            }
        }
    }
}