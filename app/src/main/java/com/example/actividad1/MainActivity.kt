package com.example.actividad1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import com.example.actividad1.ui.theme.Actividad1Theme
import com.example.actividad1.screens.TaskListScreen //Importar la otra pantalla
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.actividad1.screens.TaskDetailScreen

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {

            Actividad1Theme {

                val navController = rememberNavController()

                val tasks = remember {
                    mutableStateListOf(
                        Task(1, "Comprar comida", false),
                        Task(2, "Estudiar Kotlin", false),
                        Task(3, "Hacer ejercicio", true),
                        Task(4, "Comer yogurth", false)
                    )
                }

                NavHost(
                    navController = navController,
                    startDestination = "lista"
                ) {

                    composable("lista") {

                        TaskListScreen(
                            tasks = tasks,

                            onCompletedChange = { task, completed ->

                                val index =
                                    tasks.indexOfFirst { it.id == task.id }

                                tasks[index] =
                                    task.copy(completed = completed)
                            },

                            onTaskClick = { task ->
                                navController.navigate("detalle/${task.id}")
                            }
                        )
                    }

                    composable("detalle/{id}") {

                        val id = it.arguments?.getString("id")?.toIntOrNull()

                        val task = tasks.find { task ->
                            task.id == id
                        }

                        if (task != null) {
                            TaskDetailScreen(
                                task = task,
                                onBack = {
                                    navController.popBackStack()
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}